package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Anatolii_Hanziuk on 1/20/2017.
 */
public class DataLoader {

    private DataLoader() {
    }

    private static Properties properties = null;

    public static String getTestUserName() {
        return getProperty("userName");
    }

    private static String getProperty(String property) {
        if (properties == null) {
            InputStream inputStream = DataLoader.class.getResourceAsStream("test.properties");
            properties = new Properties();

            try {
                properties.load(inputStream);
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties.getProperty(property);
    }
}
