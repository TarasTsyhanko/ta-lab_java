package constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constant.Constants.PROPERTIES_FILE_PATH;

public class MyProperties {
    private Properties properties = new Properties();

    public MyProperties() {
        FileInputStream obj;
        try {
            obj = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(obj);
        } catch (IOException e) {
            System.out.println("Exception, file is missing");
        }
    }

    public String getProperty(String str) {
        return properties.getProperty(str);
    }
}
