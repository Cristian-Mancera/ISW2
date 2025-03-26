package co.edu.poli.ISW2modelo;

public class AdaptadorPayPal implements Pago {
	private PayPal paypal;
	private AdaptadorNequi adaptadorNequi;

	public AdaptadorPayPal(String correo) {
		this.paypal = new PayPal(correo);
	}

	public void conectarNequi(AdaptadorNequi adaptadorNequi) {
		this.adaptadorNequi = adaptadorNequi;
	}

	@Override
	public void realizarPago(double monto) {
		if (paypal.ejecutarPago(monto)) {
			double fondos = paypal.transferirFondos(monto);
			if (adaptadorNequi != null) {
				adaptadorNequi.recibirPago(fondos);
			}
		}
	}

	public void recibirPago(double monto) {

		paypal.ejecutarPago(monto);
	}

	public String getCorreo() {
		return paypal.getCorreo();
	}

}
