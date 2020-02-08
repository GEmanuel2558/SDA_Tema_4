package sda.tema.SDA_Tema_4.business;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.repository.dao.TripDao;
import sda.tema.SDA_Tema_4.repository.dao.TripDetailsDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.repository.entitys.TripDetails;
import sda.tema.SDA_Tema_4.security.repository.UserDao;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class PaymentService {

    private final TripService tripService;
    private final TripDetailsService tripDetailsService;
    private final UserService userService;

    public PaymentService(UserService userService,
                          TripService tripService,
                          TripDetailsService tripDetailsService) {
        this.userService = userService;
        this.tripService = tripService;
        this.tripDetailsService = tripDetailsService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean buyTicket(TripDtoResponse buyTicket, String userEmail) {

        Optional<Trip> tripWrapper = tripService.findTripIdByCriteria(buyTicket.getHotelName(),
                buyTicket.getFlightNumberDeparture(),
                buyTicket.getFlightNumberReturn());

        return tripWrapper.map(trip -> this.userService.findUserByEmail(userEmail).map(currentUser -> {
            TripDetails tripDetails = new TripDetails();
            tripDetails.setTrip(trip);
            tripDetails.setExtra_bed(buyTicket.getExtraBed());
            tripDetails.setAmount(buyTicket.getAmount());
            tripDetails.setNumber_of_double_rooms(buyTicket.getNumberOfDoubleRooms());
            tripDetails.setNumber_of_single_rooms(buyTicket.getNumberOfSingleRooms());
            tripDetails.setListOfUsers(Collections.singletonList(currentUser));
            tripDetailsService.insertNewTripDetails(tripDetails);
            return true;
        }).orElse(false)).orElse(false);
    }

}
