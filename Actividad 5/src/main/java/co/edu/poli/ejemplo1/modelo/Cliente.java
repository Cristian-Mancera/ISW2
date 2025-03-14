package co.edu.poli.ejemplo1.modelo;



public class Cliente implements Prototype{

	private String id;
	private String nombre;
	

	public Cliente(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		
        return new Cliente(this.id, this.nombre);
	}
	
	

}
