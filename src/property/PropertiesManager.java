package property;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {
    private Properties conf;

    public PropertiesManager(String filename){
        conf = new Properties();
        try {
            conf.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.err.println("Cannot open " + filename + ".");
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        if(conf.containsKey(key))
            return conf.getProperty(key);
        else {
            System.err.println("Key not found: " + key);
            return "";
        }
    }

}
