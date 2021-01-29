package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

public class Sentence implements Serializable, TextPart {
    private String sentenceContent;

    public Sentence() {
        sentenceContent = "";
    }

    public Sentence(String sentenceContent) {
        this.sentenceContent = sentenceContent;
    }

    public static String createSentenceFromListOfWords(List<TextPart> listOfWords) {
        StringBuilder content = new StringBuilder();
        for (TextPart s : listOfWords) {
            if (Pattern.matches("\\p{Punct}", s.getContent())) {
                content.deleteCharAt(content.length() - 1);
            }
            content.append(s.getContent() + " ");
        }
        content.append("\n");
        String result = content.toString();
        return result;
    }

    public String getSentenceContent() {
        return sentenceContent;
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

    @Override
    public String getContent() {
        return this.sentenceContent;
    }
}
