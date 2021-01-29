package by.tc.task04.server.exception;

public class TaskException extends Exception {
    public TaskException() {
        super();
    }

    public TaskException(String message) {
        super(message);
    }

    public TaskException(Exception e) {
        super(e);
    }

    public TaskException(String message, Exception e) {
        super(message, e);
    }
}
