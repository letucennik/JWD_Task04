package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task07 extends IndividualTask {
    public Task07(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> words = TextParser.parseToWords(getText());
        StringBuilder sortedWords = new StringBuilder();
        words.sort((o1, o2) -> {
            List<Letter> lettersOfFirstWord = TextParser.parseWordToLetters((Word) o1);
            List<Letter> lettersOfSecondWord = TextParser.parseWordToLetters((Word) o2);
            long countVowelLettersFirst = lettersOfFirstWord.stream().filter(Letter::isVowel).count();
            long countVowelLettersSecond = lettersOfSecondWord.stream().filter(Letter::isVowel).count();
            double fractionOfVowelLettersFirst = ((double) countVowelLettersFirst) / lettersOfFirstWord.size();
            double fractionOfVowelLettersSecond = ((double) countVowelLettersSecond) / lettersOfSecondWord.size();
            return Double.compare(fractionOfVowelLettersFirst, fractionOfVowelLettersSecond);
        });
        for (TextPart word : words) {
            sortedWords.append(word.getContent()).append("\n");
        }

        return sortedWords.toString();
    }
}
