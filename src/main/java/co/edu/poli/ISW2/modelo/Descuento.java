package co.edu.poli.ISW2.modelo;

public class Descuento extends Decorator{
	
	private double porcentajeDescuento;

    public Descuento(CarritoDeCompras carrito, double porcentajeDescuento) {
        super(carrito);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double precioTotal() {
        double total = carrito.precioTotal();
        double descuento = total * porcentajeDescuento / 100;
        return total - descuento;
    }

    @Override
    public String obtenerDescripcion() {
        return carrito.obtenerDescripcion() + " con un descuento del " + porcentajeDescuento + "%";
    }

}
