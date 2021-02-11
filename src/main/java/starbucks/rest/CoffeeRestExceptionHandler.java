package starbucks.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CoffeeRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ CoffeeNotFoundException.class })
    public ResponseEntity<CoffeeErrorResponse> handleException(CoffeeNotFoundException exception){

        CoffeeErrorResponse error = new CoffeeErrorResponse(HttpStatus.NOT_FOUND, "404",
                exception.getMessage(), LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
