package co.edu.poli.ISW.modelo;

public class Memento {
	
	private final String precio;
    private final String año;

    public Memento(String año2, String precio) {
        this.año = año2;
        this.precio = precio;
    }

    public String getPrecio() {
        return precio;
    }

    public String getAño() {
        return año;
    }

}
