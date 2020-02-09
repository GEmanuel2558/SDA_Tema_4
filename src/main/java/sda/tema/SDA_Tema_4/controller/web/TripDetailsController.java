package sda.tema.SDA_Tema_4.controller.web;


import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.tema.SDA_Tema_4.business.TripDetailsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/trip.details")
public class TripDetailsController {

    private final TripDetailsService tripDetailsService;

    public TripDetailsController(TripDetailsService tripDetailsService) {
        this.tripDetailsService = tripDetailsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTripDetailsById(@Valid @NotNull @PathVariable("id") Long tripDetailsId) {
        return tripDetailsService
                .getTripDetailsById(tripDetailsId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<?> getTripDetailsById(@PageableDefault Pageable pageable) {
        return tripDetailsService
                .getTripDetails(pageable)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
