package by.tc.task04.server.controller;

import by.tc.task04.client.RequestToServer;
import by.tc.task04.server.exception.AnswerToClientException;
import by.tc.task04.server.exception.TaskException;
import by.tc.task04.server.tasks.IndividualTask;
import by.tc.task04.server.tasks.TaskFactory;

public class AnswerToClient {
    private RequestToServer clientRequest;
    private TaskFactory taskFactory;


    public AnswerToClient() {
        clientRequest = new RequestToServer();
    }

    public AnswerToClient(RequestToServer clientRequest) {
        this.clientRequest = clientRequest;
    }

    public String preparedInfoForClient() throws AnswerToClientException {
        taskFactory = new TaskFactory();
        IndividualTask userTask;
        try {
            userTask = taskFactory.createTask(clientRequest);
            return userTask.performTask();
        } catch (TaskException e) {
            throw new AnswerToClientException(e);
        }
    }

}
