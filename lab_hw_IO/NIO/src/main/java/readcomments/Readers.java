package readcomments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readers {//read comment in java file without REGEX

    public static String openJavaFile(String path) {
        String comment = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            comment = readFile(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comment;
    }

    private static String readFile(BufferedReader br) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = catchComment(br.readLine(), br)) != null) {
            if (!str.isEmpty()) {
                sb.append(str).append("\n");
            }
        }
        return sb.toString();
    }

    private static String catchComment(String line, BufferedReader read) throws IOException {
        if (line == null) return null;
        if (line.length() < 3) return "";
        line = line.trim();
        if (line.contains("//")) {
            if (line.substring(0, 2).equals("//")) {
                return line;
            }else if(line.contains(";")) {
                line = line.substring(line.lastIndexOf(";"));
                if(!line.isEmpty()){
                    String[] str = line.split("//");
                    String s = "";
                    for (int i = 1;i<str.length;i++){
                        s = s+str[i];
                    }
                    return s;
                }
            }
            String[] str = line.split("//");
            return str[str.length - 1];
        } else if (line.contains("/*")) {
            if (line.contains("*/") && line.indexOf("/*") < line.indexOf("*/")) {
                if(line.indexOf("/*")==0){
                    return line.substring(line.lastIndexOf("/*"), line.indexOf("*/"));
                }else if (line.substring(line.length()-2).equals("*/")){
                  for (int i =line.length()-2;i>0;i--){
                      if (line.substring(i-2,i).equals("/*")){
                          return line.substring(i-2);
                      }
                  }
                }
            } else {
                String str;
                StringBuilder builder = new StringBuilder(line.substring(3)).append("\n");
                while ((str = read.readLine()) != null) {
                    if (str.contains("*/")) {
                        builder.append(str.trim());
                        return builder.toString();
                    }
                    if (!str.isEmpty()) {
                        builder.append(str.trim()).append("\n");
                    }
                }
            }
        }
        return "";
    }
}
