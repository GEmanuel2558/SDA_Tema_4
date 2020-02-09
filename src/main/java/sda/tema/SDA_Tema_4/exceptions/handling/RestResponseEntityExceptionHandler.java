package sda.tema.SDA_Tema_4.exceptions.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sda.tema.SDA_Tema_4.exceptions.NoMoreHotelRoomsException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity<Object> handleSqlCheckViolationError(JpaSystemException ex, WebRequest request) {
        String bodyOfResponse = "No more rooms for this hotel";
        if (ex.getCause().getCause().getMessage().contains("flight")) {
            bodyOfResponse = "No more flight seats";
        }

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(NoMoreHotelRoomsException.class)
    public ResponseEntity<Object> handleNoMoreRooms(NoMoreHotelRoomsException ex, WebRequest request) {
        return handleExceptionInternal(ex, "No more rooms for this hotel",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
