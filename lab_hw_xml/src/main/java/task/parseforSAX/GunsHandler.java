package task.parseforSAX;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import task.parseformapper.Main;

public class GunsHandler extends DefaultHandler {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private boolean bModel = false;
    private boolean bHandy = false;
    private boolean bOrigin = false;
    private boolean bCarry = false;
    private boolean bSightingRange = false;
    private boolean bClam = false;
    private boolean bOptics = false;
    private boolean bMaterials = false;


    @Override
    public void startElement(String uri, String localhost, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("Guns")) {
            LOG.info("Element :" + qName);
        }
        if (qName.equalsIgnoreCase("task.model")) {
            bModel = true;
        } else if (qName.equalsIgnoreCase("handy")) {
            bHandy = true;
        } else if (qName.equalsIgnoreCase("origin")) {
            bOrigin = true;
        } else if (qName.equalsIgnoreCase("carry")) {
            bCarry = true;
        } else if (qName.equalsIgnoreCase("sightingRange")) {
            bSightingRange = true;
        } else if (qName.equalsIgnoreCase("clamp")) {
            bClam = true;
        } else if (qName.equalsIgnoreCase("optics")) {
            bOptics = true;
        } else if (qName.equalsIgnoreCase("material")) {
            bMaterials = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("Guns")) {
            LOG.info("  ");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        if (bModel) {
            LOG.info("Model: " + new String(ch, start, length));
            bModel = false;
        } else if (bHandy) {
            LOG.info("Handy: " + new String(ch, start, length));
            bHandy = false;
        } else if (bOrigin) {
            LOG.info("Origin: " + new String(ch, start, length));
            bOrigin = false;
        } else if (bCarry) {
            LOG.info("Carry: " + new String(ch, start, length));
            bCarry = false;
        } else if (bSightingRange) {
            LOG.info("SightingRange: " + new String(ch, start, length));
            bSightingRange = false;
        } else if (bClam) {
            LOG.info("Clam: " + new String(ch, start, length));
            bClam = false;
        } else if (bOptics) {
            LOG.info("Optics: " + new String(ch, start, length));
            bOptics = false;
        } else if (bMaterials) {
            LOG.info("Materials: " + new String(ch, start, length));
            bMaterials = false;
        }
    }
}
