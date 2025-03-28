package co.edu.poli.ISW2.modelo;

public class Empleado implements Componente {
	private String nombre;
	private String puesto;

	public Empleado(String nombre, String puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
	}

	@Override
	public String mostrarInformacion() {
		String texto;

		texto = "Empleado: " + nombre + ", Cargo: " + puesto + "\n";

		return texto;

	}
}
