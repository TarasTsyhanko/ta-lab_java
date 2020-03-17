package bigtask.utils;

public class Constants {
    public static final String FILE_PATH = "lab_hm_string/src/main/resources/codeconventions.txt";
    public static final String SENTENCES_REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    public static final String WORD_REGEX = "\\b(\\w*[A-Za-z]\\w*)\\b";
    public static final String NUMBER_REGEX = "\\b(\\w*[0-9]\\w*)\\b";
    public static final String PUNCTUATION_MARK_REGEX = " \\.|,|!|;|-|:|'|@|#|\\?|\\s|\\t|\\n";
    public static final String SENTENCES_MEMBER_REGEX = "\\b(\\w*[0-9]\\w*)\\b|\\b(\\w*[A-Za-z]\\w*)\\b| \\.|,|!|;|-|:|'|@|#|\\?|\\s|\\t|\\n";
    public static final String WORD_START_VOWEL_REGEX = "\\b(\\w*^[A|O|I|E|U|Y|a|u|o|i|e|y]\\w*)\\b";
    public static final String WORD_START_CONSONANT_REGEX ="\\w*^[^ AOIEUYauoiey]\\w*";
    public static final String CONSONANT_LETTER_REGEX = "[^aeioyuAEYIOU]";
    public static final String VOWEL_LETTER_REGEX = "[AaEeIiUuYyOo]";
    public static final String INPUT_LETTER_REGEX = "[%s]";
}
