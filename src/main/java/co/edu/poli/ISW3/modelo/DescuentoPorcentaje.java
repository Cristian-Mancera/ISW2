package co.edu.poli.ISW3.modelo;

public class DescuentoPorcentaje implements EstrategiaDescuento {
	
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double calcularDescuento(double total) {
        return total * porcentaje;
    }
}
