package co.edu.poli.ISW.modelo;

import java.util.ArrayList;
import java.util.List;

public class NotificadorProductos {

	private List<ObservadorProducto> observadores = new ArrayList<>(); 

	public void suscribir(ObservadorProducto obs) {
		observadores.add(obs);
	}

	public void notificar(double precio) {
		for (ObservadorProducto obs : observadores) {
			obs.actualizar(precio);
		}
	}
}
