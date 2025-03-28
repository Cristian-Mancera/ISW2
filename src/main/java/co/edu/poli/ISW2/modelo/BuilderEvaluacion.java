package co.edu.poli.ISW2.modelo;

public class BuilderEvaluacion implements Proveedor.Builder<Evaluacion> {

	private Evaluacion result;

	@Override
	public void reset() {
		result = new Evaluacion();
	}

	@Override
	public void buildStepA(String criterio) {
		result.setCriterio(criterio);
	}

	@Override
	public void buildStepB(String puntaje) {
		result.setPuntaje(Integer.parseInt(puntaje));
	}

	@Override
	public Evaluacion getResult() {
		return result;
	}
}