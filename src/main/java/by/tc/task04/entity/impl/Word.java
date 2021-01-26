package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.regex.Regex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Word implements Serializable, TextPart {
    private String word;
    public Word(){
        word="";
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word(String word){
        this.word=word;
    }
    public String getWord(){
        return word;
    }


    @Override
    public String getContent() {
        return word;
    }

    @Override
    public int hashCode() {
        return (word==null)?0:word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }
        if(null==obj){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Word w=(Word)obj;
        if(null==this.word){
            return null==w.word;
        }
        else if(!this.word.equalsIgnoreCase(w.word)){
            return false;
        }
        return true;
    }
}
