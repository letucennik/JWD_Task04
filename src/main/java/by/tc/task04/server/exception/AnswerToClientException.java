package by.tc.task04.server.exception;

public class AnswerToClientException extends Exception {
    public AnswerToClientException() {
        super();
    }

    public AnswerToClientException(String message) {
        super(message);
    }

    public AnswerToClientException(Exception e) {
        super(e);
    }

    public AnswerToClientException(String message, Exception e) {
        super(message, e);
    }
}
