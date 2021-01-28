package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;
import java.util.stream.Collectors;

public class Task08 extends IndividualTask {
    public Task08(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        List<TextPart> words = TextParser.parseToWords(getText());
        List<TextPart> wordsStartingWithVowelLetters = words.stream().filter(x -> startsWithVowel(x.getContent())).collect(Collectors.toList());
        wordsStartingWithVowelLetters.sort((o1, o2) -> {
            List<Letter> lettersOfFirstWord = TextParser.parseWordToLetters((Word) o1);
            List<Letter> lettersOfSecondWord = TextParser.parseWordToLetters((Word) o2);
            Letter firstConsonantLetter1 = new Letter();
            Letter firstConsonantLetter2 = new Letter();
            for (Letter letter : lettersOfFirstWord) {
                if (!letter.isVowel()) {
                    firstConsonantLetter1 = letter;
                    break;
                }
            }
            for (Letter letter : lettersOfSecondWord) {
                if (!letter.isVowel()) {
                    firstConsonantLetter2 = letter;
                    break;
                }
            }
            return Character.compare(Character.toLowerCase(firstConsonantLetter1.getLetter()), Character.toLowerCase(firstConsonantLetter2.getLetter()));
        });
        for (TextPart word : wordsStartingWithVowelLetters) {
            sortedWords.append(word.getContent()).append("\n");
        }

        return sortedWords.toString();
    }

    private boolean startsWithVowel(String str) {
        return Letter.VOWEL_LETTERS.contains(Character.toString(str.charAt(0)));
    }
}
