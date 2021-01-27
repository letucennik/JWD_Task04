package by.tc.task04.client;

import by.tc.task04.client.controller.ClientController;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.regex.Regex;

public class Client {
    public static final int port = 8001;

    public static void main(String[] args) {
        RequestToServer request = new RequestToServer("src/main/resources/input.txt",13);
        request.setWordLength(5);
        request.setFirstLetter(new Letter('a'));
         //request.setSecondLetter(new Letter('s'));
        //request.setFilePathOfWordList("src/main/resources/wordlist.txt");
        ClientController clientController = new ClientController(request, port);
        clientController.sendRequestToServer();
        String s = clientController.getAnswerFromServer();
        System.out.println(s);

    }
}
