package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;
import by.tc.task04.server.tasks.impl.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AnswerToClient {
    private final Logger logger = Logger.getLogger(AnswerToClient.class);
    private RequestToServer clientRequest;
    private Text contentOfProgrammingFile;

    public AnswerToClient() {
        clientRequest = new RequestToServer();
        contentOfProgrammingFile = new Text();
    }

    public AnswerToClient(RequestToServer clientRequest) {
        this.clientRequest = clientRequest;
        try {
            this.contentOfProgrammingFile = new Text(new String(Files.readAllBytes(Paths.get(clientRequest.getFilePath()))));
        } catch (IOException e) {
            logger.info("Error while reading file");
            logger.error(e);
        }
    }

    public String preparedInfoForClient() {
        IndividualTask userTask;
        TextParser parser = new TextParser(contentOfProgrammingFile);
        parser.parseToSentencesAndCodeBlocks();
        List<TextPart> sentencesAndBlocks = contentOfProgrammingFile.getTextParts();
        List<TextPart> sentences = contentOfProgrammingFile.getSentences();
        List<TextPart> words = contentOfProgrammingFile.getWords();
        switch (clientRequest.getNumberOfOperation()) {
            case 1:
                userTask = new Task01(sentences);
                return userTask.performTask();
            case 2:
                userTask = new Task02(sentences);
                return userTask.performTask();
            case 3:
                userTask = new Task03(sentences);
                return userTask.performTask();
            case 4:
                userTask = new Task04(sentences, clientRequest.getWordLength());
                return userTask.performTask();

            case 5:
                userTask = new Task05(sentences);
                return userTask.performTask();

            case 6:
                userTask = new Task06(words);
                return userTask.performTask();

            case 7:
                userTask = new Task07(words);
                return userTask.performTask();

            case 8:
                userTask = new Task08(words);
                return userTask.performTask();

            case 9:
                userTask=new Task09(words,clientRequest.getFirstLetter());
                return userTask.performTask();

            case 10:
                userTask=new Task10(sentences,clientRequest.getFilePathOfWordList());
                return userTask.performTask();

            case 11:
                userTask=new Task11(sentencesAndBlocks,clientRequest.getFirstLetter(),clientRequest.getSecondLetter());
                return userTask.performTask();

            case 12:
                userTask=new Task12(sentencesAndBlocks,clientRequest.getWordLength());
                return userTask.performTask();

            case 13:
                userTask=new Task13(words,clientRequest.getFirstLetter());
                return userTask.performTask();

            case 14:
                userTask=new Task14(contentOfProgrammingFile);
                return userTask.performTask();

            case 15:
                userTask=new Task15(sentencesAndBlocks);
                return userTask.performTask();

            case 16:
                break;
            default:
                return "";

        }
        return "";
    }

}
