package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.tema.SDA_Tema_4.business.PaymentService;
import sda.tema.SDA_Tema_4.controller.web.payload.TripDtoResponse;
import sda.tema.SDA_Tema_4.security.UserPrincipal;

import java.net.URI;

@RestController
@RequestMapping("/buy.ticket")
public class BuyingTicketController {

    private final PaymentService paymentService;

    public BuyingTicketController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> buyTicket(@RequestBody TripDtoResponse buyTicket, Authentication authentication) {
        Long tripId = paymentService.buyTicket(buyTicket, ((UserPrincipal) authentication.getPrincipal()).getEmail());
        if (PaymentService.DEFAULT_ID.equals(tripId)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } else {
            return ResponseEntity.created(URI.create("buy.ticket/" + tripId)).build();
        }
    }

}
