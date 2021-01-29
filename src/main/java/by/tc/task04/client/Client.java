package by.tc.task04.client;

import by.tc.task04.client.controller.ClientController;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.parameters.UserParameters;

public class Client {
    public static final int port = 8001;

    public static void main(String[] args) {
        RequestToServer request = new RequestToServer("src/main/resources/input.txt", 16);
        request.setParameters(UserParameters.newBuilder().setFirstLetter(new Letter('i'))
                .setSecondLetter(new Letter('n')).setWordLength(5).setFilePathOfWordList("src/main/resources/wordlist.txt").
                        setSubstring("lalala").build());
        ClientController clientController = new ClientController(request, port);
        clientController.sendRequestToServer();
        String s = clientController.getAnswerFromServer();
        System.out.println(s);

    }
}
