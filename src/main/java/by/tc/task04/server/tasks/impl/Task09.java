package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Letter;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task09 implements IndividualTask {
    private List<TextPart> words;
    private Letter givenLetter;

    public Task09(List<TextPart> words,Letter givenLetter) {
        this.givenLetter=givenLetter;
        this.words = words;
    }
    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        Collections.sort(words, new Comparator<TextPart>() {
            @Override
            public int compare(TextPart o1, TextPart o2) {
                List<Letter> lettersOfFirstWord = TextParser.parseWordToLetters((Word) o1);
                List<Letter> lettersOfSecondWord = TextParser.parseWordToLetters((Word) o2);
                long letterEntriesInFirstWord=lettersOfFirstWord.stream().filter(x->x.equals((givenLetter))).count();
                long letterEntriesInSecondWord=lettersOfSecondWord.stream().filter(x->x.equals((givenLetter))).count();
                if(Long.compare(letterEntriesInFirstWord,letterEntriesInSecondWord)==0){
                    return o1.getContent().toLowerCase().compareTo(o2.getContent().toLowerCase());
                }
                else{
                    return (int)(letterEntriesInFirstWord-letterEntriesInSecondWord);
                }
            }
        });
        for(TextPart word:words){
            sortedWords.append(word.getContent()+"\n");
        }

        return sortedWords.toString();
    }
}
