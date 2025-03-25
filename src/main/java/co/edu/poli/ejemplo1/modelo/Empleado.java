package co.edu.poli.ejemplo1.modelo;

public class Empleado implements Componente { // Agrega "public"
	private String nombre;
	private String puesto;

	public Empleado(String nombre, String puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
	}

	@Override
	public void mostrarInformacion() {
		System.out.println("Empleado: " + nombre + ", Puesto: " + puesto);
	}
}
