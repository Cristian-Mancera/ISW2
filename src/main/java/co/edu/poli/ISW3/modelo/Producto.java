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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void reducirStock(int cantidad) {
		// TODO Auto-generated method stub
		
		this.stock = stock - cantidad;
		
	}

	public boolean hayStock(int cantidad) {
		// TODO Auto-generated method stub
		return true;
	}

}
