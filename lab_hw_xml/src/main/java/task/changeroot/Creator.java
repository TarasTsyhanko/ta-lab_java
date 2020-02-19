package task.changeroot;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static constant.Constants.FILE_NEW_XML_PATH;

public class Creator {
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private Document document;
    private Node copy;
    TransformerFactory factory1;
    Transformer transformer;
    DOMSource source;

    private void writeContentToNewFile(Document document) {
        try {
            factory1 = TransformerFactory.newInstance();
            transformer = factory1.newTransformer();
            source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(FILE_NEW_XML_PATH));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Document createNewRoot(String filePath, String rootNewName) {
        Document newDoc = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(filePath);
            newDoc = builder.newDocument();
            Element root = newDoc.createElement(rootNewName);
            newDoc.appendChild(root);
            copy = newDoc.importNode(document.getDocumentElement(), true);
            root.appendChild(copy);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return newDoc;
    }

    public static void main(String[] args) {
        Creator main = new Creator();
        main.writeContentToNewFile(main.createNewRoot(FILE_NEW_XML_PATH,"GunsCollections"));
    }
}
