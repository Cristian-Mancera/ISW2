package co.edu.poli.ISW3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Cliente cliente;
	private Producto producto;
	private int cantidad;

	public Pedido(Cliente cliente, Producto producto, int cantidad) {
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	private List<Producto> productos = new ArrayList<>();
	private EstrategiaDescuento estrategia;

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}

	public void setEstrategia(EstrategiaDescuento estrategia) {
		this.estrategia = estrategia;
	}

	public double calcularTotal() {
		double subtotal = productos.stream().mapToDouble(Producto::getPrecio).sum();
		double descuento = estrategia.calcularDescuento(subtotal);
		return subtotal - descuento;
	}

	public List<Producto> getProductos() {
		return productos;
	}

}
