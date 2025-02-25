package co.edu.poli.ejemplo1.modelo;

public class ProductoAlimento extends Producto{
	
	private int aporteCalorico;

	public ProductoAlimento(String id, String describcion, int aporteCalorico) {
		super(id, describcion);
		// TODO Auto-generated constructor stub
		
		this.aporteCalorico = aporteCalorico;
	}

	public int getAporteCalorico() {
		return aporteCalorico;
	}

	public void setAporteCalorico(int aporteCalorico) {
		this.aporteCalorico = aporteCalorico;
	}
	
	
	

}
