
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public final static String PROPERTY_PATH = "src/main/resources/config.properties";
    private static final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    public static String getProperty(String key) {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTY_PATH)) {
            property.load(fis);
        } catch (IOException e) {
            logger.error(e);
        }
        String dir = property.getProperty(key);
        logger.info("Current directory is " + dir);
        return dir;
    }
}

