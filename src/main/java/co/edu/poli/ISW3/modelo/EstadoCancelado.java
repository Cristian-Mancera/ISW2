package co.edu.poli.ISW3.modelo;

public class EstadoCancelado implements EstadoPedido {
	public void avanzar(Pedido pedido) {
		System.out.println("No se puede avanzar, el pedido está cancelado.");
	}

	public void cancelar(Pedido pedido) {
		System.out.println("Ya está cancelado.");
	}

	public String obtenerEstado() {
		return "Cancelado";
	}
}