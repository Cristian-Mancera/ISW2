package co.edu.poli.ISW3.modelo;

public class Order {

	private Client cliente;
	private Product producto;
	private int cantidad;

	public Order(Client cliente, Product producto, int cantidad) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Client getCliente() {
		return cliente;
	}

	public Product getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

}
