package by.tc.task04.server.parser;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler {
    private String textContent;
    private Matcher matcher;
    public TextHandler(String textContent,Matcher matcher){
        this.textContent=textContent;
        this.matcher=matcher;
    }
    public List<Integer> startIndicesOfMatches(){
        List<Integer> startOfBlocks = new ArrayList<>();
        while (matcher.find()) {
            int start = matcher.start();
            startOfBlocks.add(start);
        }
        return startOfBlocks;
    }
    public List<Integer> endIndicesOfMatches(){
        List<Integer> endOfBlocks = new ArrayList<>();
        while (matcher.find()) {
            int end = matcher.end();
            endOfBlocks.add(end);
        }
        return endOfBlocks;
    }

}
