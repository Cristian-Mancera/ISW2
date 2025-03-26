package co.edu.poli.ISW2modelo;

public class BuilderEvaluacion implements Proveedor.Builder{
	
	private String criterio;
    private int puntuacion;

    // Constructor
    public BuilderEvaluacion(String criterio, int puntuacion) {
        this.criterio = criterio;
        this.puntuacion = puntuacion;
    }

    public String getCriterio() {
        return criterio;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public Proveedor build() {
        return new Proveedor(new BuilderEvaluacion(this.criterio, this.puntuacion), null, null);  // Esto es solo un ejemplo, ajusta según lo que necesites.
    }

    @Override
    public String toString() {
        return "Evaluacion{" +
               "criterio='" + criterio + '\'' +
               ", puntuacion=" + puntuacion +
               '}';
    }

}