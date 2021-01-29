package by.tc.task04.server.tasks;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.exception.InvalidParameterException;
import by.tc.task04.server.exception.TaskException;
import by.tc.task04.server.tasks.impl.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TaskFactory {
    private Logger logger = Logger.getLogger(this.getClass());

    public IndividualTask createTask(RequestToServer clientRequest) throws TaskException {
        IndividualTask task = null;
        int wordLength = clientRequest.getParameters().getWordLength();
        Letter firstLetter = clientRequest.getParameters().getFirstLetter();
        try {
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
                    if (validateParameter(wordLength)) {
                        task = new Task04(text, wordLength);
                    } else {
                        logger.log(Level.ERROR, "Invalid word length");
                        throw new TaskException("Invalid word length");
                    }
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
                    if (firstLetter != null) {
                        task = new Task09(text, firstLetter);
                    } else {
                        logger.log(Level.ERROR, "Letter not set");
                        throw new TaskException("Letter not set");
                    }
                    break;
                case 10:
                    try {
                        Files.readAllBytes(Paths.get(clientRequest.getParameters().getFilePathOfWordList()));
                    } catch (IOException e) {
                        logger.log(Level.ERROR, "Incorrect file path of word list");
                        throw new TaskException(e);
                    }
                    task = new Task10(text, clientRequest.getParameters().getFilePathOfWordList());
                    break;
                case 11:
                    Letter secondLetter = clientRequest.getParameters().getSecondLetter();
                    if (firstLetter != null && secondLetter != null) {
                        task = new Task11(text, firstLetter, secondLetter);
                    } else {
                        logger.log(Level.ERROR, "Letter not set");
                        throw new TaskException("Letter not set");
                    }
                    break;
                case 12:
                    if (validateParameter(wordLength)) {
                        task = new Task12(text, wordLength);
                    } else {
                        logger.log(Level.ERROR, "Invalid word length");
                        throw new TaskException("Invalid word length");
                    }
                    break;
                case 13:
                    if (firstLetter != null) {
                        task = new Task13(text, firstLetter);
                    } else {
                        logger.log(Level.ERROR, "Letter not set");
                        throw new TaskException("Letter not set");
                    }
                    break;
                case 14:
                    task = new Task14(text);
                    break;
                case 15:
                    task = new Task15(text);
                    break;
                case 16:
                    String substring = clientRequest.getParameters().getSubstring();
                    if (validateParameter(wordLength) && substring != null) {
                        task = new Task16(text, substring, wordLength);
                    } else {
                        logger.log(Level.ERROR, "Substring not set/ invalid word length");
                        throw new TaskException("Substring not set/ invalid word length");
                    }

                    break;
                default:
                    throw new InvalidParameterException("Invalid task number");
            }
            return task;
        } catch (IOException e) {
            logger.log(Level.FATAL, "File does not exist");
            return null;
        } catch (InvalidParameterException e) {
            logger.log(Level.ERROR, "Wrong number of operation");
            throw new TaskException(e);
        }

    }

    private boolean validateParameter(int wordLength) {
        return wordLength > 0;
    }
}
