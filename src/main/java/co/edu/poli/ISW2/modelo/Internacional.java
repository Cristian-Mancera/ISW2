package co.edu.poli.ISW2.modelo;

public class Internacional extends Envio{

	public Internacional(Mercancias mercancia) {
		super(mercancia);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enviar() {
		// TODO Auto-generated method stub
		
		System.out.println("Enviando mercancía de forma internacional...");
		
	}

	@Override
	public void mostrarDetallesEnvio() {
		// TODO Auto-generated method stub
		
		mercancia.MostrarDetalles();
        System.out.println("Envío Internacional");
		
	}

}
