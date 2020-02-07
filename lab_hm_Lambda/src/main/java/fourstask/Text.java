package fourstask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {
    private String text;
    private List<String> list;

    public Text() {
        list = new ArrayList<>();
        while (list.size() < 10) {
            text = new Scanner(System.in).nextLine();
            if (text.equals("")) {
                break;
            } else {
                list.add(text);
            }
        }
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
