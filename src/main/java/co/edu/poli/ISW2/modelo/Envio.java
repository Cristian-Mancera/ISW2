package co.edu.poli.ISW2.modelo;

public abstract class Envio {

	protected Mercancias mercancia;

	protected Envio(Mercancias mercancia) {
		this.mercancia = mercancia;
	}

	public abstract String enviar(); 

	public abstract String mostrarDetallesEnvio(); 

}
