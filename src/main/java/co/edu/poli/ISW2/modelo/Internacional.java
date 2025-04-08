package co.edu.poli.ISW2.modelo;

public class Internacional extends Envio{

	public Internacional(Mercancias mercancia) {
		super(mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		
		return "Enviando mercancía de forma internacional...";
		
	}

	@Override
	public String mostrarDetallesEnvio() {
		// TODO Auto-generated method stub
		
		
        return mercancia.MostrarDetalles() + "\nEnvío Internacional";
		
	}

}
