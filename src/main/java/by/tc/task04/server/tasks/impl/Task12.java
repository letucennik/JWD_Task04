package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task12 extends IndividualTask {
    private final int wordLength;

    public Task12(Text text, int wordLength) {
        super(text);
        this.wordLength = wordLength;
    }

    @Override
    public String performTask() {
        List<TextPart> sentencesAndBlocks = TextParser.parseToSentencesAndCodeBlocks(getText());
        StringBuilder resultString = new StringBuilder();
        for (TextPart sentenceOrBlock : sentencesAndBlocks) {
            if (sentenceOrBlock instanceof Sentence) {
                List<TextPart> wordsOfSentence = TextParser.parseSentenceToWords((Sentence) sentenceOrBlock, false);
                List<TextPart> wordsToRemove = wordsOfSentence.stream().filter(x -> !startsWithVowel(x.getContent()) && x.getContent().length() == wordLength).collect(Collectors.toList());
                wordsOfSentence.removeAll(wordsToRemove);
                resultString.append(Sentence.createSentenceFromListOfWords(wordsOfSentence));
            } else {
                resultString.append("\n").append(sentenceOrBlock.getContent()).append("\n");
            }
        }

        return resultString.toString();
    }

    private boolean startsWithVowel(String str) {
        return Letter.VOWEL_LETTERS.contains(Character.toString(str.charAt(0)));
    }
}
