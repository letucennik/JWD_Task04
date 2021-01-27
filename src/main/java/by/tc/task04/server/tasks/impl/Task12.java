package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task12 implements IndividualTask {
    private List<TextPart> sentencesAndBlocks;
    private int wordLength;
    public Task12(List<TextPart> sentencesAndBlocks,int wordLength){
        this.sentencesAndBlocks=sentencesAndBlocks;
        this.wordLength=wordLength;
    }
    @Override
    public String performTask() {
        StringBuilder resultString=new StringBuilder();
        for(TextPart sentenceOrBlock:sentencesAndBlocks){
            if(sentenceOrBlock instanceof Sentence){
                String sentenceWithRemovedWords=sentenceOrBlock.getContent();
                List<TextPart> wordsOfSentence= TextParser.parseSentenceToWords((Sentence)sentenceOrBlock,false);
                List<TextPart> wordsToRemove=wordsOfSentence.stream().filter(x->!startsWithVowel(x.getContent())&&x.getContent().length()==wordLength).collect(Collectors.toList());
                wordsOfSentence.removeAll(wordsToRemove);
                sentenceWithRemovedWords=Sentence.createSentenceFromListOfWords(wordsOfSentence);
//                for(TextPart wordToRemove:wordsToRemove){
//                    sentenceWithRemovedWords= sentenceWithRemovedWords.replace(wordToRemove.getContent(),"");
//                  //sentenceWithRemovedWords.replaceAll(wordToRemove.getContent(),"");
//                }
                resultString.append(sentenceWithRemovedWords);
            }
            else{
                resultString.append("\n"+sentenceOrBlock.getContent()+"\n");
            }
        }

        return resultString.toString();
    }
    private boolean startsWithVowel(String str) {
        return Letter.VOWEL_LETTERS.contains(Character.toString(str.charAt(0)));
    }
}
