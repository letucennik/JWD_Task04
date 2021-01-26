package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03 implements IndividualTask {
    private List<TextPart> sentences;
    public Task03(List<TextPart> sentences){
        this.sentences=sentences;
    }
    @Override
    public String performTask() {
       StringBuilder neededWordOfFirstSentence=new StringBuilder();
       List<TextPart> wordsOfFirstSentence= TextParser.parseSentenceToWords((Sentence)sentences.get(0),true);
        Map<TextPart,Integer> frequencyOfFirstSentenceWords=new HashMap<>();
       for(TextPart firstSentenceWord:wordsOfFirstSentence){
           frequencyOfFirstSentenceWords.put(firstSentenceWord,0);
           for(int i=1;i<sentences.size();i++){
               TextPart sentence=sentences.get(i);
               List<TextPart> wordsOfCurrentSentence=TextParser.parseSentenceToWords((Sentence) sentence,true);
               frequencyOfFirstSentenceWords.put(firstSentenceWord,frequencyOfFirstSentenceWords.get(firstSentenceWord)+Collections.frequency(wordsOfCurrentSentence,firstSentenceWord));
           }
       }
       for(Map.Entry<TextPart,Integer> entry:frequencyOfFirstSentenceWords.entrySet()){
           if(entry.getValue()==0){
               neededWordOfFirstSentence.append(entry.getKey().getContent()+"\n");
           }
       }
       return neededWordOfFirstSentence.toString();
    }
}
