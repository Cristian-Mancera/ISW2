package co.edu.poli.ISW2.modelo;

public class EnvioGratis extends Decorator {

	public EnvioGratis(CarritoDeCompras carrito) {
		super(carrito);
	}

	@Override
	public double precioTotal() {
		return carrito.precioTotal(); 
	}

	@Override
	public String obtenerDescripcion() {
		return carrito.obtenerDescripcion() + ", Envío gratis aplicado";
	}
}
