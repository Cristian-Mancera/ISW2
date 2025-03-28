package co.edu.poli.ISW2.modelo;

public class BuilderPoliticaEntrega implements Proveedor.Builder<PoliticaEntrega> {

	 private PoliticaEntrega result;

	    @Override
	    public void reset() {
	        result = new PoliticaEntrega();
	    }

	    @Override
	    public void buildStepA(String tiempoEntrega) {
	        result.setTiempoEntrega(tiempoEntrega);
	    }

	    @Override
	    public void buildStepB(String restricciones) {
	        result.setRestricciones(restricciones);
	    }

	    @Override
	    public PoliticaEntrega getResult() {
	        return result;
	    }
}