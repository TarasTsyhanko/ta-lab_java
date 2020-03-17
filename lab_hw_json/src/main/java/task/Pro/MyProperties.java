package task.Pro;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyProperties {
    private Properties properties = new Properties();

    public MyProperties() {
        FileInputStream obj;
        try {
            obj = new FileInputStream("lab_hw_json/src/main/resources/p.properties");
            properties.load(obj);
        } catch (IOException e) {
            System.out.println("Exception, file is missing");
        }
    }

    public String getProperty(String str) {
        return properties.getProperty(str);
    }
}
