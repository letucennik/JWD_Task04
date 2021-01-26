package by.tc.task04.regex;

public interface Regex {
     String SPLITTING_SENTENCE_INTO_WORDS="[\\s]+";
     String SPLITTING_SENTENCE_INTO_WORDS_IGNORE_PUNCTUATION="[\\s,?!.:-]+";
     String SENTENCE="([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\{}(]|\\([^\\)]*\\))*[.?!])";
     String CODE_BLOCK="(```[a-z]*\\n[\\s\\S]*?\\n```)";
     String PUNCTUATION_MARKS=",.?:-;";
}
