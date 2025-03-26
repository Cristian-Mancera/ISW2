package co.edu.poli.ISW2.servicios;

import java.util.ResourceBundle;

public class ConfigLoader {

    private ResourceBundle resourceBundle;

    public ConfigLoader(String baseName) {
        
        this.resourceBundle = ResourceBundle.getBundle(baseName);
    }

    public String getDbUrl() {
        return resourceBundle.getString("db.url");
    }

    public String getDbUsername() {
        return resourceBundle.getString("db.username");
    }

    public String getDbPassword() {
        return resourceBundle.getString("db.password");
    }
    
}
