package co.edu.poli.ISW3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

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
