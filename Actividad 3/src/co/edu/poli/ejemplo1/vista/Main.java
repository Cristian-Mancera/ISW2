package co.edu.poli.ejemplo1.vista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.controlador.ClienteController;
import co.edu.poli.ejemplo1.servicios.GestionConexion;

public class Main {
	
public static String txtid = "1241";
public static String txtname = "maria";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
	          
	            Connection conexion = GestionConexion.obtenerConexion();
	            System.out.println("Conexión exitosa a la base de datos.");

	            ClienteController cc = new ClienteController();
	    		
	    		System.out.println(cc.Actioncrear());

	            
	            GestionConexion.cerrarConexion();
	            System.out.println("Conexión cerrada exitosamente.");

	        } catch (SQLException | IOException e) {
	            
	            System.out.println("Error durante la conexión o cierre: " + e.getMessage());
	            e.printStackTrace();
	        }
		
		
		

	}

}
