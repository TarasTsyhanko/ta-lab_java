package bigtask.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static bigtask.utils.Constants.CONSONANT_LETTER_REGEX;
import static bigtask.utils.Constants.INPUT_LETTER_REGEX;

public class ElementsUtils {
    private static String letter;

    public static void setLetter(String letter) {
        ElementsUtils.letter = letter+letter.toUpperCase();
    }

    public static boolean isSentencesElement(String string, String regex) {
        return Pattern.compile(regex).matcher(string).matches();
    }

    public static char getFirstConsonantFromWord(String str) {
        Pattern p = Pattern.compile(CONSONANT_LETTER_REGEX);
        Matcher re = p.matcher(str);
        String s = " ";
        while (re.find()) {
            s = s + re.group();
        }
        return s.charAt(0);
    }
    public static String getAllConsonantFromWord(String str) {
        Pattern p = Pattern.compile(CONSONANT_LETTER_REGEX);
        Matcher re = p.matcher(str);
        String s = "";
        while (re.find()) {
            s = s + re.group();
        }
        return s;
    }
    public static int getNumberOfSameConsonantFromWord(String str) {
        Pattern p = Pattern.compile(String.format(INPUT_LETTER_REGEX,letter));
        Matcher re = p.matcher(str);
        String s = "";
        while (re.find()) {
            s = s + re.group();
        }
        return s.length();
    }

    public static int getPercentOfVowelsInWord(String str) {
        String constant = getAllConsonantFromWord(str);
        int vowel = str.length() - constant.length();
        return (vowel * 100) / str.length();
    }

}
