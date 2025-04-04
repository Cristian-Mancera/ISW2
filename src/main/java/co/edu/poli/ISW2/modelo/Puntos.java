package co.edu.poli.ISW2.modelo;

public class Puntos extends Decorator{
	
	private double puntos;

    public Puntos(CarritoDeCompras carrito, double puntos) {
        super(carrito);
        this.puntos = puntos;
    }

    @Override
    public double precioTotal() {
        double total = carrito.precioTotal();
        return total - puntos; 
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion() + ", Puntos aplicados: " + puntos;
    }

}
