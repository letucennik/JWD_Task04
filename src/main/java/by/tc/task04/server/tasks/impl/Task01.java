package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task01 implements IndividualTask {
    private List<TextPart> sentences;

    public Task01(List<TextPart> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String performTask() {
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
