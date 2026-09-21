package ex3_di.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    
    public UserAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }

}
