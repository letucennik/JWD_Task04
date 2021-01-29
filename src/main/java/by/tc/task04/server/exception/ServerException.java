package by.tc.task04.server.exception;

public class ServerException extends Exception {
    public ServerException(){
        super();
    }
    public ServerException(String message){
        super(message);
    }
    public ServerException(Exception e){
        super(e);
    }
    public ServerException(String message, Exception e){
        super(message,e);
    }
}
