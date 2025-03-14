package co.edu.poli.ejemplo1.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private String numero;
	private String fecha;
	private Cliente cliente;
	private List<Producto> Producto = new ArrayList<>();

	public Pedido(String numero, String fecha, Cliente cliente, List<co.edu.poli.ejemplo1.modelo.Producto> producto) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		Producto = producto;
	}
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<co.edu.poli.ejemplo1.modelo.Producto> getProducto() {
		return Producto;
	}

	public void setProducto(co.edu.poli.ejemplo1.modelo.Producto p1) {
		Producto = (List<co.edu.poli.ejemplo1.modelo.Producto>) p1;
	}

	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", Producto=" + Producto
				+ "]";
	}

}
