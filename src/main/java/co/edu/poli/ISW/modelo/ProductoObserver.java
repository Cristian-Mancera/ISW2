package co.edu.poli.ISW.modelo;

public class ProductoObserver implements ObservadorProducto {

	private double precioFinal;

	@Override
	public void actualizar(double precioOriginal) {

		this.precioFinal = precioOriginal * 0.9;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}
}
