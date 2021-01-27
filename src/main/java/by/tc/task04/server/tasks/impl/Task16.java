package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task16 implements IndividualTask {
    private List<TextPart> sentencesAndBlocks;
    private String givenSubstring;
    private int givenWordLength;
    public Task16(List<TextPart>sentencesAndBlocks,String givenSubstring,int givenWordLength){
        this.sentencesAndBlocks=sentencesAndBlocks;
        this.givenSubstring=givenSubstring;
        this.givenWordLength=givenWordLength;
    }
    @Override
    public String performTask() {
        StringBuilder resultString=new StringBuilder();
        for(TextPart sentenceOrBlock:sentencesAndBlocks){
            if(sentenceOrBlock instanceof Sentence){
                List<TextPart> words= TextParser.parseSentenceToWords((Sentence)sentenceOrBlock,false);
                for(TextPart word:words){
                    if(word.getContent().length()==givenWordLength){
                        ((Word)word).setWord(givenSubstring);
                    }
                }
                resultString.append(Sentence.createSentenceFromListOfWords(words));
            }
            else{
                resultString.append(sentenceOrBlock.getContent());
            }
        }
        return resultString.toString();
    }
}
