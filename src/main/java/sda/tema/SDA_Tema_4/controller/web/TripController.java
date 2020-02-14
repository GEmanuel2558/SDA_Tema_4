package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sda.tema.SDA_Tema_4.business.TripService;
import sda.tema.SDA_Tema_4.controller.web.payload.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService service;

    public TripController(TripService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getTripDetailsById(@PageableDefault Pageable pageable, @RequestBody TripDtoRequest request) {
        if (request.hasAtLeastOnePropertySet()) {
            return ResponseEntity.ok(service.findTripsByCriteria(pageable, request));
        } else {
            return service
                    .findTripsOnlyByPageant(pageable)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> insertNewTrip(@Valid @RequestBody NewTripDto request) {
        service.insertNewTrip(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping(value = "/a")
    public NewTripDto geg() {
        NewTripDto newTripDto = new NewTripDto();
        TripDetails tripDetails = new TripDetails();
        tripDetails.setFromDate(new Date());
        newTripDto.setTripDetails(tripDetails);
        FlightDetails flightDepartureDetails = new FlightDetails();
        flightDepartureDetails.setAirportDetails(new AirportDetails());
        newTripDto.setFlightDepartureDetails(flightDepartureDetails);
        newTripDto.setFlightReturnDetails(flightDepartureDetails);
        newTripDto.setHotelDetails(new HotelDetails());
        return newTripDto;
    }

}
