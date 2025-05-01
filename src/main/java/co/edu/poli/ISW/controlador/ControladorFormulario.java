package co.edu.poli.ISW.controlador;

import co.edu.poli.ISW.modelo.Facade;
import co.edu.poli.ISW.modelo.FlyweightFactory;
import co.edu.poli.ISW.modelo.FlyweightProveedor;
import co.edu.poli.ISW.modelo.FormasPagoActivas;
import co.edu.poli.ISW.modelo.HistorialPedidos;
import co.edu.poli.ISW.modelo.HistorialPrecios;
import co.edu.poli.ISW.modelo.InformacionPersonal;
import co.edu.poli.ISW.modelo.Memento;
import co.edu.poli.ISW.modelo.NotificadorProductos;
import co.edu.poli.ISW.modelo.Producto;
import co.edu.poli.ISW.modelo.ProductoObserver;
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
	private Button bttMemento;

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
	private Button bttobserver;

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

		productos[0] = new Producto("Laptop", FlyweightFactory.getProveedor("TechCorp", "Av. Siempre Viva 123", ""),
				texto);
		productos[1] = new Producto("Mouse", FlyweightFactory.getProveedor("TechCorp", "Av. Siempre Viva 123", ""),
				texto);
		productos[2] = new Producto("Silla", FlyweightFactory.getProveedor("MueblesXYZ", "Calle Roble 456", ""), texto);
		productos[3] = new Producto("Escritorio", FlyweightFactory.getProveedor("MueblesXYZ", "Calle Roble 456", ""),
				texto);

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

	@FXML
	void memento(ActionEvent event) {

		String texto = "\n";
		Producto producto = new Producto("Laptop", null, "1200.0");
		HistorialPrecios historial = new HistorialPrecios();

		historial.guardarMemento(producto.guardarPrecio("2021"));
		producto.cambiarPrecio("1300.0");
		historial.guardarMemento(producto.guardarPrecio("2022"));
		producto.cambiarPrecio("1400.0");
		historial.guardarMemento(producto.guardarPrecio("2023"));

		texto += "Precio actual: " + producto.getPrecio();
		texto += "\n";

		Memento precio2022 = historial.obtenerMemento("2022");
		if (precio2022 != null) {
			texto += producto.restaurarPrecio(precio2022);
			texto += "\n";
		}

		texto += "Precio final después de restaurar: " + producto.getPrecio();

		txtArea1.setText(texto);

	}

	@FXML
	void observer(ActionEvent event) {
		String texto = "\n";

		Producto producto = new Producto("Laptop", null, "1200.0");
		HistorialPrecios historial = new HistorialPrecios();

		historial.guardarMemento(producto.guardarPrecio("2021"));
		producto.cambiarPrecio("1300.0");
		historial.guardarMemento(producto.guardarPrecio("2022"));
		producto.cambiarPrecio("1400.0");
		historial.guardarMemento(producto.guardarPrecio("2023"));

		Memento precio2023 = historial.obtenerMemento("2023");

		if (precio2023 != null) {
			double precioOriginal = Double.parseDouble(precio2023.getPrecio());

			NotificadorProductos notificador = new NotificadorProductos();
			ProductoObserver observador = new ProductoObserver();
			notificador.suscribir(observador);
			notificador.notificar(precioOriginal);

			texto += "Precio original: $" + precioOriginal + "\n";
			texto += "Descuento aplicado: 10%\n";
			texto += "Precio final con descuento: $" + observador.getPrecioFinal();
		}

		txtArea1.setText(texto);
	}

}
