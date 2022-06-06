package ma.soumih.ebankingbackend.exceptions;

public class UserNotExistsException extends Exception {

    public UserNotExistsException(String message) {
        super(message);
    }
}
