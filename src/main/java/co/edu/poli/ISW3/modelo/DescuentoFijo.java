package co.edu.poli.ISW3.modelo;

public class DescuentoFijo implements EstrategiaDescuento {
	
    private double monto;

    public DescuentoFijo(double monto) {
        this.monto = monto;
    }

    @Override
    public double calcularDescuento(double total) {
        return monto;
    }
}
