package sda.tema.SDA_Tema_4.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
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
import sda.tema.SDA_Tema_4.security.entitys.User;

@RestController
@RequestMapping("/buy.ticket")
public class BuyingTicketController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> buyTicket(@RequestBody TripDtoResponse buyTicket, Authentication authentication) {
        paymentService.buyTicket(buyTicket, ((UserPrincipal) authentication.getPrincipal()).getEmail());
        return ResponseEntity.ok().build();
    }

}
