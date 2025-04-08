package co.edu.poli.ISW2.modelo;

public class CarritoNormal implements CarritoDeCompras {

	private double total;

	public CarritoNormal() {
        total = 0;
    }

	public void agregarItem(String nombre, double precio) {
		total += precio;
	}

	@Override
	public double precioTotal() {
		return total;
	}

	@Override
	public String obtenerDescripcion() {
		// TODO Auto-generated method stub
		return "Carrito básico con total: " + total + "€";
	}

}
