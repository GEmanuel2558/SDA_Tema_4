package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.tema.SDA_Tema_4.business.ContinentService;
import sda.tema.SDA_Tema_4.controller.web.payload.ContinentDtoResponse;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/continent")
public class ContinentController {

    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContinentDtoResponse>> getContinents() {
        return ResponseEntity.ok(continentService.getAllContinents());
    }

    @PostMapping
    public ResponseEntity<?> insertNewContinent(@RequestBody ContinentDtoResponse continentDtoResponse) {
        Long theNewContinentId = continentService.insertNewContinent(continentDtoResponse);
        return ResponseEntity.created(URI.create("localhost:8080/continent/" + theNewContinentId)).build();
    }

}
