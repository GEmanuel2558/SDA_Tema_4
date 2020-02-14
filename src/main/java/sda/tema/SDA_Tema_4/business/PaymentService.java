package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.exceptions.BuyTicketHadFailedException;
import sda.tema.SDA_Tema_4.exceptions.FlightHadDisappearedException;
import sda.tema.SDA_Tema_4.exceptions.NoMoreHotelRoomsException;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.security.entitys.User;
import sda.tema.SDA_Tema_4.utils.DiscountHelper;

import java.util.Optional;

@Service
public class PaymentService {

    private final TripService tripService;
    private final TripDetailsService tripDetailsService;
    private final UserService userService;
    private final FlightService flightService;
    public static final Long DEFAULT_ID = 0L;

    public PaymentService(UserService userService,
                          TripService tripService,
                          TripDetailsService tripDetailsService,
                          FlightService flightService) {
        this.userService = userService;
        this.tripService = tripService;
        this.tripDetailsService = tripDetailsService;
        this.flightService = flightService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {BuyTicketHadFailedException.class,
            FlightHadDisappearedException.class, NoMoreHotelRoomsException.class})
    public Long buyTicket(final TripDtoResponse buyTicket, final String userEmail) {
        Optional<Trip> tripWrapper = tripService.findTripIdByCriteria(buyTicket.getHotelName(),
                buyTicket.getFlightNumberDeparture(),
                buyTicket.getFlightNumberReturn());

        return tripWrapper.map(trip -> this.userService.findUserByEmail(userEmail)
                .map(currentUser -> insertNewTrip(buyTicket, trip, currentUser))
                .map(theTripId -> decrementFlightSeats(buyTicket, theTripId))
                .map(theTripId -> decrementTheNumberOfHotelRooms(buyTicket, theTripId))
                .orElseThrow(BuyTicketHadFailedException::new))
                .orElseThrow(BuyTicketHadFailedException::new);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long decrementTheNumberOfHotelRooms(TripDtoResponse buyTicket, Long theTripId) {
        tripService.decrementTheNumberOfRooms(buyTicket.getHotelName(),
                buyTicket.getNumberOfDoubleRooms(),
                buyTicket.getNumberOfSingleRooms(),
                buyTicket.getExtraBed());
        return theTripId;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long decrementFlightSeats(TripDtoResponse buyTicket, Long theTripId) {
        flightService.decrementNumberOfSeats(buyTicket.getFlightNumberDeparture(), buyTicket.getNumberOfPersons());
        flightService.decrementNumberOfSeats(buyTicket.getFlightNumberReturn(), buyTicket.getNumberOfPersons());
        return theTripId;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTrip(TripDtoResponse buyTicket, Trip trip, User currentUser) {
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
