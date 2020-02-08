package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.tema.SDA_Tema_4.controller.web.payload.FlightDtoRequest;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {


    @PostMapping(value = "/")
    public ResponseEntity<?> insertNewFlights(@RequestBody FlightDtoRequest newFlight) {



        return null;
    }

}
