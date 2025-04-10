package co.edu.poli.ISW.modelo;

public class ProductReal implements Product {
	private String nombre;

	public ProductReal(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String mostrarDetalles() {
		return "Detalles del producto: " + nombre + "\n";
	}
}
