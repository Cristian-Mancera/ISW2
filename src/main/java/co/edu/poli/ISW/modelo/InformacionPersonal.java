package co.edu.poli.ISW.modelo;

public class InformacionPersonal {

	public String MostrarInformacion(String nombre) {
		return "Mostrando información del cliente: " + nombre;
	}

	public String ActualizarInformacion(String nombre) {
		return "Información del cliente '" + nombre + "' ha sido actualizada.";
	}
}
