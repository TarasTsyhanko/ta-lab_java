package readefile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceMemberUtils {


    public static boolean isPunctuationMark(String str) {
        Pattern re = Pattern.compile(" \\.|,|!|;|-|:|'|@|#|\\?|\\s|\\t|\\n");
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            if (str.equals(reMatcher.group())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumber(String str) {
        Pattern re = Pattern.compile("\\b(\\w*[0-9]\\w*)\\b");
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            if (str.equals(reMatcher.group())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isWord(String str) {
        Pattern re = Pattern.compile("\\b(\\w*[A-Za-z]\\w*)\\b");
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            if (str.equals(reMatcher.group())) {
                return true;
            }
        }
        return false;
    }

}
