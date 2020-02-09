package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.tema.SDA_Tema_4.business.TripService;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoRequest;

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




}
