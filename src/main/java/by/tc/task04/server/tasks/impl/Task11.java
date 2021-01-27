package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11 implements IndividualTask {
    private List<TextPart> sentencesAndBlocks;
    private Letter firstLetter;
    private Letter secondLetter;
    private String SUBSTRING_BETWEEN_TWO_SYMBOLS;

    public Task11(List<TextPart> sentencesAndBlocks, Letter firstLetter, Letter secondLetter) {
        this.sentencesAndBlocks = sentencesAndBlocks;
        this.firstLetter = firstLetter;
        this.secondLetter = secondLetter;
        SUBSTRING_BETWEEN_TWO_SYMBOLS = firstLetter.getContent() + ".+" + secondLetter.getContent();
    }

    @Override
    public String performTask() {
        StringBuilder resultString = new StringBuilder();
        StringBuilder modifiedSentence;
        Pattern neededSubstringPattern = Pattern.compile(SUBSTRING_BETWEEN_TWO_SYMBOLS);
        for (TextPart sentenceOrBlock : sentencesAndBlocks) {
            if (sentenceOrBlock instanceof Sentence) {
                modifiedSentence = new StringBuilder();
                Matcher neededSubstringMatcher = neededSubstringPattern.matcher(sentenceOrBlock.getContent());
                int count = 0;
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
