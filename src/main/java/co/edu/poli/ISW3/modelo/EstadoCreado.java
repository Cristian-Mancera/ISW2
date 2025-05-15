package co.edu.poli.ISW3.modelo;

public class EstadoCreado implements EstadoPedido {

	public void avanzar(Pedido pedido) {
		pedido.setEstado(new EstadoPagado());
	}

	public void cancelar(Pedido pedido) {
		pedido.setEstado(new EstadoCancelado());
	}

	public String obtenerEstado() {
		return "Creado";
	}
}