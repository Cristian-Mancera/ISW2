package co.edu.poli.ejemplo1.servicios;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Cliente;

public interface DAOCrud {

	
	    
	    String create (Cliente c);
	    
	    List<Cliente> Readcliente();

	    Cliente Readcliente(String id);

	    void UpdateCliente(String id, Cliente c);

	    void deleteCliente(String id);

	    
	
}
