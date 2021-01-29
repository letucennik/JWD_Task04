package by.tc.task04.client;

import by.tc.task04.entity.parameters.UserParameters;

import java.io.Serializable;

public class RequestToServer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numberOfOperation;
    private String filePath;
    private UserParameters parameters;

    public RequestToServer() {
        filePath = "";
        numberOfOperation = 0;
    }

    public RequestToServer(String filePath, int numberOfOperation) {
        this.filePath = filePath;
        this.numberOfOperation = numberOfOperation;
    }

    public UserParameters getParameters() {
        return parameters;
    }

    public void setParameters(UserParameters parameters) {
        this.parameters = parameters;
    }

    public int getNumberOfOperation() {
        return numberOfOperation;
    }

    public void setNumberOfOperation(int numberOfOperation) {
        this.numberOfOperation = numberOfOperation;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RequestToServer other = (RequestToServer) obj;
        if (this.filePath == null) {
            return other.filePath == null;
        } else if (!this.filePath.equals(other.filePath)) {
            return false;
        }
        if (this.numberOfOperation != other.numberOfOperation) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (this.filePath == null) ? 0 : this.filePath.hashCode() + 31 * this.numberOfOperation;
    }
}
