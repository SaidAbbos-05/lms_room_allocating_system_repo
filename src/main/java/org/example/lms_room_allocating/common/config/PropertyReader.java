package org.example.lms_room_allocating.common.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PropertyReader {
    private final Properties properties = new Properties();

    PropertyReader(String propertiesFileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName)) {
            if (Objects.nonNull(inputStream)) {
                properties.load(inputStream);
            }
        } catch (IOException ex) {
            log.error("property_reader.constructor", ex);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getProperty(String key) {
        return getProperty(key, "");
    }

    public String getProperty(String key, String defaultValue) {
        return getProperties().getProperty(key, defaultValue);
    }
}

