package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task08 implements IndividualTask {
    private List<TextPart> words;

    public Task08(List<TextPart> words) {
        this.words = words;
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        List<TextPart> wordsStartingWithVowelLetters = words.stream().filter(x -> startsWithVowel(x.getContent())).collect(Collectors.toList());
        Collections.sort(wordsStartingWithVowelLetters, new Comparator<TextPart>() {
            @Override
            public int compare(TextPart o1, TextPart o2) {
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
            }
        });
        for(TextPart word:wordsStartingWithVowelLetters){
            sortedWords.append(word.getContent()+"\n");
        }

        return sortedWords.toString();
    }

    private boolean startsWithVowel(String str) {
        return Letter.VOWEL_LETTERS.contains(Character.toString(str.charAt(0)));
    }
}
