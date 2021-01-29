package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.server.parser.TextParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements Serializable, TextPart {
    private String sentenceContent;
    private List<Word> sentenceWords;

    public Sentence() {
        sentenceContent = "";
        sentenceWords = new ArrayList<>();
    }

    public Sentence(String sentenceContent) {
        this.sentenceContent = sentenceContent;
        //sentenceWords = createListOfWordsFromString(sentenceContent);
    }

    public Sentence(List<Word> sentenceWords) {
        this.sentenceWords = sentenceWords;
       // this.sentenceContent = createSentenceFromListOfWords(sentenceWords);
    }

    public List<Word> getSentenceWords() {
        return sentenceWords;
    }

    public String getSentenceContent() {
        return sentenceContent;
    }

    public void setSentenceWords(List<Word> sentenceWords) {
        this.sentenceWords = sentenceWords;
    }

    public void setSentenceContent(String sentenceContent) {
        this.sentenceContent = sentenceContent;
    }

    @Override
    public int hashCode() {
        return (sentenceContent == null) ? 0 : sentenceContent.hashCode();
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
        Sentence w = (Sentence) obj;
        if (null == this.sentenceContent) {
            return null == w.sentenceContent;
        } else if (!this.sentenceContent.equals(w.sentenceContent)) {
            return false;
        }
        return true;
    }

    private List<TextPart> createListOfWordsFromString(String content) {
        List<TextPart> listOfWords = new ArrayList<>();
        String[] arrayOfWords = content.split(TextParser.SPLITTING_SENTENCE_INTO_WORDS);
        for (String s : arrayOfWords) {
            listOfWords.add(new Word(s));
        }
        return listOfWords;
    }

    public static String createSentenceFromListOfWords(List<TextPart> listOfWords) {
        StringBuilder content = new StringBuilder();
        for (TextPart s : listOfWords) {
            if(Pattern.matches("\\p{Punct}", s.getContent())){
                content.deleteCharAt(content.length()-1);
            }
            content.append(s.getContent()+" ");
        }
        content.append("\n");
        String result=content.toString();
        return result;
    }


    @Override
    public String getContent() {
        return this.sentenceContent;
    }
}
