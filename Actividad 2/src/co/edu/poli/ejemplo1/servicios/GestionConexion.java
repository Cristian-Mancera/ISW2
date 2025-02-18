package co.edu.poli.ejemplo1.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionConexion {

	
	
	
	
	
	private static Connection conexion;
	
	private GestionConexion() {
		
	}
	
	public static Connection obtenerConexion() {
		
		if(conexion == null) {
			
			try {
				
				String URL = "jdbc:mysql://localhost:3306/software2";
				String USUARIO = "root";
				String CONTRASENA = "ADMIN123";
				
				conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA);
				System.out.println("conexion establecida");
				
				
			}catch(SQLException e) {
				System.out.println("error al conectar");
				e.printStackTrace();
				
			}
			
			
		}
		return conexion;
	}
	
	public static void cerrarConexion() {
		
		
		  if (conexion != null) {
		        try {
		            conexion.close(); 
		            System.out.println("Conexión cerrada exitosamente.");
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar la conexión: " + e.getMessage());
		        }
		    } else {
		        System.out.println("La conexión ya está cerrada o no está inicializada.");
		    }
	}
}
