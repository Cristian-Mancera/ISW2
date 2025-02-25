package co.edu.poli.ejemplo1.servicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configLoader {

	private Properties properties;

    public configLoader() {
        properties = new Properties();
    }

    public void loadProperties(String filePath) throws IOException {
     
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        }
    }

    public String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public String getDbPassword() {
        return properties.getProperty("db.password");
    }
}
