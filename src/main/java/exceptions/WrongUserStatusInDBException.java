package exceptions;

/**
 * This exception does not like when database result returns user not in approved status
 */
public class WrongUserStatusInDBException extends Exception {
    public WrongUserStatusInDBException(String message) {
        super(message);
    }
}
