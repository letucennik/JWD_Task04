package by.tc.task04.client.controller;

import by.tc.task04.client.RequestToServer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController {
    private RequestToServer requestToServer;
    private Socket clientSocket;
    private ObjectOutputStream clientOutputStream;
    private ObjectInputStream clientInputStream;
    private int port;
    private Logger logger = Logger.getLogger(ClientController.class);

    public ClientController(RequestToServer requestToServer, int port) {
        this.port = port;
        this.requestToServer = requestToServer;
        try {
            clientSocket = new Socket("127.0.0.1", port);
            clientOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            logger.info("Error while connecting to server");
            logger.error(e);
        }


    }

    public void sendRequestToServer() {
        if (clientOutputStream == null) {
            return;
        }
        try {
            clientOutputStream.writeObject(requestToServer);
        } catch (IOException ex) {
            logger.info("Exception while sending request to server");
            logger.error(ex);
        }
    }

    public String getAnswerFromServer() {
        if (clientInputStream == null) {
            return null;
        }
        try {
            return (String) clientInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            logger.info("Exception while receiving information from server");
            logger.error(ex);
            return null;
        } finally {
            try {
                clientOutputStream.close();
                clientInputStream.close();
            } catch (IOException e) {
                logger.info("Exception while closing streams");
                logger.error(e);
            }
        }
    }
}
