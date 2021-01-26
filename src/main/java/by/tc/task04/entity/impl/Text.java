package by.tc.task04.entity.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.server.parser.TextParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Serializable {
    private String textContent;
    private List<TextPart> textParts;

    public Text() {
        textContent = "";
        textParts = new ArrayList<>();
    }

    public Text(String textContent) {
        this.textContent=textContent;
    }


    public void addToTextParts(TextPart textPart) {
        textParts.add(textPart);
    }

    public void removeFromTextParts(TextPart textPart) {
        textParts.remove(textPart);
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<TextPart> getTextParts() {
        return textParts;
    }

    public void setTextParts(List<TextPart> textParts) {
        this.textParts = textParts;
    }

    public List<TextPart> getSentences(){
        List<TextPart> sentences=new ArrayList<>();
        for(TextPart textPart:textParts){
            if(textPart instanceof Sentence){
                sentences.add(textPart);
            }
        }
        return sentences;
    }
    public List<TextPart> getWords(){
        List<TextPart> sentences=getSentences();
        List<TextPart> wordsOfText=new ArrayList<>();
        for(TextPart sentence:sentences){
            List<TextPart> wordsOfSentence= TextParser.parseSentenceToWords((Sentence) sentence,true);
            wordsOfText.addAll(wordsOfSentence);
        }
        return wordsOfText;
    }

    public String getTextPartsAsString() {
        if (textParts.isEmpty()) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            for (TextPart part : textParts) {
                result.append(part.getContent());
            }
            return result.toString().trim();
        }
    }

    @Override
    public int hashCode() {
        int hash = (this.textContent == null) ? 0 : this.textContent.hashCode();
        return (this.textParts == null) ? 0 : this.textParts.hashCode() + hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Text other = (Text) obj;
        if (this.textContent == null) {
            return other.textContent == null;
        } else if (!this.textContent.equals(other.textContent)) {
            return false;
        }
        if (this.textParts == null) {
            return other.textParts == null;
        } else if (!this.textParts.equals(other.textParts)) {
            return false;
        }
        return true;
    }
}
