package starbucks.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CoffeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CoffeeErrorResponse> handleException (CoffeeNotFoundException exception){

        CoffeeErrorResponse error = new CoffeeErrorResponse(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CoffeeErrorResponse> handleException (Exception exception){

        CoffeeErrorResponse error = new CoffeeErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }




}
