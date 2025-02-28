package co.edu.poli.ejemplo1.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.servicios.ClienteImplementacionDAO;
import co.edu.poli.ejemplo1.servicios.GestionConexion;
import co.edu.poli.ejemplo1.vista.Main;

public class ClienteController {

	ClienteImplementacionDAO clienteDAO;

	public ClienteController() {
		try {

			Connection conexion = GestionConexion.obtenerConexion();
			System.out.println("conexion establecida");

			clienteDAO = new ClienteImplementacionDAO();
			
			

		} catch (SQLException | IOException e) {

			System.out.println("Error durante la conexión o cierre: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public String Actioncrear() {

		Cliente c = new Cliente(Main.txtid, Main.txtname);

		return clienteDAO.create(c);

	}
}
