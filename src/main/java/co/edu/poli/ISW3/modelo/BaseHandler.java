package co.edu.poli.ISW3.modelo;

public abstract class BaseHandler implements Handler {

	private Handler siguiente;

	@Override
	public void setSiguiente(Handler siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public void manejar(Pedido pedido) {
		if (puedeManejar(pedido)) {
			ejecutar(pedido);
		} else if (siguiente != null) {
			siguiente.manejar(pedido);
		} else {
			System.out.println("no se puede manejar");
		}
	}

	protected abstract boolean puedeManejar(Pedido pedido);

	protected abstract String ejecutar(Pedido pedido);

}
