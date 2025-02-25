package co.edu.poli.ejemplo1.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GestionConexion {

    private static Connection conexion;

    private GestionConexion() {
    }

    public static Connection obtenerConexion() throws SQLException, IOException {
    	 Properties properties = new Properties();
         
        
         try (InputStream input = GestionConexion.class.getClassLoader().getResourceAsStream("config.properties")) {
             if (input == null) {
                 System.out.println("No se pudo encontrar el archivo config.properties");
                 return null;
             }
             
            
             properties.load(input);
         }

         
         String dbUrl = properties.getProperty("db.url");
         String dbUsername = properties.getProperty("db.username");
         String dbPassword = properties.getProperty("db.password");

       
         conexion = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

         return conexion;
    }

    public static void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close(); 
        }
    }
}

