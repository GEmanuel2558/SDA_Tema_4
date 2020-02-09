package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.tema.SDA_Tema_4.business.FlightService;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoRequest;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoResponse;
import sda.tema.SDA_Tema_4.repository.entitys.Airport;
import sda.tema.SDA_Tema_4.repository.entitys.Flight;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFlight(@PageableDefault Pageable pageable, @PathVariable(required = false) Long flightId) {
        if (null != flightId) {
            ResponseEntity.ok(flightService.getFlight(pageable, flightId));
        } else {
            List<FlightDtoResponse> listOfFlights = flightService.getFlight(pageable);
            if (listOfFlights.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(listOfFlights);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> insertNewFlights(@Valid @RequestBody FlightDtoRequest newFlight) {
        Long theNewFlight = flightService.insertNewFlights(newFlight);
        if (null != theNewFlight) {
            return ResponseEntity.created(URI.create("http://localhost:8080/flight/" + theNewFlight)).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
