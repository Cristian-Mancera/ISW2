package co.edu.poli.ejemplo1.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Prototype;
import co.edu.poli.ejemplo1.servicios.ClienteImplementacionDAO;
import co.edu.poli.ejemplo1.servicios.GestionConexion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FormController {

	ClienteImplementacionDAO clienteDAO;

	public FormController() {

	}

	@FXML
	private Button bttCopy;

	@FXML
	private Button bttsave;

	@FXML
	private TextField txt2;

	@FXML
	private Button bttDelete;

	@FXML
	private Button bttEdit;

	@FXML
	private TextField txt1;
	
	@FXML
    private TextField txt3;

	@FXML
	private TableView<Cliente> tbl;
	
	@FXML
	private TableColumn<Cliente, String> colId; 
	    
	@FXML
	private TableColumn<Cliente, String> colNombre; 

	@FXML
	void save(ActionEvent event) {
		
		ObservableList<Cliente> data = FXCollections.observableArrayList();

		try {

			Connection conexion = GestionConexion.obtenerConexion();
			System.out.println("conexion establecida");

			clienteDAO = new ClienteImplementacionDAO();

		} catch (SQLException | IOException e) {

			System.out.println("Error durante la conexión o cierre: " + e.getMessage());
			e.printStackTrace();
		}

		Cliente c = new Cliente(txt1.getText(), txt2.getText());
		clienteDAO.create(c);
		data.add(c);
        tbl.setItems(data);
        
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
		tbl.setItems(clientes);
		

	}

	@FXML
	void Delete(ActionEvent event) {
		
		ObservableList<Cliente> data = FXCollections.observableArrayList();

		try {

			Connection conexion = GestionConexion.obtenerConexion();
			System.out.println("conexion establecida");

			clienteDAO = new ClienteImplementacionDAO();

		} catch (SQLException | IOException e) {

			System.out.println("Error durante la conexión o cierre: " + e.getMessage());
			e.printStackTrace();
		}

		Cliente c = new Cliente(txt1.getText(), txt2.getText());
		clienteDAO.delete(txt1.getText());
		
		ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
		tbl.setItems(clientes);

	}

	@FXML
	void Edit(ActionEvent event) {
		
		ObservableList<Cliente> data = FXCollections.observableArrayList();

		try {

			Connection conexion = GestionConexion.obtenerConexion();
			System.out.println("conexion establecida");

			clienteDAO = new ClienteImplementacionDAO();

		} catch (SQLException | IOException e) {

			System.out.println("Error durante la conexión o cierre: " + e.getMessage());
			e.printStackTrace();
		}

		Cliente c = new Cliente(txt1.getText(), txt2.getText());
		clienteDAO.Update(txt3.getText(), c);
		
		ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
		tbl.setItems(clientes);

	}

	@FXML
	void Copy(ActionEvent event) throws CloneNotSupportedException {
		
		ObservableList<Cliente> data = FXCollections.observableArrayList();

		
		   Cliente clienteSeleccionado = tbl.getSelectionModel().getSelectedItem();

		    if (clienteSeleccionado != null) {
		        Prototype copia = clienteSeleccionado.clone();
		        System.out.println("Copia creada: " + copia);

		        
		        clienteDAO.create((Cliente) copia);
				data.add((Cliente) copia);
		        tbl.setItems(data);
		    } else {
		        System.out.println("No hay cliente seleccionado para copiar.");
		    }
		    
		    ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
			tbl.setItems(clientes);

	}
	
	@FXML
	public void initialize() throws SQLException, IOException {
	    
	    if (clienteDAO == null) {
	        clienteDAO = new ClienteImplementacionDAO();
	    }

	    colId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
	    colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

	    
		ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
		tbl.setItems(clientes);
	}

}