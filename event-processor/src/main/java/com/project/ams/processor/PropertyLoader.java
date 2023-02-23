package com.project.ams.processor;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    private Properties properties;

    public PropertyLoader() {
        this.properties = new Properties();
        try {
            properties.load(PropertyLoader.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getProperty(String key){
        return properties.getOrDefault(key, "").toString();
    }
}
