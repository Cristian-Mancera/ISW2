package co.edu.poli.ISW3.modelo;

public interface EstadoPedido {

	void avanzar(Pedido pedido);

	void cancelar(Pedido pedido);

	String obtenerEstado();
}
