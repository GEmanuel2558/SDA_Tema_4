package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.exceptions.FlightHadDisappeared;
import sda.tema.SDA_Tema_4.repository.dao.FlightDao;

@Service
public class FlightService {

    private final FlightDao flightDao;

    public FlightService(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void decrementNumberOfSeats(String flightNumber, Integer decrementBy) {
        flightDao.findByFlightNumber(flightNumber).map(flight -> {
            flight.setRetailabeSeats(flight.getRetailabeSeats() - decrementBy);
            return true;
        }).orElseThrow(FlightHadDisappeared::new);

    }

}
