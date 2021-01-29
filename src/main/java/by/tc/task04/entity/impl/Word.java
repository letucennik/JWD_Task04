package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;

import java.io.Serializable;

public class Word implements Serializable, TextPart {
    private String word;

    public Word() {

    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getContent() {
        return word;
    }

    @Override
    public int hashCode() {
        return (word == null) ? 0 : word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Word w = (Word) obj;
        if (null == this.word) {
            return null == w.word;
        } else if (!this.word.equalsIgnoreCase(w.word)) {
            return false;
        }
        return true;
    }
}
