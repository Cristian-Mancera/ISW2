package co.edu.poli.ISW3.modelo;

public class SinDescuento implements EstrategiaDescuento {
	
	@Override
	public double calcularDescuento(double total) {
		return 0;
	}
}
