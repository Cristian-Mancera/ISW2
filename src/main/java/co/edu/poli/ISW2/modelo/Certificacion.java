package co.edu.poli.ISW2.modelo;

public class Certificacion {

	private String nombre;
	private String nivel;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Certificacion: Nombre='" + nombre + "', Nivel='" + nivel + "'";
	}

}
