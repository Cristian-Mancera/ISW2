package co.edu.poli.ISW3.modelo;

public class EstadoEntregado implements EstadoPedido {

	public void avanzar(Pedido pedido) {
		System.out.println("El pedido ya fue entregado.");
	}

	public void cancelar(Pedido pedido) {
		System.out.println("No se puede cancelar un pedido entregado.");
	}

	public String obtenerEstado() {
		return "Entregado";
	}
}