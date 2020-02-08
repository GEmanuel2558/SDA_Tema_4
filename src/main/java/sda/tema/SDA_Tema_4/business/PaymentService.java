package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.utils.DiscountHelper;

import java.io.IOException;
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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long buyTicket(final TripDtoResponse buyTicket, final String userEmail) {
        Optional<Trip> tripWrapper = tripService.findTripIdByCriteria(buyTicket.getHotelName(),
                buyTicket.getFlightNumberDeparture(),
                buyTicket.getFlightNumberReturn());
        return tripWrapper.map(trip -> this.userService.findUserByEmail(userEmail).map(currentUser -> {
            Integer amountWithDiscount = DiscountHelper.getInstance().getDiscountByAmount(currentUser.getTotalAmount());
            if (null == currentUser.getTotalAmount()) {
                currentUser.setTotalAmount(amountWithDiscount);
            } else {
                currentUser.setTotalAmount(currentUser.getTotalAmount() + currentUser.getTotalAmount());
            }
            buyTicket.setAmount(amountWithDiscount);
            return tripDetailsService.insertNewTripDetails(buyTicket, trip, currentUser);
        }).map(theTripId -> {
            if (!DEFAULT_ID.equals(theTripId)) {
                try {
                    flightService.decrementNumberOfSeats(buyTicket.getFlightNumberDeparture(), buyTicket.getNumberOfPersons());
                    flightService.decrementNumberOfSeats(buyTicket.getFlightNumberReturn(), buyTicket.getNumberOfPersons());
                    return theTripId;
                } catch (IOException e) {
                    e.printStackTrace();
                    return DEFAULT_ID;
                }
            } else {
                return theTripId;
            }
        }).map(theTripId -> {
            if (!DEFAULT_ID.equals(theTripId)) {
                try {
                    tripService.decrementTheNumberOfRooms(tripWrapper.get().getId(),
                            buyTicket.getNumberOfDoubleRooms(),
                            buyTicket.getNumberOfSingleRooms(),
                            buyTicket.getExtraBed());
                    return theTripId;
                } catch (IOException e) {
                    e.printStackTrace();
                    return DEFAULT_ID;
                }
            } else {
                return theTripId;
            }
        }).orElse(DEFAULT_ID)).orElse(DEFAULT_ID);
    }

    /*De citit despte git hook-uri*/

}
