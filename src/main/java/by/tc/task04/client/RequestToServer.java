package by.tc.task04.client;

import by.tc.task04.entity.impl.Letter;

import java.io.Serializable;

public class RequestToServer implements Serializable {
    private static final long serialVersionUID = 1L;
    int numberOfOperation;
    private String filePath;
    private int wordLength;
    private Letter firstLetter;
    private Letter secondLetter;
    private String filePathOfWordList;
    private String substring;


    public RequestToServer() {
        filePath = "";
        numberOfOperation=0;
        wordLength=0;
        firstLetter=new Letter();
        secondLetter=new Letter();
        filePathOfWordList="";
    }

    public RequestToServer(String filePath, int numberOfOperation) {
        this.filePath = filePath;
        this.numberOfOperation = numberOfOperation;
    }

    public Letter getSecondLetter() {
        return secondLetter;
    }

    public void setSecondLetter(Letter secondLetter) {
        this.secondLetter = secondLetter;
    }

    public void setSubstring(String substring) {
        this.substring = substring;
    }

    public String getSubstring() {
        return substring;
    }

    public String getFilePathOfWordList() {
        return filePathOfWordList;
    }

    public void setFilePathOfWordList(String filePathOfWordList) {
        this.filePathOfWordList = filePathOfWordList;
    }

    public void setFirstLetter(Letter letter) {
        this.firstLetter = letter;
    }

    public Letter getFirstLetter() {
        return firstLetter;
    }

    public void setWordLength(int wordLength){
        this.wordLength=wordLength;
    }

    public int getWordLength() {
        return wordLength;
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
