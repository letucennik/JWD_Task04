package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.server.exception.PropertiesParameterException;
import by.tc.task04.server.tasks.IndividualTask;
import by.tc.task04.server.tasks.TaskFactory;
import org.apache.log4j.Logger;

import java.io.IOException;

public class AnswerToClient {
    private final Logger logger = Logger.getLogger(AnswerToClient.class);
    private RequestToServer clientRequest;
    private TaskFactory taskFactory;


    public AnswerToClient() {
        clientRequest = new RequestToServer();
    }

    public AnswerToClient(RequestToServer clientRequest) {
        this.clientRequest = clientRequest;
    }

    public String preparedInfoForClient() throws PropertiesParameterException, IOException {
        taskFactory = new TaskFactory();
        IndividualTask userTask;
        userTask = taskFactory.createTask(clientRequest);
        return userTask.performTask();
    }

}
