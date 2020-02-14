package bigtask.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readers {
    public static String readFile(String path) {
        String str;
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((str = reader.readLine()) != null) {
                text.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
