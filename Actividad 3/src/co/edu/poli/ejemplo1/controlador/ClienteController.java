package co.edu.poli.ejemplo1.controlador;

import java.io.IOException;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.servicios.ClienteImplementacionDAO;
import co.edu.poli.ejemplo1.vista.Main;

public class ClienteController {

	
	
	
	ClienteImplementacionDAO clienteDAO;
	
	public ClienteController() throws SQLException, IOException {
		
		clienteDAO = new ClienteImplementacionDAO();
	}
	
	public String Actioncrear() {
		
		Cliente c = new Cliente(Main.txtid, Main.txtname); 
		
		return clienteDAO.create(c);
		
		
	}
}
