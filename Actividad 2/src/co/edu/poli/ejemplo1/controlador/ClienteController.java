package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.servicios.ClienteImplementacionDAO;
import co.edu.poli.ejemplo1.vista.Main;

public class ClienteController {

	
	
	
	ClienteImplementacionDAO clienteDAO;
	
	public ClienteController() {
		
		clienteDAO = new ClienteImplementacionDAO();
	}
	
	public String Actioncrear() {
		
		Cliente c = new Cliente(Main.txtid, Main.txtname); 
		
		return clienteDAO.create(c);
		
		
	}
}
