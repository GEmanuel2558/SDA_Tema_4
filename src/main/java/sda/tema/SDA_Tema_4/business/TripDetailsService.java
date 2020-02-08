package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.repository.dao.TripDetailsDao;
import sda.tema.SDA_Tema_4.repository.entitys.Trip;
import sda.tema.SDA_Tema_4.repository.entitys.TripDetails;
import sda.tema.SDA_Tema_4.security.entitys.User;

import java.util.Collections;

@Service
public class TripDetailsService {

    private final TripDetailsDao dao;

    public TripDetailsService(TripDetailsDao dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTripDetails(TripDetails tripDetails) {
        return dao.save(tripDetails).getId();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Long insertNewTripDetails(TripDtoResponse buyTicket, Trip trip, User currentUser) {
        TripDetails tripDetails = new TripDetails();
        tripDetails.setTrip(trip);
        tripDetails.setExtraBed(0 == buyTicket.getExtraBed());
        tripDetails.setAmount(buyTicket.getAmount());
        tripDetails.setNumberOfDoubleRooms(buyTicket.getNumberOfDoubleRooms());
        tripDetails.setNumberOfSingleRooms(buyTicket.getNumberOfSingleRooms());
        tripDetails.setListOfUsers(Collections.singletonList(currentUser));
        return dao.save(tripDetails).getId();
    }

}
