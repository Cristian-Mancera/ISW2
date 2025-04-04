package co.edu.poli.ISW2.modelo;

public abstract class Decorator implements CarritoDeCompras{

	protected CarritoDeCompras carrito;

   

	public Decorator(CarritoDeCompras carrito) {
        this.carrito = carrito;
    }

    @Override
    public abstract double precioTotal();

    @Override
    public abstract String obtenerDescripcion();
	
	
	
}
