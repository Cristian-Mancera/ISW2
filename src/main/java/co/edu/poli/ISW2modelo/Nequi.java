package co.edu.poli.ISW2modelo;

public class Nequi {
	private String numeroTelefono;

	public Nequi(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public boolean procesarPago(double monto) {

		return monto > 0;
	}

	public double transferirFondos(double monto) {

		return monto;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

}
