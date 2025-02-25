package co.edu.poli.ejemplo1.servicios;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Cliente;

public interface DAOCrud <T, ID>{

	
	    
	    String create (T entity);
	    
	    List<T> Read();

	    Cliente ReadId(String id);

	    void Update(String id, T entity);

	    void delete(String id);

	    
	
}
