package co.edu.poli.ejemplo1.modelo;

public abstract class Producto implements Cloneable, Prototype{

	private String id = "0";
	private String describcion = " ";

	public  Producto(String id, String describcion) {
		super();
		this.id = id;
		this.describcion = describcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescribcion() {
		return describcion;
	}

	public void setDescribcion(String describcion) {
		this.describcion = describcion;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion = " + describcion + "]";
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		
		return (Prototype) super.clone();
	}

	
	
}
