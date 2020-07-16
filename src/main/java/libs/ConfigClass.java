package libs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {
    public static String configFile = "src/config.properties";

    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        FileInputStream cfg = new FileInputStream(fileName);
        p.load(cfg);
        cfg.close();
        return p.getProperty(key);
    }

    public static String getConfigValue(String key) throws IOException {
        return getValueFromFile(key, configFile);
    }

    public static void setValueToFile(String[] keysArray, String fileName) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream(fileName);
        prop.load(in);
        in.close();
        for (int i = 0; i < 15; i = i+2) {
            prop.setProperty(keysArray[i], keysArray[i+1]);
        }
        FileOutputStream out = new FileOutputStream(fileName);
        prop.store(out,null);
        out.close();
    }

    public static void setConfigValue(String[] keysArray) throws IOException {
        setValueToFile(keysArray, configFile);
    }
}
