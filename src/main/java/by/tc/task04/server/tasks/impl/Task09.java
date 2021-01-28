package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task09 extends IndividualTask {
    private final Letter givenLetter;

    public Task09(Text text, Letter givenLetter) {
        super(text);
        this.givenLetter = givenLetter;
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        List<TextPart> words = TextParser.parseToWords(getText());
        words.sort((o1, o2) -> {
            List<Letter> lettersOfFirstWord = TextParser.parseWordToLetters((Word) o1);
            List<Letter> lettersOfSecondWord = TextParser.parseWordToLetters((Word) o2);
            long letterEntriesInFirstWord = lettersOfFirstWord.stream().filter(x -> x.equals((givenLetter))).count();
            long letterEntriesInSecondWord = lettersOfSecondWord.stream().filter(x -> x.equals((givenLetter))).count();
            if (letterEntriesInFirstWord == letterEntriesInSecondWord) {
                return o1.getContent().toLowerCase().compareTo(o2.getContent().toLowerCase());
            } else {
                return (int) (letterEntriesInFirstWord - letterEntriesInSecondWord);
            }
        });
        for (TextPart word : words) {
            sortedWords.append(word.getContent()).append("\n");
        }

        return sortedWords.toString();
    }
}
