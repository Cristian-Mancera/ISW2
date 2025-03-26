package co.edu.poli.ISW2modelo;

import java.util.Random;

public class Cliente implements Prototype {

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
        return "Cliente [id= " + id + ", nombre= " + nombre + "]";
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
      
        Random rand = new Random();
        String nuevoId = String.valueOf(rand.nextInt(1000000)); 
        return new Cliente(nuevoId, this.nombre);
    }
}
