package co.edu.poli.ISW2.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import co.edu.poli.ISW2.modelo.AdaptadorNequi;
import co.edu.poli.ISW2.modelo.AdaptadorPayPal;
import co.edu.poli.ISW2.modelo.BuilderCertificacion;
import co.edu.poli.ISW2.modelo.BuilderEvaluacion;
import co.edu.poli.ISW2.modelo.BuilderPoliticaEntrega;
import co.edu.poli.ISW2.modelo.Certificacion;
import co.edu.poli.ISW2.modelo.Cliente;
import co.edu.poli.ISW2.modelo.Departamento;
import co.edu.poli.ISW2.modelo.Empleado;
import co.edu.poli.ISW2.modelo.Evaluacion;
import co.edu.poli.ISW2.modelo.PoliticaEntrega;
import co.edu.poli.ISW2.modelo.Producto;
import co.edu.poli.ISW2.modelo.ProductoAlimento;
import co.edu.poli.ISW2.modelo.Proveedor;
import co.edu.poli.ISW2.servicios.ClienteImplementacionDAO;
import co.edu.poli.ISW2.servicios.GestionConexion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FormController {

	ClienteImplementacionDAO clienteDAO;
	ProductoAlimento alimento;

	public FormController() {

	}

	@FXML
	private TextField txt7;

	@FXML
	private Button bttAdapter;

	@FXML
	private Button bttComposite;

	@FXML
	private Button bttCopy;

	@FXML
	private Button bttsavep;

	@FXML
	private Button bttBuilder;

	@FXML
	private TextField txt6;

	@FXML
	private TextField txt5;

	@FXML
	private TextArea txtbuilder;

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
	private TableView<Producto> tblp;

	@FXML
	private TableView<Cliente> tbl;

	@FXML
	private TableColumn<Producto, String> colinfo;

	@FXML
	private TableColumn<Producto, String> colIdp;

	@FXML
	private TableColumn<Producto, String> colDescrbp;

	@FXML
	private TableColumn<Cliente, String> colId;

	@FXML
	private TableColumn<Cliente, String> colNombre;

	@FXML
	private TextArea txtadapter;

	@FXML
	private TextArea txtcomposite;

	@FXML
	void save(ActionEvent event) {
		ObservableList<Cliente> data = FXCollections.observableArrayList();

		try {
			Connection conexion = GestionConexion.obtenerConexion();
			System.out.println("Conexión establecida");

			clienteDAO = new ClienteImplementacionDAO();

			Cliente c = new Cliente(txt1.getText(), txt2.getText());

			clienteDAO.create(c);
			data.add(c);

			tbl.setItems(data);

			ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDAO.Read());
			tbl.setItems(clientes);

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Error: La clave primaria ya existe. ID duplicado: " + e.getMessage());
		} catch (SQLException | IOException e) {
			System.out.println("Error durante la conexión o la operación con la base de datos: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado: " + e.getMessage());
			e.printStackTrace();
		}
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

		Producto seleccionado = tblp.getSelectionModel().getSelectedItem();

		if (seleccionado != null) {
			Producto clon = (Producto) seleccionado.clone();
			Random random = new Random();
			int nuevoId = random.nextInt(10000);
			clon.setId(String.valueOf(nuevoId));
			tblp.getItems().add(clon);
			System.out.println("Producto clonado con nuevo ID: " + nuevoId);
		} else {
			System.out.println("Por favor, selecciona un producto para copiar.");
		}
	}

	@FXML
	void savep(ActionEvent event) {
		ObservableList<Producto> datap = tblp.getItems();
		if (txt5.getText().isEmpty() || txt6.getText().isEmpty() || txt7.getText().isEmpty()) {
			System.out.println("Por favor, completa todos los campos.");
			return;
		}
		int aporteCalorico;
		try {
			aporteCalorico = Integer.parseInt(txt7.getText());
		} catch (NumberFormatException e) {
			System.out.println("El valor ingresado en 'Aporte Calorico' no es un número entero válido.");
			return;
		}
		ProductoAlimento p = new ProductoAlimento(txt5.getText(), txt6.getText(), aporteCalorico);
		datap.add(p);
		tblp.setItems(datap);
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

		colIdp.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getId() != null ? cellData.getValue().getId() : ""));
		colDescrbp.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getDescribcion() != null ? cellData.getValue().getDescribcion() : ""));

		colinfo.setCellValueFactory(cellData -> {
			if (cellData.getValue() instanceof ProductoAlimento) {
				ProductoAlimento producto = (ProductoAlimento) cellData.getValue();
				return new SimpleStringProperty(String.valueOf(producto.getAporteCalorico()));
			} else {
				return new SimpleStringProperty("");
			}
		});
	}

	@FXML
	void builder(ActionEvent event) {

		Proveedor proveedor = new Proveedor();

		BuilderEvaluacion builderEvaluacion = new BuilderEvaluacion();
		Evaluacion evaluacion = proveedor.construir(builderEvaluacion, "Calidad del servicio", "90");
		txtbuilder.appendText(evaluacion + "\n");

		BuilderCertificacion builderCertificacion = new BuilderCertificacion();
		Certificacion certificacion = proveedor.construir(builderCertificacion, "ISO 9001", "Avanzado");
		txtbuilder.appendText(certificacion + "\n");

		BuilderPoliticaEntrega builderPolitica = new BuilderPoliticaEntrega();
		PoliticaEntrega politica = proveedor.construir(builderPolitica, "3-5 días hábiles", "No entrega los domingos");
		txtbuilder.appendText(politica + "\n");

	}

	@FXML
	void adapter(ActionEvent event) {

		AdaptadorPayPal adaptadorPayPal = new AdaptadorPayPal("paypal@gmail.com");
		AdaptadorNequi adaptadorNequi = new AdaptadorNequi("3001234567", adaptadorPayPal);

		adaptadorPayPal.conectarNequi(adaptadorNequi);

		double montoNequi = 250.0;

		String texto = "\n";
		texto += "Iniciando pago desde Nequi por $" + montoNequi + " al número: " + adaptadorNequi.getNumeroTelefono();
		adaptadorNequi.realizarPago(montoNequi);
		texto += "\n-> Pago de $" + montoNequi + " adaptado desde Nequi a PayPal " + "al correo: "
				+ adaptadorPayPal.getCorreo() + "\n";

		double montoPayPal = 250.0;

		texto += "Iniciando pago desde PayPal por $" + montoPayPal + " al correo: " + adaptadorPayPal.getCorreo();
		adaptadorPayPal.realizarPago(montoPayPal);
		texto += "\n-> Pago de $" + montoPayPal + " adaptado desde PayPal a Nequi" + " al número: "
				+ adaptadorNequi.getNumeroTelefono() + "\n";

		txtadapter.setText(texto);
	}

	@FXML
	void composite(ActionEvent event) {

		String texto = "\n";
		Empleado empleado1 = new Empleado("Juan Pérez", "Desarrollador");
		Empleado empleado2 = new Empleado("Ana Gómez", "Diseñadora");
		Empleado empleado3 = new Empleado("Carlos López", "Gerente");

		Departamento deptoIT = new Departamento("TI");
		deptoIT.agregar(empleado1);
		deptoIT.agregar(empleado2);
		deptoIT.agregar(empleado3);

		Departamento empresa = new Departamento("Empresa");
		empresa.agregar(empleado3);
		empresa.agregar(deptoIT);

		texto = empresa.mostrarInformacion();

		txtcomposite.setText(texto);
	}

}