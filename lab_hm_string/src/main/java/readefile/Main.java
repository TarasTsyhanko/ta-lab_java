package readefile;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        StringTask stringTask = new StringTask();
        Text text = new Text();
        Collections.sort(text.getList(),stringTask.comparatorByWords);
        List<Sentence> list = stringTask.getSentencesWithCommonWord(stringTask.getCommonWord(text.getList()),text.getList());

        for (Sentence m : list) {
            m.getMember().stream().forEach(b -> System.out.print(b.getText()));
            System.out.println();
        }
    }
}
