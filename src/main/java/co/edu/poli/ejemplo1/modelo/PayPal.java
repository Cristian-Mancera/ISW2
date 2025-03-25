package co.edu.poli.ejemplo1.modelo;

public class PayPal {
	private String correo;

	public PayPal(String correo) {
		this.correo = correo;
	}

	public boolean ejecutarPago(double monto) {

		return monto > 0;
	}

	public double transferirFondos(double monto) {

		return monto;
	}

	public String getCorreo() {
		return correo;
	}

}
