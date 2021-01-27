package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task13 implements IndividualTask {
    private List<TextPart> words;
    private Letter givenLetter;

    public Task13(List<TextPart> words, Letter givenLetter) {
        this.words = words;
        this.givenLetter = givenLetter;
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        words.sort((o1, o2) -> {
            List<Letter> lettersOfFirstWord = TextParser.parseWordToLetters((Word) o1);
            List<Letter> lettersOfSecondWord = TextParser.parseWordToLetters((Word) o2);
            long letterEntriesInFirstWord = lettersOfFirstWord.stream().filter(x -> x.equals((givenLetter))).count();
            long letterEntriesInSecondWord = lettersOfSecondWord.stream().filter(x -> x.equals((givenLetter))).count();
            if (letterEntriesInFirstWord == letterEntriesInSecondWord) {
                return o2.getContent().toLowerCase().compareTo(o1.getContent().toLowerCase());
            } else {
                return (int) (letterEntriesInSecondWord - letterEntriesInFirstWord);
            }
        });
        for (TextPart word : words) {
            sortedWords.append(word.getContent()).append("\n");
        }

        return sortedWords.toString();
    }
}
