package co.edu.poli.ISW3.controlador;

import co.edu.poli.ISW3.modelo.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ControladorFormulario {

	@FXML
	private Button bttStrategy;

	@FXML
	private TextArea txtArea1;

	@FXML
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
