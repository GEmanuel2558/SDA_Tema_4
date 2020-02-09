package sda.tema.SDA_Tema_4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.CONFLICT, reason = "No more hotel rooms")
public class NoMoreHotelRoomsException extends RuntimeException {
}
