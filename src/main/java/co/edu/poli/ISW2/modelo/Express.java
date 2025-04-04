package co.edu.poli.ISW2.modelo;

public class Express extends Envio{

	public Express(Mercancias mercancia) {
		super(mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		return "Enviando de forma express...";
	}

	@Override
	public String mostrarDetallesEnvio() {
		// TODO Auto-generated method stub
		return mercancia.MostrarDetalles() + "\nenvio express ";
	}

}
