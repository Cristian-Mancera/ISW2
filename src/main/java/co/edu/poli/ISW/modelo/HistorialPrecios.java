package co.edu.poli.ISW.modelo;

import java.util.HashMap;
import java.util.Map;

public class HistorialPrecios {

	private Map<String, Memento> historial = new HashMap<>();

	public void guardarMemento(Memento memento) {
		historial.put(memento.getAño(), memento);
	}

	public Memento obtenerMemento(String año) {
		return historial.get(año);
	}
}
