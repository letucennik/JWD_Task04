package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.server.exception.AnswerToClientException;
import by.tc.task04.server.exception.ControllerException;
import by.tc.task04.server.exception.PropertiesParameterException;
import by.tc.task04.server.parser.TextParser;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.ResourceBundle;

public class ServerController {
    private final ServerSocket serverSocket;
    private final int port;
    private final ObjectInputStream serverInputStream;
    private final ObjectOutputStream serverOutputStream;
    private final Socket connectedToClientSocket;
    private RequestToServer clientRequest;
    private AnswerToClient serverAnswer;
    private Logger logger=Logger.getLogger(this.getClass());

    public ServerController(int port) throws ControllerException {
        serverAnswer = new AnswerToClient();
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            connectedToClientSocket = serverSocket.accept();
            serverInputStream = new ObjectInputStream(connectedToClientSocket.getInputStream());
            serverOutputStream = new ObjectOutputStream(connectedToClientSocket.getOutputStream());
        }
        catch(IOException e){
            logger.log(Level.ERROR,e);
            throw new ControllerException("Exception while connecting to client");
        }
    }

    public void receiveRequestFromClient() throws ControllerException {
        try {
            clientRequest = (RequestToServer) serverInputStream.readObject();
            setProperties();
        }
        catch(IOException | ClassNotFoundException e){
            logger.log(Level.ERROR,e);
            throw new ControllerException("Exception while deserialization",e);
        }

    }

    public void sendAnswerToClient() throws ControllerException {
        serverAnswer = new AnswerToClient(clientRequest);
        try {
            serverAnswer.preparedInfoForClient();
        }
        catch(AnswerToClientException e){
            throw new ControllerException(e);
        }
        try {
            serverOutputStream.writeObject(serverAnswer.preparedInfoForClient());
            serverInputStream.close();
            serverOutputStream.close();
        }
        catch(AnswerToClientException e){
            throw new ControllerException(e);
        }
        catch(IOException e){
            logger.log(Level.ERROR,"Exception while writing object to output stream");
        }
    }

    public void setProperties() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("regex",new Locale("en"));
        TextParser.SPLITTING_SENTENCE_INTO_WORDS = resourceBundle.getString("regex.splittingSentenceIntoWords");
        TextParser.SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION = resourceBundle.getString("regex.splittingSentenceIntoWordsIgnorePunctuation");
        TextParser.SENTENCE = resourceBundle.getString("regex.sentence");
        TextParser.CODE_BLOCK = resourceBundle.getString("regex.codeBlock");
    }

}
