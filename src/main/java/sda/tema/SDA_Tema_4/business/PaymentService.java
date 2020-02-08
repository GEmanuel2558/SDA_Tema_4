package sda.tema.SDA_Tema_4.business;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    private final TripDao tripDao;
    private final TripDetailsDao tripDetailsDao;
    private final UserDao userDao;

    public PaymentService(TripDao tripDao,
                          TripDetailsDao tripDetailsDao,
                          UserDao userDao) {
        this.tripDao = tripDao;
        this.tripDetailsDao = tripDetailsDao;
        this.userDao = userDao;
    }

    public boolean buyTicket(TripDtoResponse buyTicket, String userEmail) {
        Optional<Trip> tripWrapper = tripDao.findTripIdByCriteria(buyTicket.getHotelName(),
                buyTicket.getFlightNumberDeparture(),
                buyTicket.getFlightNumberReturn());

        return tripWrapper.map(trip -> this.userDao.findByEmail(userEmail).map(currentUser -> {
            TripDetails tripDetails = new TripDetails();
            tripDetails.setTrip(trip);
            tripDetails.setExtra_bed(buyTicket.getExtraBed());
            tripDetails.setAmount(buyTicket.getAmount());
            tripDetails.setNumber_of_double_rooms(buyTicket.getNumberOfDoubleRooms());
            tripDetails.setNumber_of_single_rooms(buyTicket.getNumberOfSingleRooms());
            tripDetails.setListOfUsers(Collections.singletonList(currentUser));
            tripDetailsDao.save(tripDetails);
            return true;
        }).orElse(false)).orElse(false);
    }

}
