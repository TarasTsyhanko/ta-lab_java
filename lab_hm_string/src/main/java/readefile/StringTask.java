package readefile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringTask {

    Comparator<Sentence> comparatorByWords = (o1, o2) -> {
        int n = 0;
        int m = 0;
        for (MemberOfSentence member : o1.getMember()) {
            if (member.getClass().equals(Word.class)) {
                n++;
            }
        }
        for (MemberOfSentence member : o2.getMember()) {
            if (member.getClass().equals(Word.class)) {
                m++;
            }
        }
        return n - m;
    };

    public String getCommonWord(List<Sentence> list) {
        int i = 0;
        String word = "";
        for (Sentence s : list) {
            for (MemberOfSentence m : s.getMember()) {
                int j = 0;
                if (m.getClass().equals(Word.class)) {
                    for (Sentence sen : list) {
                        for (MemberOfSentence m2 : sen.getMember()) {
                            if (m.getText().equals(m2.getText())) {
                                j++;
                                break;
                            }
                        }
                    }
                } else continue;
                if (j > i) {
                    word = m.getText();
                    i = j;
                }
            }
        }
        return word;
    }
    public List<Sentence> getSentencesWithCommonWord(String string, List<Sentence> list){
        List<Sentence> list1 = new ArrayList<>();
        for (Sentence s1:list) {
            for (MemberOfSentence mem:s1.getMember()) {
                if(mem.getText().equals(string)){
                    list1.add(s1);
                    break;
                }
            }
        }
        return list1;
    }
}
