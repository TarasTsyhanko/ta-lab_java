package task.xmltohtml;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static constant.Constants.*;

public class Main {
    public static void main(String[] args) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslDoc = new StreamSource(FILE_XSL_PATH);
            Source xmlDoc = new StreamSource(FILE_XML_PATH);
            OutputStream htmlFile = new FileOutputStream(FILE_HTML_PATH);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
