package sda.tema.SDA_Tema_4.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoRequest;
import sda.tema.SDA_Tema_4.repository.dao.FlightDao;

import java.io.IOException;

@Service
public class FlightService {

    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void decrementNumberOfSeats(String flightNumber, Integer decrementBy) throws IOException {
        flightDao.findByFlightNumber(flightNumber).map(flight -> {
            flight.setRetailabeSeats(flight.getRetailabeSeats() - decrementBy);
            return true;
        }).orElseThrow(() -> new IOException("Unknown flight"));

    }

}
