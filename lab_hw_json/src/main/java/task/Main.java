package task;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.Pro.MyProperties;
import task.model.Guns;
import task.utils.Readers;
import task.utils.Validators;

import java.io.IOException;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private static MyProperties p = new MyProperties();

    public static void main(String[] args) throws IOException {
        boolean isValid = Validators.isJsonValid(p.getProperty("file_guns_json"), p.getProperty("schema_guns_json"));
        LOG.info(isValid);

        ObjectMapper objectMapper = new ObjectMapper();
        Guns[] guns = objectMapper.readValue(Readers.openFile(p.getProperty("file_guns_json")), Guns[].class);
        for (Guns gun : guns) {
            LOG.info("task.model: " + gun.getModel() + " handle: " + gun.getHandy() + " origin: " + gun.getOrigin()
                    + " carry: " + gun.getTtc().getCarry() + " sightingRange: " + gun.getTtc().getSightingRange()
                    + " clamp: " + gun.getTtc().isClamp() + " optics: " + gun.getTtc().isClamp() + " material: "
                    + gun.getMaterial());
        }
    }
}
