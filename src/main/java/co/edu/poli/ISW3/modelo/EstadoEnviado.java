package co.edu.poli.ISW3.modelo;

public class EstadoEnviado implements EstadoPedido {
	public void avanzar(Pedido pedido) {
		pedido.setEstado(new EstadoEntregado());
	}

	public void cancelar(Pedido pedido) {
		System.out.println("No se puede cancelar un pedido enviado.");
	}

	public String obtenerEstado() {
		return "Enviado";
	}
}