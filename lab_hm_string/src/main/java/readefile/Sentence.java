package readefile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private List<MemberOfSentence> member;

    public Sentence(String str) {
        member = new ArrayList<>();
        Pattern re = Pattern.compile("\\b(\\w*[0-9]\\w*)\\b|\\b(\\w*[A-Za-z]\\w*)\\b| \\.|,|!|;|-|:|'|@|#|\\?|\\s|\\t|\\n");
        Matcher reMatcher = re.matcher(str);
        while (reMatcher.find()) {
            if (SentenceMemberUtils.isPunctuationMark(reMatcher.group())) {
                member.add(new PunctuationMark(reMatcher.group()));
            }
            if (SentenceMemberUtils.isNumber(reMatcher.group())) {
                member.add(new Number(reMatcher.group()));
            }
            if (SentenceMemberUtils.isWord(reMatcher.group()))
                member.add(new Word(reMatcher.group()));
        }
    }

    public List<MemberOfSentence> getMember() {
        return member;
    }
}
