package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task04 extends IndividualTask {
    private final int wordLength;
    public Task04(Text text, int wordLength) {
        super(text);
        this.wordLength=wordLength;
    }
    @Override
    public String performTask() {
        List<TextPart> sentences = TextParser.parseToSentences(super.getText());
        StringBuilder wordsOfGivenLength=new StringBuilder();
        Set<TextPart> properWords=new HashSet<>();
        for(TextPart sentence:sentences){
            if(sentence.getContent().endsWith("?")){
                List<TextPart> wordsOfQuestion= TextParser.parseSentenceToWords((Sentence) sentence,true);
                for(TextPart wordOfQuestion:wordsOfQuestion){
                    if(wordOfQuestion.getContent().length()==wordLength){
                        properWords.add(wordOfQuestion);
                    }
                }
            }
        }
        for(TextPart properWord:properWords){
            wordsOfGivenLength.append(properWord.getContent()).append("\n");
        }

        return wordsOfGivenLength.toString();
    }
}
