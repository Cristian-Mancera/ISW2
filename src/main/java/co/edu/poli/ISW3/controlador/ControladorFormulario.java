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
	void Chain(ActionEvent event) {

		String texto = "";

		Cliente cliente = new Cliente("101", "Robert");
		texto += " Cliente: " + cliente.getNombre() + " (ID: " + cliente.getId() + ")";

		texto += "\n";
		Producto producto = new Producto("Teclado", 50.0, 3);
		texto += " Producto: " + producto.getNombre() + " - Precio: $" + producto.getPrecio() + " - Stock: "
				+ producto.getStock();

		texto += "\n";

		Pedido pedido1 = new Pedido(cliente, producto, 2);
		texto += " Pedido: " + pedido1.getCantidad() + " unidades de " + pedido1.getProducto().getNombre();

		texto += "\n";

		Handler verificador = new StockVerificator();
		Handler procesador = new PaymentProcessor();
		Handler confirmador = new ConfirmingOrder();

		verificador.setSiguiente(procesador);
		procesador.setSiguiente(confirmador);

		texto += "\nProcesando pedido:";
		verificador.manejar(pedido1);
		texto += "\n";
		texto += ((StockVerificator) verificador).ejecutar(pedido1);
		texto += "\n";
		texto += ((PaymentProcessor) procesador).ejecutar(pedido1);
		texto += "\n";
		texto += ((ConfirmingOrder) confirmador).ejecutar(pedido1);
		texto += "\n";
		texto += "Stock restante: " + producto.getStock() + "\n";

		txtArea1.setText(texto);
	}

	@FXML
	void Strategy(ActionEvent event) {

		Producto teclado = new Producto("Teclado", 100, 0);
		Producto mouse = new Producto("Mouse", 50, 0);

		Pedido pedido = new Pedido(null, mouse, 0);
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
