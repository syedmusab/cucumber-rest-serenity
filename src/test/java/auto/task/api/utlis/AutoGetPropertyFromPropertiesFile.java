package auto.task.api.utlis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by syed.musab on 9/26/2016.
 */
public class AutoGetPropertyFromPropertiesFile {
    private static final Logger logger = LoggerFactory.getLogger(AutoGetPropertyFromPropertiesFile.class);

    public String getPropertyValueFromPropertiesFile(String propertyKey, String filePath) {
        InputStream ioStream;

        logger.info("Getting Property Value from \"" + filePath + "\"");

        String propertyValue = null;
        try {
            Properties props = new Properties();

            ioStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(ioStream != null) {
                props.load(ioStream);
            }
            else {
                throw new FileNotFoundException("Property File '" + filePath + "' not found in the classpath");
            }

            propertyValue = props.getProperty(propertyKey);
            logger.info("Property Key: \""+ propertyKey + "\" and Value: \"" + propertyValue + "\"");
        }
        catch (Exception e){
            System.out.println("Exception: " + e);
        }

        return propertyValue;
    }
}
