package co.edu.poli.ISW2modelo;

public class BuilderPoliticaEntrega implements Proveedor.Builder{
	
	 private String plazo;
	    private String condiciones;

	    // Constructor
	    public BuilderPoliticaEntrega(String plazo, String condiciones) {
	        this.plazo = plazo;
	        this.condiciones = condiciones;
	    }

	    public String getPlazo() {
	        return plazo;
	    }

	    public String getCondiciones() {
	        return condiciones;
	    }

	    @Override
	    public Proveedor build() {
	        return new Proveedor(null, null, new BuilderPoliticaEntrega(this.plazo, this.condiciones));
	    }

	    @Override
	    public String toString() {
	        return "PoliticaDeEntrega{" +
	               "plazo='" + plazo + '\'' +
	               ", condiciones='" + condiciones + '\'' +
	               '}';
	    }

}
