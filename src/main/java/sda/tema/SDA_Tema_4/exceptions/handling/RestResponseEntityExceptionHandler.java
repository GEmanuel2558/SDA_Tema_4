package sda.tema.SDA_Tema_4.exceptions.handling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> handleSqlCheckViolationError(SQLException ex, WebRequest request) {
        String bodyOfResponse = "No more rooms for this hotel";
        if (ex.getMessage().contains("flight")) {
            bodyOfResponse = "No more flight seats";
        }

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
