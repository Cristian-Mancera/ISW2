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

public class ClienteImplementacionDAO implements DAOCrud <Cliente, String>{

	Connection conn;

	public ClienteImplementacionDAO() throws SQLException, IOException {

		conn = GestionConexion.obtenerConexion();
	}

	@Override
	public String create(Cliente obj) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO clientes (id,nombres) VALUES (?,?)";
		
		   try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		        
		        stmt.setString(1, obj.getId());
		        stmt.setString(2, obj.getNombre());
		        
		        int rowsAffected = stmt.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            return "Cliente creado exitosamente.";
		        } else {
		            return "No se pudo crear el cliente.";
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return "Error al crear el cliente: " + e.getMessage();
		    }

	}

	@Override
	public List<Cliente> Read() {
		// TODO Auto-generated method stub
		
		List<Cliente> clientes = new ArrayList<>();
	    String sql = "SELECT * FROM clientes";
	    
	    try (Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        
	        while (rs.next()) {
	            String id = rs.getString("id");
	            String nombre = rs.getString("nombres");
	            clientes.add(new Cliente(id, nombre));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return clientes;
	}

	@Override
	public Cliente ReadId(String id) {
		// TODO Auto-generated method stub
		
		   String sql = "SELECT * FROM clientes WHERE id = ?";
		    
		    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, id);
		        
		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		                String nombre = rs.getString("nombres");
		                return new Cliente(id, nombre);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    
		    return null;
	}

	@Override
	public void Update(String id, Cliente obj) {
		// TODO Auto-generated method stub
		
		 String sql = "UPDATE clientes SET nombres = ? WHERE id = ?";
		    
		    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, obj.getNombre());
		        stmt.setString(2, id);
		        
		        int rowsAffected = stmt.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Cliente actualizado exitosamente.");
		        } else {
		            System.out.println("No se encontró el cliente con ID: " + id);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

		
		 String sql = "DELETE FROM clientes WHERE id = ?";
		    
		    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, id);
		        
		        int rowsAffected = stmt.executeUpdate();
		        
		        if (rowsAffected > 0) {
		            System.out.println("Cliente eliminado exitosamente.");
		        } else {
		            System.out.println("No se encontró el cliente con ID: " + id);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
	
	//IMPLEMENTAR LA CREACION Y EDICIO DE LA BASE DE DATOS

}
