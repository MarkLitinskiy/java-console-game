package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Properties {
    private static final java.util.Properties PROPERTIES = new java.util.Properties();
    public static void loadProperties(String profile) {
        String path = "";
        if(profile.equals("development")){
            path = "src/main/resources/application-dev.properties";
        } else if (profile.equals("production")){
            path = "src/main/resources/application-production.properties";
        }
        try (FileInputStream inputStream = new FileInputStream(path)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
