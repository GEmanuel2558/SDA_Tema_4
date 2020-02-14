package sda.tema.SDA_Tema_4.business;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDetails;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoRequest;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoResponse;
import sda.tema.SDA_Tema_4.exceptions.AirtportNotFoundException;
import sda.tema.SDA_Tema_4.exceptions.FlightHadDisappearedException;
import sda.tema.SDA_Tema_4.exceptions.NoAirportException;
import sda.tema.SDA_Tema_4.repository.dao.FlightDao;
import sda.tema.SDA_Tema_4.repository.entitys.Flight;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true, propagation = Propagation.MANDATORY)
public class FlightService {

    private final FlightDao flightDao;
    private final AirportService airportService;

    public FlightService(FlightDao flightDao, AirportService airportService) {
        this.flightDao = flightDao;
        this.airportService = airportService;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void decrementNumberOfSeats(String flightNumber, Integer decrementBy) {
        flightDao.findByFlightNumber(flightNumber).map(flight -> {
            flight.setRetailabeSeats(flight.getRetailabeSeats() - decrementBy);
            return true;
        }).orElseThrow(FlightHadDisappearedException::new);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long insertNewFlights(final FlightDtoRequest newFlight) {
        return this.flightDao.save(this.dtoToFlight(newFlight)).getId();
    }

    public Flight dtoToFlight(final FlightDtoRequest request) {
        Flight flight = new Flight();
        flight.setAirport(airportService
                .findAirportByName(request.getAirpotName())
                .orElseThrow(AirtportNotFoundException::new));
        flight.setDepartureDate(request.getDepartureDate());
        flight.setFlightNumber(request.getFlightNumber());
        flight.setFlightPrice(request.getFlightPrice());
        flight.setRetailabeSeats(request.getRetailabeSeats());
        flight.setTotalNumberOfSeets(request.getRetailabeSeats());
        return flight;
    }

    public FlightDtoResponse getFlight(Pageable pageable, Long id) {
        return this.flightDao.findById(id).map(FlightDtoResponse::new).orElseThrow(AirtportNotFoundException::new);
    }

    public List<FlightDtoResponse> getFlight(Pageable pageable) {
        return this.flightDao.findAll(pageable).stream().map(FlightDtoResponse::new).collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Flight insertNewFlight(final FlightDetails flightDetails) {
        return airportService.findAirportByName(flightDetails.getAirportDetails().getName()).map(airport -> {
            Flight flight = new Flight();
            flight.setAirport(airport);
            flight.setTotalNumberOfSeets(flightDetails.getNumberOfSeets());
            flight.setRetailabeSeats(flight.getRetailabeSeats());
            flight.setFlightNumber(flight.getFlightNumber());
            flight.setFlightPrice(flightDetails.getPrice());
            flight.setDepartureDate(flight.getDepartureDate());
            return flightDao.save(flight);
        }).orElseThrow(NoAirportException::new);
    }

}
