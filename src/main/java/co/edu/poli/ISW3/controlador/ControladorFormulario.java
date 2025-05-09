package co.edu.poli.ISW3.controlador;

import co.edu.poli.ISW3.modelo.Client;
import co.edu.poli.ISW3.modelo.ConfirmingOrder;
import co.edu.poli.ISW3.modelo.Handler;
import co.edu.poli.ISW3.modelo.Order;
import co.edu.poli.ISW3.modelo.PaymentProcessor;
import co.edu.poli.ISW3.modelo.Product;
import co.edu.poli.ISW3.modelo.StockVerificator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControladorFormulario {

	@FXML
	private Button bttChain;

	@FXML
	private TextArea txtArea1;

	@FXML
	void memento(ActionEvent event) {

		String texto = "";

		Client cliente = new Client("Lucas", 101);
		texto += " Cliente creado: " + cliente.getNombre() + " (ID: " + cliente.getId() + ")";

		texto += "\n";
		Product producto = new Product("Teclado", 50.0, 3);
		texto += " Producto creado: " + producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Stock: "
				+ producto.getStock();

		texto += "\n";

		Order pedido1 = new Order(cliente, producto, 2);
		texto += " Pedido creado: " + pedido1.getCantidad() + " unidades de " + pedido1.getProducto().getNombre();

		texto += "\n";

		Handler verificador = new StockVerificator();
		Handler procesador = new PaymentProcessor();
		Handler confirmador = new ConfirmingOrder();

		verificador.setSiguiente(procesador);
		procesador.setSiguiente(confirmador);

		texto += "\n Procesando pedido con stock suficiente:";
		verificador.manejar(pedido1);

		texto += " Stock restante: " + producto.getStock() + "\n";

		Order pedido2 = new Order(cliente, producto, 5);
		texto += " Nuevo pedido creado: " + pedido2.getCantidad() + " unidades de " + pedido2.getProducto().getNombre();

		texto += "\n Procesando pedido con stock insuficiente:";
		verificador.manejar(pedido2);

		txtArea1.setText(texto);
	}

}
