package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task02 extends IndividualTask {
    public Task02(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> sentences = TextParser.parseToSentences(super.getText());
        StringBuilder sortedSentences = new StringBuilder();
        sentences.sort((o1, o2) -> {
            List<TextPart> wordsOfFirstSentence = TextParser.parseSentenceToWords((Sentence) o1, true);
            List<TextPart> wordsOfSecondSentence = TextParser.parseSentenceToWords((Sentence) o2, true);
            return wordsOfFirstSentence.size() - wordsOfSecondSentence.size();
        });
        for (TextPart sentence : sentences) {
            sortedSentences.append(sentence.getContent()).append("\n");
        }
        return sortedSentences.toString();
    }
}
