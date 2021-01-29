package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.server.exception.PropertiesParameterException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.ResourceBundle;

public class ServerController {
    /**
     * свойства по умолчанию
     */
    public static String SPLITTING_SENTENCE_INTO_WORDS = "[\\s]+";
    public static String SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION = "[\\s,?!.:-]+";
    public static String SENTENCE = "([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\{}(]|\\([^\\)]*\\))*[.?!])";
    public static String CODE_BLOCK = "(```[a-z]*\\n[\\s\\S]*?\\n```)";
    public static String PUNCTUATION_MARKS = ",.?:-;";
    private final ServerSocket serverSocket;
    private final int port;
    private final ObjectInputStream serverInputStream;
    private final ObjectOutputStream serverOutputStream;
    private final Socket connectedToClientSocket;
    private RequestToServer clientRequest;
    private AnswerToClient serverAnswer;

    public ServerController(int port) throws IOException {
        serverAnswer = new AnswerToClient();
        this.port = port;
        serverSocket = new ServerSocket(port);
        connectedToClientSocket = serverSocket.accept();
        serverInputStream = new ObjectInputStream(connectedToClientSocket.getInputStream());
        serverOutputStream = new ObjectOutputStream(connectedToClientSocket.getOutputStream());
    }

    public void receiveRequestFromClient() throws IOException, ClassNotFoundException, PropertiesParameterException {
        clientRequest = (RequestToServer) serverInputStream.readObject();
        setProperties();

    }

    public void sendAnswerToClient() throws IOException, PropertiesParameterException {
        serverAnswer = new AnswerToClient(clientRequest);
        serverAnswer.preparedInfoForClient();
        serverOutputStream.writeObject(serverAnswer.preparedInfoForClient());
        serverInputStream.close();
        serverOutputStream.close();
    }

    public void setProperties() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("regex",new Locale("en"));
        SPLITTING_SENTENCE_INTO_WORDS = resourceBundle.getString("regex.splittingSentenceIntoWords");
        SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION = resourceBundle.getString("regex.splittingSentenceIntoWordsIgnorePunctuation");
        SENTENCE = resourceBundle.getString("regex.sentence");
        CODE_BLOCK = resourceBundle.getString("regex.codeBlock");
    }

}
