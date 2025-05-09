package co.edu.poli.ISW3.modelo;

public class Client {

	private String nombre;
	private int id;

	public Client(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;

	}
}
