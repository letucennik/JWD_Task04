package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 extends IndividualTask {
    private final String SUBSTRING_BETWEEN_TWO_SYMBOLS;
    public Task11(Text text, Letter firstLetter,Letter secondLetter) {
        super(text);
        SUBSTRING_BETWEEN_TWO_SYMBOLS = firstLetter.getContent() + ".+" + secondLetter.getContent();
    }

    @Override
    public String performTask() {
        List<TextPart> sentencesAndBlocks= TextParser.parseToSentencesAndCodeBlocks(super.getText());
        StringBuilder resultString = new StringBuilder();
        StringBuilder modifiedSentence;
        Pattern neededSubstringPattern = Pattern.compile(SUBSTRING_BETWEEN_TWO_SYMBOLS);
        for (TextPart sentenceOrBlock : sentencesAndBlocks) {
            if (sentenceOrBlock instanceof Sentence) {
                modifiedSentence = new StringBuilder();
                Matcher neededSubstringMatcher = neededSubstringPattern.matcher(sentenceOrBlock.getContent());
                if (neededSubstringMatcher.find()) {
                    modifiedSentence.append(sentenceOrBlock.getContent()).delete(neededSubstringMatcher.start(), neededSubstringMatcher.end());
                } else {
                    modifiedSentence.append(sentenceOrBlock.getContent());
                }
                resultString.append(modifiedSentence);
            } else {
                resultString.append(sentenceOrBlock.getContent());
            }

            resultString.append("\n");
        }
        return resultString.toString();
    }
}
