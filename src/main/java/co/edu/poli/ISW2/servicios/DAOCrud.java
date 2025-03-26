package co.edu.poli.ISW2.servicios;

import java.util.List;


public interface DAOCrud <T, ID>{

	
	    
	    String create (T entity);
	    
	    List<T> Read();

	    T ReadId(String id);

	    void Update(String id, T entity);

	    void delete(String id);

	    
	
}
