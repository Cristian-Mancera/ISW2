package co.edu.poli.ISW.modelo;

public class HistorialPedidos {

	public String MostrarHistorial(String pedidos) {
		return "Historial de pedidos: " + pedidos;
	}

	public String RealizarPedido(String pedido) {
		return "Pedido '" + pedido + "' ha sido realizado con éxito.";
	}
}
