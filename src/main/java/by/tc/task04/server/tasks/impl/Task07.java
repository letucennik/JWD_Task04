package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task07 implements IndividualTask {
    private List<TextPart> words;

    public Task07(List<TextPart> words) {
        this.words = words;
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        Collections.sort(words, new Comparator<TextPart>() {
            @Override
            public int compare(TextPart o1, TextPart o2) {
               List<Letter> lettersOfFirstWord= TextParser.parseWordToLetters((Word)o1);
               List<Letter> lettersOfSecondWord=TextParser.parseWordToLetters((Word)o2);
               long countVowelLettersFirst= lettersOfFirstWord.stream().filter(x->x.isVowel()).count();
               long countVowelLettersSecond=lettersOfSecondWord.stream().filter(x->x.isVowel()).count();
               double fractionOfVowelLettersFirst=((double)countVowelLettersFirst)/lettersOfFirstWord.size();
               double fractionOfVowelLettersSecond=((double)countVowelLettersSecond)/lettersOfSecondWord.size();
               return Double.compare(fractionOfVowelLettersFirst,fractionOfVowelLettersSecond);
            }
        });
        for(TextPart word:words){
            sortedWords.append(word.getContent()+"\n");
        }

        return sortedWords.toString();
    }
}
