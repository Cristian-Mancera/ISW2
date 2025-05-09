package co.edu.poli.ISW3.modelo;

public interface Handler {

	void setSiguiente(Handler siguiente);

	void manejar(Pedido pedido);

}
