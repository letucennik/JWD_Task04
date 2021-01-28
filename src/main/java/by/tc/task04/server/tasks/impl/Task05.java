package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.List;

public class Task05 extends IndividualTask {
    public Task05(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> sentences = TextParser.parseToSentences(super.getText());
        StringBuilder modifiedSentences = new StringBuilder();
        for (TextPart sentence : sentences) {
            List<TextPart> words = TextParser.parseSentenceToWords((Sentence) sentence, false);
            Collections.swap(words, 0, words.size() - 2);
            modifiedSentences.append(Sentence.createSentenceFromListOfWords(words));
        }
        return modifiedSentences.toString();
    }
}
