package co.edu.poli.ISW3.modelo;

import java.util.List;

public class Pedido {
	private Cliente cliente;
	private List<Producto> productos;
	private EstadoPedido estado;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public Pedido(Cliente cliente, List<Producto> productos) {
		this.cliente = cliente;
		this.productos = productos;
		this.estado = new EstadoCreado();
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public void avanzarEstado() {
		estado.avanzar(this);
	}

	public void cancelarPedido() {
		estado.cancelar(this);
	}

	public String obtenerEstado() {
		return estado.obtenerEstado();
	}

	public void mostrarInfo() {
		System.out.println("Cliente: " + cliente.getNombre() + " (ID: " + cliente.getId() + ")");
		System.out.println("Estado del pedido: " + obtenerEstado());
		System.out.println("Productos:");
		for (Producto p : productos) {
			System.out.println("- " + p.getNombre() + " ($" + p.getPrecio() + ")");
		}
	}

	public double calcularTotal() {
		return productos.stream().mapToDouble(Producto::getPrecio).sum();
	}
}
