package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task01 extends IndividualTask {
    public Task01(Text text){
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> sentences=TextParser.parseToSentences(super.getText());
        int wordFrequencyCount = 0;
        for (TextPart sentence : sentences) {
            List<TextPart> wordsOfSentence = TextParser.parseSentenceToWords((Sentence) sentence, true);
            Set<TextPart> wordsWithRemovedDuplicates = new HashSet<>(wordsOfSentence);
            if (wordsWithRemovedDuplicates.size() < wordsOfSentence.size()) {
                wordFrequencyCount++;
            }
        }
        return Integer.toString(wordFrequencyCount);
    }
}
