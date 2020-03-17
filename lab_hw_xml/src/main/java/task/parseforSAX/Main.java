package task.parseforSAX;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

import static constant.Constants.FILE_XML_PATH;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File(FILE_XML_PATH);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            GunsHandler handler = new GunsHandler();
            saxParser.parse(file, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
