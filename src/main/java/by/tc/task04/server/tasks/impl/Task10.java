package by.tc.task04.server.tasks.impl;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;
import by.tc.task04.entity.impl.Text;
import by.tc.task04.entity.impl.Word;
import by.tc.task04.server.parser.TextParser;
import by.tc.task04.server.tasks.IndividualTask;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task10 extends IndividualTask {
    private final Logger logger = Logger.getLogger(Task10.class);
    private final String filePathOfWordList;

    public Task10(Text text, String filePathOfWordList) {
        super(text);
        this.filePathOfWordList = filePathOfWordList;
    }

    @Override
    public String performTask() {
        List<TextPart> sentences = TextParser.parseToSentences(getText());
        StringBuilder resultString = new StringBuilder();
        List<TextPart> givenWords = readWordsFromFile();
        for (TextPart givenWord : givenWords) {
            resultString.append(givenWord.getContent()).append(" - ");
            for (TextPart sentence : sentences) {
                long numberOfEntriesOfGivenWord = TextParser.parseSentenceToWords((Sentence) sentence, true)
                        .stream().filter(x -> x.getContent().toLowerCase().equals(givenWord.getContent().trim().toLowerCase())).count();
                resultString.append(numberOfEntriesOfGivenWord).append("; ");
            }
            resultString.append("\n");
        }
        resultString.append("\n");
        givenWords.sort((o1, o2) -> {
            long overallNumberOfEntries1 = 0;
            long overallNumberOfEntries2 = 0;
            for (TextPart sentence : sentences) {
                overallNumberOfEntries1 += TextParser.parseSentenceToWords((Sentence) sentence, true).
                        stream().filter(x -> x.getContent().toLowerCase().equals(o1.getContent().trim().toLowerCase())).count();
                overallNumberOfEntries2 += TextParser.parseSentenceToWords((Sentence) sentence, true).
                        stream().filter(x -> x.getContent().toLowerCase().equals(o2.getContent().trim().toLowerCase())).count();
            }
            return (int) (overallNumberOfEntries2 - overallNumberOfEntries1);
        });
        for (TextPart givenWord : givenWords) {
            resultString.append(givenWord.getContent()).append("\n");
        }

        return resultString.toString();
    }

    private List<TextPart> readWordsFromFile() {
        List<TextPart> givenWords = new ArrayList<>();
        File file = new File(filePathOfWordList);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                givenWords.add(new Word(line));
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            logger.info("Exception while reading word list");
            logger.error(ex);
        }
        return givenWords;
    }
}
