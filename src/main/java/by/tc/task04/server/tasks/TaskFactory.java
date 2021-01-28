package by.tc.task04.server.tasks;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.exception.PropertiesParameterException;
import by.tc.task04.server.tasks.impl.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TaskFactory {
    public IndividualTask createTask(RequestToServer clientRequest) throws IOException, PropertiesParameterException {
        IndividualTask task = null;
        Text text = new Text(new String(Files.readAllBytes(Paths.get(clientRequest.getFilePath()))));
        switch (clientRequest.getNumberOfOperation()) {
            case 1:
                task = new Task01(text);
                break;
            case 2:
                task = new Task02(text);
                break;
            case 3:
                task = new Task03(text);
                break;
            case 4:
                task = new Task04(text, clientRequest.getParameters().getWordLength());
                break;
            case 5:
                task = new Task05(text);
                break;
            case 6:
                task = new Task06(text);
                break;
            case 7:
                task = new Task07(text);
                break;
            case 8:
                task = new Task08(text);
                break;
            case 9:
                task = new Task09(text, clientRequest.getParameters().getFirstLetter());
                break;
            case 10:
                task = new Task10(text, clientRequest.getParameters().getFilePathOfWordList());
                break;
            case 11:
                task = new Task11(text, clientRequest.getParameters().getFirstLetter(), clientRequest.getParameters().getSecondLetter());
                break;
            case 12:
                task = new Task12(text, clientRequest.getParameters().getWordLength());
                break;
            case 13:
                task = new Task13(text, clientRequest.getParameters().getFirstLetter());
                break;
            case 14:
                task = new Task14(text);
                break;
            case 15:
                task = new Task15(text);
                break;
            case 16:
                task = new Task16(text, clientRequest.getParameters().getSubstring(), clientRequest.getParameters().getWordLength());
                break;
            default:
                throw new PropertiesParameterException("Invalid task number");
        }
        return task;
    }
}
