package co.edu.poli.ejemplo1.modelo;

public class ProductoAlimento extends Producto implements Prototype{
	
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

	 @Override
	    public Prototype clone() {
	        try {
	            ProductoAlimento cloned = (ProductoAlimento) super.clone(); 
	            return cloned;
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	
	
	
	

}
