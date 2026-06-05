package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

    public static void loadConfig() {
        try {
            FileInputStream file = new FileInputStream("src/main/resources/Config/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if(prop == null)
            loadConfig();
        return prop.getProperty(key);
    }
}
