package sda.tema.SDA_Tema_4.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.exceptions.BuyTicketHadFailedException;
import sda.tema.SDA_Tema_4.exceptions.FlightHadDisappearedException;
import sda.tema.SDA_Tema_4.exceptions.NoMoreHotelRoomsException;
import sda.tema.SDA_Tema_4.repository.entitys.Room;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.security.entitys.User;
import sda.tema.SDA_Tema_4.utils.DiscountHelper;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final TripService tripService;
    private final RoomService roomService;
    private final TripDetailsService tripDetailsService;
    private final UserService userService;
    private final FlightService flightService;
    public static final Long DEFAULT_ID = 0L;

    public PaymentService(UserService userService,
                          TripService tripService,
                          TripDetailsService tripDetailsService,
                          FlightService flightService,
                          RoomService roomService) {
        this.userService = userService;
        this.tripService = tripService;
        this.tripDetailsService = tripDetailsService;
        this.flightService = flightService;
        this.roomService = roomService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {BuyTicketHadFailedException.class,
            FlightHadDisappearedException.class, NoMoreHotelRoomsException.class})
    public Long buyTicket(final TripDtoResponse buyTicket, final String userEmail) {
        Optional<List<Trip>> tripWrapper = tripService.findTripIdByCriteria(buyTicket.getHotelName(),
                buyTicket.getFlightNumberDeparture(),
                buyTicket.getFlightNumberReturn());

        return tripWrapper.map(trip -> this.userService.findUserByEmail(userEmail)
                .map(currentUser -> insertNewTripDetails(buyTicket, trip.get(0), currentUser))
                .map(theTripId -> decrementFlightSeats(buyTicket, theTripId))
                .map(theTripId -> decrementTheNumberOfHotelRooms(buyTicket, theTripId))
                .orElseThrow(BuyTicketHadFailedException::new))
                .orElseThrow(BuyTicketHadFailedException::new);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long decrementTheNumberOfHotelRooms(TripDtoResponse buyTicket, Long theTripId) {

        List<Room> hotelRooms = roomService.getAllRoomsForHotel(buyTicket.getHotelName());
        if (null == hotelRooms || hotelRooms.isEmpty()) {
            throw new NoMoreHotelRoomsException();
        } else {
            //decrementOnlyTheSingleRooms(numberOfSingleRooms, hotelRooms);
            hotelRooms.get(0).setNumberOfAvailableDoubleRoom(0);
            hotelRooms.get(0).setNumberOfAvailableSingleRoom(0);
            hotelRooms.get(0).setNumberOfExtraBeds(0);
            roomService.updateRoom(hotelRooms.get(0));
        }
        return theTripId;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long decrementFlightSeats(TripDtoResponse buyTicket, Long theTripId) {
        flightService.decrementNumberOfSeats(buyTicket.getFlightNumberDeparture(), buyTicket.getNumberOfPersons());
        flightService.decrementNumberOfSeats(buyTicket.getFlightNumberReturn(), buyTicket.getNumberOfPersons());
        return theTripId;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTripDetails(TripDtoResponse buyTicket, Trip trip, User currentUser) {
        incrementUserTripsAmount(buyTicket, currentUser);
        return tripDetailsService.insertNewTripDetails(buyTicket, trip, currentUser);
    }

    private void incrementUserTripsAmount(TripDtoResponse buyTicket, User currentUser) {
        Integer amountWithDiscount = DiscountHelper.getInstance().getDiscountByAmount(currentUser.getTotalAmount());
        if (null == currentUser.getTotalAmount()) {
            currentUser.setTotalAmount(amountWithDiscount);
        } else {
            currentUser.setTotalAmount(currentUser.getTotalAmount() + currentUser.getTotalAmount());
        }
        buyTicket.setAmount(amountWithDiscount);
    }

    /*De citit despte git hook-uri*/

}
