package by.tc.task04.server;

import by.tc.task04.server.controller.ServerController;
import by.tc.task04.server.exception.PropertiesParameterException;

import java.io.IOException;

public class Server {
    public final static int port = 8001;

    public static void main(String[] args) throws IOException, ClassNotFoundException, PropertiesParameterException {
        ServerController serverController = new ServerController(port);
        serverController.receiveRequestFromClient();
        serverController.sendAnswerToClient();

    }
}
