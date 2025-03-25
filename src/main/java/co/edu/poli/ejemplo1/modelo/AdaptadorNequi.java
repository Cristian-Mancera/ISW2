package co.edu.poli.ejemplo1.modelo;

public class AdaptadorNequi implements Pago {
	private Nequi nequi;
	private AdaptadorPayPal adaptadorPayPal;

	public AdaptadorNequi(String numeroTelefono, AdaptadorPayPal adaptadorPayPal) {
		this.nequi = new Nequi(numeroTelefono);
		this.adaptadorPayPal = adaptadorPayPal;
	}

	@Override
	public void realizarPago(double monto) {
		if (nequi.procesarPago(monto)) {
			double fondos = nequi.transferirFondos(monto);
			adaptadorPayPal.recibirPago(fondos);
		}
	}

	public void recibirPago(double monto) {
		nequi.procesarPago(monto);
	}

	public String getNumeroTelefono() {
		return nequi.getNumeroTelefono();
	}

}
