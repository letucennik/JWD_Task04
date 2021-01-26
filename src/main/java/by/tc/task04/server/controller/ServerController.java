package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.regex.Regex;
import by.tc.task04.server.exception.PropertiesParameterException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    private RequestToServer clientRequest;
    private ServerSocket serverSocket;
    private int port;
    private ObjectInputStream serverInputStream;
    private ObjectOutputStream serverOutputStream;
    private Socket connectedToClientSocket;
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
       // manageRegexFromProperties();
    }

    public void sendAnswerToClient() throws IOException {
        serverAnswer = new AnswerToClient(clientRequest);
        serverAnswer.preparedInfoForClient();
        serverOutputStream.writeObject(serverAnswer.preparedInfoForClient());
        serverInputStream.close();
        serverOutputStream.close();
    }

//    private void manageRegexFromProperties() throws IOException, PropertiesParameterException {
//        File propertiesFile = new File(clientRequest.getProperties());
//        FileReader propertiesReader = new FileReader(propertiesFile);
//        BufferedReader propertiesBufferedReader = new BufferedReader(propertiesReader);
//        String currentLine = propertiesBufferedReader.readLine();
//        while (currentLine != null) {
//            String[] params = currentLine.split("=");
//            switch (params[0]) {
//                case "SPLITTING_SENTENCE_INTO_WORDS":
//                    Regex.SPLITTING_SENTENCE_INTO_WORDS = params[1];
//                    break;
//                case "SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION":
//                    Regex.SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION=params[1];
//                    break;
//                case "SENTENCE":
//                    Regex.SENTENCE=params[1];
//                    break;
//                case "CODE_BLOCK":
//                    Regex.CODE_BLOCK=params[1];
//                    break;
//                default:
//                    throw new PropertiesParameterException("Invalid parameter in properties");
//            }
//
//        }
   // }
}
