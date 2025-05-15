package co.edu.poli.ISW3.modelo;

public class EstadoPagado implements EstadoPedido {
	public void avanzar(Pedido pedido) {
		pedido.setEstado(new EstadoEnviado());
	}

	public void cancelar(Pedido pedido) {
		pedido.setEstado(new EstadoCancelado());
	}

	public String obtenerEstado() {
		return "Pagado";
	}
}