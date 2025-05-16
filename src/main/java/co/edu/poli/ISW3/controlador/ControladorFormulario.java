package co.edu.poli.ISW3.controlador;

import java.util.Arrays;

import co.edu.poli.ISW3.modelo.Cliente;
import co.edu.poli.ISW3.modelo.EstadoPagado;
import co.edu.poli.ISW3.modelo.MediatorConcrete;
import co.edu.poli.ISW3.modelo.Pedido;
import co.edu.poli.ISW3.modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorFormulario {

	@FXML
	private Label lblproducto;

	@FXML
	private TextField txtnombre;

	@FXML
	private TextField txtcantidad;

	@FXML
	private Button bttMediator;

	@FXML
	private Button bttCancelar;

	@FXML
	private Button bttEntregar;

	@FXML
	private Button bttEnviar;

	@FXML
	private Button bttMostrar;

	@FXML
	private Button bttPagar;

	@FXML
	private Button bttState;

	@FXML
	private TextArea txtArea1;

	private Pedido pedido;
	
	
	

	@FXML
	void State(ActionEvent event) {
		Cliente cliente = new Cliente("001", "Juan Pérez");
		Producto p1 = new Producto("Camisa", 55.99, 0);
		Producto p2 = new Producto("Pantalón", 89.99, 0);
		pedido = new Pedido(cliente, Arrays.asList(p1, p2), p2, 0);
		txtArea1.setText("Pedido inicializado.");
	}

	@FXML
	void StateMostrar(ActionEvent event) {
		if (pedido == null) {
			txtArea1.setText("Primero inicializa el pedido.");
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ").append(pedido.getCliente().getNombre()).append(" (ID: ")
				.append(pedido.getCliente().getId()).append(")\n");
		sb.append("Estado del pedido: ").append(pedido.obtenerEstado()).append("\n");
		sb.append("Productos:\n");
		for (Producto p : pedido.getProductos()) {
			sb.append("- ").append(p.getNombre()).append(" ($").append(p.getPrecio()).append(")\n");
		}
		sb.append("Total: $").append(pedido.calcularTotal());
		txtArea1.setText(sb.toString());
	}

	@FXML
	void StatePagar(ActionEvent event) {
		if (pedido == null) {
			txtArea1.setText("Primero inicializa el pedido.");
			return;
		}

		if (pedido.obtenerEstado().equals("Creado")) {
			pedido.avanzarEstado();
			txtArea1.setText("Estado actual: " + pedido.obtenerEstado());
		} else {
			txtArea1.setText("El pedido solo puede pagarse si está en estado 'Creado'. \nEstado actual: "
					+ pedido.obtenerEstado());
		}
	}

	@FXML
	void StateEnviar(ActionEvent event) {
		if (pedido == null) {
			txtArea1.setText("Primero inicializa el pedido.");
			return;
		}

		if (pedido.obtenerEstado().equals("Pagado")) {
			pedido.avanzarEstado();
			txtArea1.setText("Pedido enviado. \nEstado actual: " + pedido.obtenerEstado());
		} else {
			txtArea1.setText(
					"Para enviar el pedido, debe estar en estado 'Pagado'. Estado actual: " + pedido.obtenerEstado());
		}
	}

	@FXML
	void StateEntregar(ActionEvent event) {
		if (pedido == null) {
			txtArea1.setText("Primero inicializa el pedido.");
			return;
		}

		if (pedido.obtenerEstado().equals("Enviado")) {
			pedido.avanzarEstado();
			txtArea1.setText("Pedido entregado correctamente.\n Estado actual: " + pedido.obtenerEstado());
		} else {
			txtArea1.setText("Para entregar el pedido, debe estar en estado 'Enviado'. Estado actual: "
					+ pedido.obtenerEstado());
		}
	}

	@FXML
	void StateCancelar(ActionEvent event) {
		if (pedido == null) {
			txtArea1.setText("Primero inicializa el pedido.");
			return;
		}

		String estadoAnterior = pedido.obtenerEstado();
		pedido.cancelarPedido();
		String estadoActual = pedido.obtenerEstado();

		if (estadoAnterior.equals(estadoActual)) {
			txtArea1.setText("No se pudo cancelar el pedido. \nEstado actual: " + estadoActual);
		} else {
			txtArea1.setText("Pedido cancelado. \nEstado actual: " + estadoActual);
		}
	}

	@FXML
	void Mediator(ActionEvent event) {

		String texto = "\n";

		if (txtnombre.getText().isEmpty() || txtcantidad.getText().isEmpty()) {

			texto += "rellene los campos vacios";

		} else {

			MediatorConcrete mediator = new MediatorConcrete();

			Cliente cliente = new Cliente("1", txtnombre.getText());
			Producto producto = new Producto("Laptop", 0, 5);

			texto += mediator.registrarPedido(cliente, producto, Integer.parseInt(txtcantidad.getText()));

			texto += "\n";

		}

		txtArea1.setText(texto);

	}
}
