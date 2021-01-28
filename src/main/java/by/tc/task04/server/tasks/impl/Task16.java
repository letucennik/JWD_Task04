package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task16 extends IndividualTask {
    private final String givenSubstring;
    private final int givenWordLength;

    public Task16(Text text, String givenSubstring, int givenWordLength) {
        super(text);
        this.givenSubstring = givenSubstring;
        this.givenWordLength = givenWordLength;
    }

    @Override
    public String performTask() {
        List<TextPart> sentencesAndBlocks = TextParser.parseToSentencesAndCodeBlocks(getText());
        StringBuilder resultString = new StringBuilder();
        for (TextPart sentenceOrBlock : sentencesAndBlocks) {
            if (sentenceOrBlock instanceof Sentence) {
                List<TextPart> words = TextParser.parseSentenceToWords((Sentence) sentenceOrBlock, false);
                for (TextPart word : words) {
                    if (word.getContent().length() == givenWordLength) {
                        ((Word) word).setWord(givenSubstring);
                    }
                }
                resultString.append(Sentence.createSentenceFromListOfWords(words));
            } else {
                resultString.append(sentenceOrBlock.getContent());
            }
        }
        return resultString.toString();
    }
}
