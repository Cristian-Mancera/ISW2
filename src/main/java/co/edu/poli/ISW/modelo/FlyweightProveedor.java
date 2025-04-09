package co.edu.poli.ISW.modelo;

public class FlyweightProveedor {

	private String nombre;
	private String direccion;

	public FlyweightProveedor(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String mostrarInfo() {
		return "Proveedor: " + nombre + ", Dirección: " + direccion;
	}

}
