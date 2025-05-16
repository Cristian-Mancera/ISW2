package co.edu.poli.ISW3.modelo;

public class MediatorConcrete implements Mediator {

	private Cliente cliente;
	private Pedido pedido;
	private Producto producto;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String registrarPedido(Cliente cliente, Producto producto, int cantidad) {
		// TODO Auto-generated method stub

		  if (producto.hayStock(cantidad)) {
	            producto.reducirStock(cantidad);
	            Pedido pedido = new Pedido(cliente, null, producto, cantidad);
	            return pedido.mostrarDetalle();
	        } else {
	            return "No hay suficiente stock de " + producto.getNombre() + " para: " + cliente.getNombre();
	        }
	}

}
