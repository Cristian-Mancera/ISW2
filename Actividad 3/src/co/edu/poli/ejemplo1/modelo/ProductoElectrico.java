package co.edu.poli.ejemplo1.modelo;

public class ProductoElectrico extends Producto{
	
	private int voltageEntrada;

	public ProductoElectrico(String id, String describcion, int voltageEntrada) {
		super(id, describcion);
		// TODO Auto-generated constructor stub
		this.voltageEntrada = voltageEntrada;
		
	}

	public int getVoltageEntrada() {
		return voltageEntrada;
	}

	public void setVoltageEntrada(int voltageEntrada) {
		this.voltageEntrada = voltageEntrada;
	}
	
	

}
