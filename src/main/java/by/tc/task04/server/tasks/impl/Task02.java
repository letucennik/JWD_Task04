package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task02 implements IndividualTask {
    private List<TextPart> sentences;
    public Task02(List<TextPart> sentences){
        this.sentences=sentences;
    }
    @Override
    public String performTask() {
        StringBuilder sortedSentences=new StringBuilder();
        Collections.sort(sentences, new Comparator<TextPart>() {
            @Override
            public int compare(TextPart o1, TextPart o2) {
                List<TextPart> wordsOfFirstSentence= TextParser.parseSentenceToWords((Sentence)o1,true);
                List<TextPart> wordsOfSecondSentence=TextParser.parseSentenceToWords((Sentence)o2,true);
                return wordsOfFirstSentence.size()-wordsOfSecondSentence.size();
            }
        });
        for(TextPart sentence:sentences){
            sortedSentences.append(sentence.getContent()+" ");
        }
        return sortedSentences.toString();
    }
}
