package co.edu.poli.ISW3.modelo;

public class Producto {

	private String nombre;
	private double precio;
	private int stock;

	public Producto(String nombre, double precio, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}


	public boolean hayStock(int cantidad) {
		return stock >= cantidad;
	}

	public void reducirStock(int cantidad) {
		stock -= cantidad;
	}
}
