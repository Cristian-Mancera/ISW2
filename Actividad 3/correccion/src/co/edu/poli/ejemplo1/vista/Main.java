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

		System.out.println("Conexión exitosa a la base de datos.");

		ClienteController cc = new ClienteController();

		System.out.println(cc.Actioncrear());

		System.out.println("Conexión cerrada exitosamente.");

	}

}
