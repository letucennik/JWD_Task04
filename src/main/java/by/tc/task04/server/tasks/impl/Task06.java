package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;

import java.util.List;

public class Task06 extends IndividualTask {
    public Task06(Text text) {
        super(text);
    }

    @Override
    public String performTask() {
        List<TextPart> words = TextParser.parseToWords(getText());
        StringBuilder sortedWords = new StringBuilder();
        words.sort((o1, o2) -> Character.compare(Character.toLowerCase(o1.getContent().charAt(0)), Character.toLowerCase(o2.getContent().charAt(0))));
        char previousLetter = 'a';
        for (TextPart word : words) {
            if (Character.toLowerCase(word.getContent().charAt(0)) != previousLetter) {
                sortedWords.append("\n");
                previousLetter = Character.toLowerCase(word.getContent().charAt(0));
            }
            sortedWords.append(word.getContent().toLowerCase()).append(" ");
        }

        return sortedWords.toString();
    }
}
