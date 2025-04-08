package co.edu.poli.ISW2.modelo;

public class Nacional extends Envio{

	public Nacional(Mercancias mercancia) {
		super(mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String enviar() {
		// TODO Auto-generated method stub
		
		 return "Enviando mercancía de forma nacional...";
		
	}

	@Override
	public String mostrarDetallesEnvio() {
		// TODO Auto-generated method stub
		
		   
	        return mercancia.MostrarDetalles() + "\nEnvío Nacional";
		
	}

}
