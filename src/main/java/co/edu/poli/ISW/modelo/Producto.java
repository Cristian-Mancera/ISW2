package co.edu.poli.ISW.modelo;

public class Producto {

	private String nombre;
	private FlyweightProveedor proveedor;

	public Producto(String nombre, FlyweightProveedor proveedor) {
		this.nombre = nombre;
		this.proveedor = proveedor;
	}

	public String mostrarInfo() {
		String text = "Producto: " + nombre + " - ";
		return text + "\n" + proveedor.mostrarInfo();
	}

}
