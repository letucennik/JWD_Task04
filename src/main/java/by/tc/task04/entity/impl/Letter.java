package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;

import java.io.Serializable;

public class Letter implements Serializable, TextPart {
    private static final long serialVersionUID = 2L;
    public static String VOWEL_LETTERS="AEIOUaeiou";
    private char letter;
    public Letter(){}
    public Letter(char letter){
        this.letter=letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public boolean isVowel(){
        return VOWEL_LETTERS.indexOf(letter) != -1;
    }

    public Letter toLowerCase(){
        return new Letter(Character.toLowerCase(this.letter));
    }

    @Override
    public int hashCode() {
        return Character.hashCode(letter);
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
        Letter letter=(Letter)obj;
        return this.letter==letter.letter;
    }

    @Override
    public String getContent() {
        return Character.toString(letter);
    }
}
