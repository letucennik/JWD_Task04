package by.tc.task04.entity;

import by.tc.task04.entity.impl.Letter;

public class Properties {
    private int numberOfOperation;
    private int wordLength;
    private Letter firstLetter;
    private Letter secondLetter;
    private String filePathOfWordList;
    private String substring;
    private Properties(){

    }

    public String getSubstring() {
        return substring;
    }

    public Letter getSecondLetter() {
        return secondLetter;
    }

    public String getFilePathOfWordList() {
        return filePathOfWordList;
    }

    public int getWordLength() {
        return wordLength;
    }

    public Letter getFirstLetter() {
        return firstLetter;
    }

    public int getNumberOfOperation() {
        return numberOfOperation;
    }
    public class Builder{
        private Builder(){

        }
        public Builder setWordLength(int wordLength){
            Properties.this.wordLength=wordLength;
            return this;
        }
        public Builder setFirstLetter(Letter firstLetter){
            Properties.this.firstLetter=firstLetter;
            return this;
        }
        public Builder setSecondLetter(Letter secondLetter){
            Properties.this.secondLetter=secondLetter;
            return this;
        }
        public Builder setNumberOfOperation(int numberOfOperation){
            Properties.this.numberOfOperation=numberOfOperation;
            return this;
        }
        public Builder setFilePathOfWordList(String filePathOfWordList){
            Properties.this.filePathOfWordList=filePathOfWordList;
            return this;
        }
        public Builder setSubstring(String substring){
            Properties.this.substring=substring;
            return this;
        }
        public Properties build(){
            return Properties.this;
        }

    }
}
