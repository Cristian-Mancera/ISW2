package co.edu.poli.ISW.modelo;

public class Producto {

	private String nombre;
	private String precio;
	private FlyweightProveedor proveedor;

	public Producto(String nombre, FlyweightProveedor proveedor, String precio) {
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.setPrecio(precio);
	}

	public String mostrarInfo() {
		String text = "Producto: " + nombre + " - ";
		return text + "\n" + proveedor.mostrarInfo();
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;

	}

	public void cambiarPrecio(String nuevoPrecio) {
		this.precio = nuevoPrecio;
	}

	public Memento guardarPrecio(String año) {
		return new Memento(año, precio);
	}

	public String restaurarPrecio(Memento memento) {
		this.precio = memento.getPrecio();
		return "Precio restaurado al año " + memento.getAño() + ": " + precio;
	}

}
