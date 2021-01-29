package by.tc.task04.server;

import by.tc.task04.server.controller.ServerController;
import by.tc.task04.server.exception.ControllerException;
import by.tc.task04.server.exception.ServerException;

public class Server {
    public final static int port = 8001;

    public static void main(String[] args) throws ServerException {
        try {
            ServerController serverController = new ServerController(port);
            serverController.receiveRequestFromClient();
            serverController.sendAnswerToClient();
        } catch (ControllerException e) {
            throw new ServerException(e);
        }

    }
}
