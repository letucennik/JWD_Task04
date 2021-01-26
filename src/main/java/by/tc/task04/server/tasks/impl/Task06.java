package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task06 implements IndividualTask {
    private List<TextPart> words;

    public Task06(List<TextPart> words) {
        this.words = words;
    }

    @Override
    public String performTask() {
        StringBuilder sortedWords = new StringBuilder();
        Collections.sort(words, new Comparator<TextPart>() {
            @Override
            public int compare(TextPart o1, TextPart o2) {
                return Character.compare(Character.toLowerCase(o1.getContent().charAt(0)), Character.toLowerCase(o2.getContent().charAt(0)));
            }
        });
        char previousLetter = 'a';
        for (TextPart word : words) {
            if (Character.toLowerCase(word.getContent().charAt(0)) != previousLetter) {
                sortedWords.append("\n");
                previousLetter = Character.toLowerCase(word.getContent().charAt(0));
            }
            sortedWords.append(word.getContent().toLowerCase() + " ");
        }

        return sortedWords.toString();
    }
}
