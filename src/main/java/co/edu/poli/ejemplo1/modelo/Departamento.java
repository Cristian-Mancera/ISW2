package co.edu.poli.ejemplo1.modelo;

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
	public void mostrarInformacion() {
		System.out.println("Departamento: " + nombre);
		for (Componente c : componentes) {
			c.mostrarInformacion();
		}
	}
}
