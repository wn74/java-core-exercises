package ex3_di.exceptions;

public class InvalidUserDataException extends RuntimeException {
    
    public InvalidUserDataException(String errorMessage) {
        super(errorMessage);
    }

}
