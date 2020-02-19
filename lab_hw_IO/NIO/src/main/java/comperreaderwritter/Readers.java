package comperreaderwritter;

import java.io.*;
import java.util.Scanner;

public class Readers {
    public static String readFileByBuffer(String path){
        String str;
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((str = reader.readLine()) != null) {
                text.append(str).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public static void writeFileByBuffer(String text, String path){
       try( BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
          writer.write(text);
       }catch (IOException e){
           e.printStackTrace();
       }
    }
    public static String readFileByStream(String path){
        String str;
        StringBuilder text = new StringBuilder();
        try ( DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)))){
            while (in.available() > 0) {
                    text.append(in.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public static void writeFileByStream(String text, String path){
        try( DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)))){
            out.writeBytes(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readFileJustByReader(String path){
        int i;
        StringBuilder text = new StringBuilder();
        try (FileReader reader = new FileReader(path)) {
            while ((i = reader.read()) != -1) {
                text.append((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public static void writeFileJustByWriter(String text, String path){
        try( FileWriter writer = new FileWriter(path)){
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readFileByScanner(String path){
        StringBuilder text = new StringBuilder();
       try(Scanner scan = new Scanner(new File(path))){
           while (scan.hasNext()){
               text.append(scan.nextLine());
           }
       }catch (IOException e){
           e.printStackTrace();
       }
       return text.toString();
    }
    public static void writeTextByPrintWriter(String text, String path){
       try(PrintWriter writer = new PrintWriter(path)){
           writer.println(text);
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }
    }


}
