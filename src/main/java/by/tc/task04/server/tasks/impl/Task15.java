package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task15 extends IndividualTask {
    public Task15(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> sentencesAndBlocks = TextParser.parseToSentencesAndCodeBlocks(getText());
        StringBuilder resultString = new StringBuilder();
        for (TextPart sentenceOrBlock : sentencesAndBlocks) {
            if (sentenceOrBlock instanceof Sentence) {
                List<TextPart> sentenceWords = TextParser.parseSentenceToWords((Sentence) sentenceOrBlock, false);
                for (TextPart word : sentenceWords) {
                    if (!TextParser.PUNCTUATION_MARKS.contains(word.getContent())) {
                        List<Letter> letters = TextParser.parseWordToLetters((Word) word);
                        Letter firstLetter = letters.get(0);
                        ((Word) word).setWord(new StringBuilder(word.getContent().replaceAll(firstLetter.getContent(), "")).insert(0, firstLetter.getContent()).toString());
                    }
                }
                resultString.append(Sentence.createSentenceFromListOfWords(sentenceWords));
            } else {
                resultString.append("\n").append(sentenceOrBlock.getContent()).append("\n");
            }
        }
        return resultString.toString();
    }
}
