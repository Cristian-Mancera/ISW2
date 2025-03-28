package co.edu.poli.ISW2.modelo;

public class Evaluacion {
	
	 private String criterio;
	    private int puntaje;

	    public void setCriterio(String criterio) {
	        this.criterio = criterio;
	    }

	    public void setPuntaje(int puntaje) {
	        this.puntaje = puntaje;
	    }

	    @Override
	    public String toString() {
	        return "Evaluacion: Criterio='" + criterio + "', Puntaje=" + puntaje;
	    }

}
