package by.tc.task04.server.exception;

public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(Exception e) {
        super(e);
    }

    public InvalidParameterException(String message, Exception e) {
        super(message, e);
    }
}
