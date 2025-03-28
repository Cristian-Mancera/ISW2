package co.edu.poli.ISW2.modelo;

public class PoliticaEntrega {
	
	private String tiempoEntrega;
    private String restricciones;

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    @Override
    public String toString() {
        return "PoliticaEntrega: Tiempo='" + tiempoEntrega + "', Restricciones='" + restricciones + "'";
    }

}
