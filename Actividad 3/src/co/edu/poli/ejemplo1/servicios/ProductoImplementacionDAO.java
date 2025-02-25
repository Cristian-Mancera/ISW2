package co.edu.poli.ejemplo1.servicios;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Producto;

public class ProductoImplementacionDAO implements DAOCrud<Producto,String>{

	Connection conn;

	public ProductoImplementacionDAO() throws SQLException, IOException {

		conn = GestionConexion.obtenerConexion();
	}
	
	public List<Producto> BuscarProducto(String TerminoBusqueda) {
	    List<Producto> productos = new ArrayList<>();
	    String sql = "SELECT * FROM productos WHERE id LIKE ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	       
	        stmt.setString(1, "%" + TerminoBusqueda + "%");
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	          
	            while (rs.next()) {
	                String id = rs.getString("id");
	                String descripcion = rs.getString("describcion");
	                productos.add(new Producto(id, descripcion));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return productos;
	}
	
	
	@Override
	public String create(Producto obj) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ?? (id,nombres) VALUES (?,?)";
		
		   try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		        
		        stmt.setString(1, obj.getId());
		        stmt.setString(2, obj.getDescribcion());
		        
		        int rowsAffected = stmt.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            return "proucto creado exitosamente.";
		        } else {
		            return "No se pudo crear el producto.";
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return "Error al crear el producto: " + e.getMessage();
		    }
	}

	@Override
	public List<Producto> Read() {
		// TODO Auto-generated method stub
		List<Producto> Productos = new ArrayList<>();
	    String sql = "SELECT * FROM clientes";
	    
	    try (Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        
	        while (rs.next()) {
	            String id = rs.getString("id");
	            String describcion = rs.getString("describcion");
	            Productos.add(new Producto(id, describcion));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return Productos;
	}

	@Override
	public Cliente ReadId(String id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ?? WHERE id = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, id);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String describcion = rs.getString("nombres");
	                return new Cliente(id, describcion);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}

	@Override
	public void Update(String id, Producto obj) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE ?? SET nombres = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, obj.getDescribcion());
	        stmt.setString(2, id);
	        
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Cliente actualizado exitosamente.");
	        } else {
	            System.out.println("No se encontró el producto con ID: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM ?? WHERE id = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, id);
	        
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("producto eliminado exitosamente.");
	        } else {
	            System.out.println("No se encontró el producto con ID: " + id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	
	

}
