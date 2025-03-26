package co.edu.poli.ISW2modelo;

public class ProductoElectrico extends Producto implements Prototype{
	
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

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
	

}
