package task.parseformapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import task.model.Guns;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constants.FILE_XML_PATH;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ObjectMapper mapper = new XmlMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try (InputStream input = new FileInputStream(new File(FILE_XML_PATH))) {
            TypeReference<List<Guns>> typeReference = new TypeReference<List<Guns>>() {
            };
            List<Guns> gunsList = mapper.readValue(input, typeReference);
            gunsList = gunsList.stream().filter(e -> e.getModel() != null).collect(Collectors.toList());
            for (Guns guns : gunsList) {
                LOG.info("model: " + guns.getModel() + " handle: " + guns.getHandy() + " origin: " + guns.getOrigin()
                        + " carry: " + guns.getTtc().getCarry() + " sightingRange: " + guns.getTtc().getSightingRange()
                        + " clamp: " + guns.getTtc().isClamp() + " optics: " + guns.getTtc().isClamp() + " material: " + guns.getMaterial());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
