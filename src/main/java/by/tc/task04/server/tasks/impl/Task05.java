package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task05 implements IndividualTask {
    private List<TextPart> sentences;
    public Task05(List<TextPart> sentences){
        this.sentences=sentences;
    }
    @Override
    public String performTask() {
        StringBuilder modifiedSentences=new StringBuilder();
        List<Integer> newLineIndices;
        List<TextPart> modifiedWords;
        for(TextPart sentence:sentences){
//            newLineIndices=new ArrayList<>();
//            int index=sentence.getContent().indexOf("\n");
//            while(index>=0){
//                newLineIndices.add(index);
//                index=sentence.getContent().indexOf("\n",index+1);
//            }
            List<TextPart> words= TextParser.parseSentenceToWords((Sentence) sentence,false);
            Collections.swap(words,0,words.size()-2);
//            StringBuilder modifiedSentence=new StringBuilder(Sentence.createSentenceFromListOfWords(words));
//            for(int indexOfNewLine:newLineIndices){
//                modifiedSentence.insert(indexOfNewLine+1,"\n");
//            }
            modifiedSentences.append(Sentence.createSentenceFromListOfWords(words));
        }
        return modifiedSentences.toString();
    }
}
