package co.edu.poli.ISW.controlador;

import co.edu.poli.ISW.modelo.Facade;
import co.edu.poli.ISW.modelo.FlyweightFactory;
import co.edu.poli.ISW.modelo.FlyweightProveedor;
import co.edu.poli.ISW.modelo.FormasPagoActivas;
import co.edu.poli.ISW.modelo.HistorialPedidos;
import co.edu.poli.ISW.modelo.InformacionPersonal;
import co.edu.poli.ISW.modelo.Producto;
import co.edu.poli.ISW.modelo.Product;
import co.edu.poli.ISW.modelo.ProductProxy;
import co.edu.poli.ISW.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorFormulario {

	@FXML
	private Button bttfacade;

	@FXML
	private TextField txtproxy;

	@FXML
	private Button bttFlyweight;

	@FXML
	private Button bttProxy;

	@FXML
	private TextArea txtArea1;

	@FXML
	void facade(ActionEvent event) {

		String texto = "\n";

		FormasPagoActivas pago = new FormasPagoActivas();
		HistorialPedidos historial = new HistorialPedidos();
		InformacionPersonal info = new InformacionPersonal();

		Facade clienteFacade = new Facade(pago, historial, info);

		texto += clienteFacade.GestionarCliente("Juan Pérez", "Pedido #123", "Tarjeta de crédito");

		txtArea1.setText(texto);

	}

	@FXML
	void Flyweight(ActionEvent event) {

		String texto = "\n";

		Producto[] productos = new Producto[4];

		productos[0] = new Producto("Laptop", FlyweightFactory.getProveedor("TechCorp", "Av. Siempre Viva 123"));
		productos[1] = new Producto("Mouse", FlyweightFactory.getProveedor("TechCorp", "Av. Siempre Viva 123"));
		productos[2] = new Producto("Silla", FlyweightFactory.getProveedor("MueblesXYZ", "Calle Roble 456"));
		productos[3] = new Producto("Escritorio", FlyweightFactory.getProveedor("MueblesXYZ", "Calle Roble 456"));

		for (Producto p : productos) {
			texto += p.mostrarInfo();
		}

		txtArea1.setText(texto);

	}

	@FXML
	void Proxy(ActionEvent event) {

		String texto = "\n";

		int nivel = Integer.parseInt(txtproxy.getText());
		Usuario usuario = new Usuario("Alice", nivel);

		Product producto1 = new ProductProxy("Laptop Gamer", usuario);

		texto += producto1.mostrarDetalles();

		txtArea1.setText(texto);
	}

}
