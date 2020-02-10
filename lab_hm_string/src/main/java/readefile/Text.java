package readefile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<Sentence> list;

    public Text() {
        String text = readFile("lab_hm_string/src/main/resources/codeconventions.txt");
        list = new ArrayList<>();
        Pattern re = Pattern.compile("[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)");
        Matcher reMatcher = re.matcher(text);
        while (reMatcher.find()) {
            list.add(new Sentence(reMatcher.group()));
        }
    }

    public List<Sentence> getList() {
        return list;
    }

    private String readFile(String path) {
        BufferedReader reader = null;
        StringBuilder text = new StringBuilder();
        String str = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if ((str = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            text.append(str);
        }
        return text.toString();
    }



}
