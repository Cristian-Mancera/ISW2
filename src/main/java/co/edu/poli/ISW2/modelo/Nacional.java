package co.edu.poli.ISW2.modelo;

public class Nacional extends Envio{

	public Nacional(Mercancias mercancia) {
		super(mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enviar() {
		// TODO Auto-generated method stub
		
		 System.out.println("Enviando mercancía de forma nacional...");
		
	}

	@Override
	public void mostrarDetallesEnvio() {
		// TODO Auto-generated method stub
		
		   mercancia.MostrarDetalles();
	        System.out.println("Envío Nacional");
		
	}

}
