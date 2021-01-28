package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task03 extends IndividualTask {
    public Task03(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> sentences = TextParser.parseToSentences(super.getText());
        StringBuilder neededWordOfFirstSentence = new StringBuilder();
        List<TextPart> wordsOfFirstSentence = TextParser.parseSentenceToWords((Sentence) sentences.get(0), true);
        Map<TextPart, Integer> frequencyOfFirstSentenceWords = new HashMap<>();
        for (TextPart firstSentenceWord : wordsOfFirstSentence) {
            frequencyOfFirstSentenceWords.put(firstSentenceWord, 0);
            for (int i = 1; i < sentences.size(); i++) {
                TextPart sentence = sentences.get(i);
                List<TextPart> wordsOfCurrentSentence = TextParser.parseSentenceToWords((Sentence) sentence, true);
                frequencyOfFirstSentenceWords.put(firstSentenceWord, frequencyOfFirstSentenceWords.get(firstSentenceWord) + Collections.frequency(wordsOfCurrentSentence, firstSentenceWord));
            }
        }
        for (Map.Entry<TextPart, Integer> entry : frequencyOfFirstSentenceWords.entrySet()) {
            if (entry.getValue() == 0) {
                neededWordOfFirstSentence.append(entry.getKey().getContent()).append("\n");
            }
        }
        return neededWordOfFirstSentence.toString();
    }
}
