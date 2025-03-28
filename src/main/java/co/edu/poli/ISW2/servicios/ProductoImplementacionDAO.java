package co.edu.poli.ISW2.servicios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import co.edu.poli.ISW2.modelo.Producto;

public class ProductoImplementacionDAO implements specialProducto<Producto,String>{

	Connection conn;

	public ProductoImplementacionDAO() throws SQLException, IOException {

		conn = GestionConexion.obtenerConexion();
	}
	
	@Override
	public List<Producto> BuscarProducto(String TerminoBusqueda) {
		return null;
		
	    
	}
	
	
	@Override
	public String create(Producto obj) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> Read() {
		// TODO Auto-generated method stub
		
	    
	    return null;
	}

	@Override
	public Producto ReadId(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ?? WHERE id = ?";
	    
	    
	    
	    return null;
	}

	@Override
	public void Update(String id, Producto obj) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	

}
