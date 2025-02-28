package co.edu.poli.ejemplo1.servicios;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GestionConexion {

    private static Connection conexion;

    private GestionConexion() {
    }

    public static Connection obtenerConexion() throws SQLException, IOException {
        
        ResourceBundle bundle = ResourceBundle.getBundle("config");

       
        String dbUrl = bundle.getString("db.url");
        String dbUsername = bundle.getString("db.username");
        String dbPassword = bundle.getString("db.password");

        
        conexion = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        return conexion;
    }

    public static void cerrarConexion() throws SQLException {
        if (conexion != null) {
            conexion.close(); 
        }
    }
}