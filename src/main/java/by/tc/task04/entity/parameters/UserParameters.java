package by.tc.task04.entity.parameters;

import by.tc.task04.entity.impl.Letter;

import java.io.Serializable;

public class UserParameters implements Serializable {
    private static final long serialVersionUID = 128373L;
    private int wordLength;
    private Letter firstLetter;
    private Letter secondLetter;
    private String filePathOfWordList;
    private String substring;
    private UserParameters(){

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
    public static Builder newBuilder() {
        return new UserParameters().new Builder();
    }

    public class Builder{
        private Builder(){

        }
        public Builder setWordLength(int wordLength){
            UserParameters.this.wordLength=wordLength;
            return this;
        }
        public Builder setFirstLetter(Letter firstLetter){
            UserParameters.this.firstLetter=firstLetter;
            return this;
        }
        public Builder setSecondLetter(Letter secondLetter){
            UserParameters.this.secondLetter=secondLetter;
            return this;
        }
        public Builder setFilePathOfWordList(String filePathOfWordList){
            UserParameters.this.filePathOfWordList=filePathOfWordList;
            return this;
        }
        public Builder setSubstring(String substring){
            UserParameters.this.substring=substring;
            return this;
        }
        public UserParameters build(){
            return UserParameters.this;
        }

    }
}
