package co.edu.poli.ISW2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento implements Componente {
	private String nombre;
	private List<Componente> componentes = new ArrayList<>();

	public Departamento(String nombre) {
		this.nombre = nombre;
	}

	public void agregar(Componente componente) {
		componentes.add(componente);
	}

	@Override
	public String mostrarInformacion() {
		String texto;

		texto = "Departamento: " + nombre + "\n";
		for (Componente c : componentes) {
			texto += c.mostrarInformacion();
		}
		return texto;
	}
}
