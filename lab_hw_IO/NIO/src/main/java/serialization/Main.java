package serialization;

import constant.MyProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serialization.conteiner.Ship;
import serialization.model.Blaster;
import serialization.model.Droid;
import serialization.model.Type;

public class Main {
    private static String filePath = new MyProperties().getProperty("file_serialization_sever");
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Serialize<Ship<Droid>> serials = new Serialize<>();
        Droid droid = new Droid("Chappy", new Blaster(100), Type.NEXUS, 1990,2020);
        Ship<Droid> ship = new Ship<>();
        ship.put(droid);
        serials.saveObject(ship, filePath);
        Ship<Droid> ship2;
        ship2 = serials.getSavedObject(filePath);
        Droid newDroid = ship2.get(0);
        LOG.info(newDroid.getName());
        LOG.info(newDroid.getBlaster());
        LOG.info(newDroid.getType());
        LOG.info(newDroid.getCreationYear());
        LOG.info(Droid.getCurrentYear());
    }
}
