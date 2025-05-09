package co.edu.poli.ISW3.modelo;

public abstract class BaseHandler implements Handler {

	private Handler siguiente;

	@Override
	public void setSiguiente(Handler siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public void manejar(Order pedido) {
		if (puedeManejar(pedido)) {
			ejecutar(pedido);
		} else if (siguiente != null) {
			siguiente.manejar(pedido);
		} else {
			System.out.println("Ningún manejador pudo procesar el pedido.");
		}
	}

	protected abstract boolean puedeManejar(Order pedido);

	protected abstract void ejecutar(Order pedido);

}
