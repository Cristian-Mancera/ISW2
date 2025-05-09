package co.edu.poli.ISW3.controlador;

import co.edu.poli.ISW3.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControladorFormulario {

	@FXML
	private Button bttChain;

	private Button bttStrategy;

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


	void Strategy(ActionEvent event) {

		Producto teclado = new Producto("Teclado", 100);
		Producto mouse = new Producto("Mouse", 50);

		Pedido pedido = new Pedido();
		pedido.agregarProducto(teclado);
		pedido.agregarProducto(mouse);

		// Calcular sin descuento
		pedido.setEstrategia(new SinDescuento());
		double totalSinDescuento = pedido.calcularTotal();

		// Calcular con 10% de descuento
		pedido.setEstrategia(new DescuentoPorcentaje(0.10));
		double totalDescuentoPorcentaje = pedido.calcularTotal();

		// Calcular con descuento fijo de $20
		pedido.setEstrategia(new DescuentoFijo(20));
		double totalDescuentoFijo = pedido.calcularTotal();

		StringBuilder sb = new StringBuilder();
		sb.append("Productos:\n");
		for (Producto producto : pedido.getProductos()) {
			sb.append("- ").append(producto.getNombre()).append(": $").append(producto.getPrecio()).append(" USD\n");
		}

		sb.append("\n");
		sb.append("Total sin descuento: $").append(totalSinDescuento).append("\n");
		sb.append("Total con 10% de descuento: $").append(totalDescuentoPorcentaje).append("\n");
		sb.append("Total con descuento fijo de $20: $").append(totalDescuentoFijo).append("\n");

		txtArea1.setText(sb.toString());
	}

}
