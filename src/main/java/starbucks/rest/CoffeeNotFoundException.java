package starbucks.rest;

public class CoffeeNotFoundException extends RuntimeException {

    public CoffeeNotFoundException() {
    }

    public CoffeeNotFoundException(String message) {
        super(message);
    }

    public CoffeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeNotFoundException(Throwable cause) {
        super(cause);
    }
}
