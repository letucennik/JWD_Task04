package by.tc.task04.server.parser;

import by.tc.task04.entity.TextPart;
import by.tc.task04.entity.impl.*;
import by.tc.task04.regex.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    
//    private Text textToParse;
//
//    public TextParser() {
//        textToParse = new Text();
//    }
//
//    public TextParser(Text textToParse) {
//        this.textToParse = textToParse;
//    }

    public static List<TextPart> parseSentenceToWords(Sentence sentence, boolean ignorePunctuationMarks) {
        List<TextPart> words = new ArrayList<>();
        String[] partsOfSentence;
        List<String> wordsAndPunctuationMarks = new ArrayList<>();
        if (ignorePunctuationMarks) {
            partsOfSentence = sentence.getContent().split(Regex.SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION);
            for (String part : partsOfSentence) {
                words.add(new Word(part));
            }
        } else {
            partsOfSentence = sentence.getContent().split(Regex.SPLITTING_SENTENCE_INTO_WORDS);
            for (String part : partsOfSentence) {
                if (part.endsWith(".") || part.endsWith(",") || part.endsWith("?") || part.endsWith(":") || part.endsWith("-") || part.endsWith(";")) {
                    Character lastChar = part.charAt(part.length() - 1);
                    wordsAndPunctuationMarks.add(part.substring(0, part.length() - 1));
                    wordsAndPunctuationMarks.add(lastChar.toString());
                } else {
                    wordsAndPunctuationMarks.add(part);
                }
            }
            for (String part : wordsAndPunctuationMarks) {
                words.add(new Word(part));
            }
        }

        return words;
    }

    public static List<Letter> parseWordToLetters(Word word){
        List<Letter> letters=new ArrayList<>();
        char[] partsOfWord=word.getContent().toCharArray();
        for(char letter: partsOfWord){
            letters.add(new Letter(letter));
        }
        return letters;
    }

    public static List<TextPart>  parseToSentencesAndCodeBlocks(Text textToParse) {
        String textContent = textToParse.getTextContent().replaceAll("\\r", "");
        List<TextPart> sentencesAndCodeBlocks = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile(Regex.SENTENCE);
        Pattern codeBlockPattern = Pattern.compile(Regex.CODE_BLOCK);
        Matcher sentenceMatcher = sentencePattern.matcher(textContent);
        Matcher codeBlockMatcher = codeBlockPattern.matcher(textContent);
        List<Integer> startOfBlocks = new ArrayList<>();
        List<Integer> endOfBlocks = new ArrayList<>();
        while (codeBlockMatcher.find()) {
            int start = codeBlockMatcher.start();
            int end = codeBlockMatcher.end();
            startOfBlocks.add(start);
            endOfBlocks.add(end);
        }
        while (sentenceMatcher.find()) {
            int start = sentenceMatcher.start();
            int end = sentenceMatcher.end();
            for (int i = 0; i < startOfBlocks.size(); i++) {
                if (start > startOfBlocks.get(i)) {
                    sentencesAndCodeBlocks.add(new CodeBlock(textContent.substring(startOfBlocks.get(i), endOfBlocks.get(i))));
                    startOfBlocks.remove(i);
                    endOfBlocks.remove(i);
                }
            }
            sentencesAndCodeBlocks.add(new Sentence(textContent.substring(start, end)));
        }
        if (startOfBlocks.size() == 1) {
            sentencesAndCodeBlocks.add(new CodeBlock(textContent.substring(startOfBlocks.get(0), endOfBlocks.get(0))));
        }
       return sentencesAndCodeBlocks;
    }
    public static List<TextPart> parseToSentences(Text textToParse){
        String textContent = textToParse.getTextContent().replaceAll("\\r", "");
        List<TextPart> sentences = new ArrayList<>();
        Pattern sentencePattern = Pattern.compile(Regex.SENTENCE);
        Matcher sentenceMatcher = sentencePattern.matcher(textContent);
        while (sentenceMatcher.find()) {
            int start = sentenceMatcher.start();
            int end = sentenceMatcher.end();
            sentences.add(new Sentence(textContent.substring(start, end)));
        }
        return sentences;
    }
    public static List<TextPart> parseToWords(Text textToParse){
        List<TextPart> sentences=parseToSentences(textToParse);
        List<TextPart> wordsOfText=new ArrayList<>();
        for(TextPart sentence:sentences){
            List<TextPart> wordsOfSentence= TextParser.parseSentenceToWords((Sentence) sentence,true);
            wordsOfText.addAll(wordsOfSentence);
        }
        return wordsOfText;
    }

}

