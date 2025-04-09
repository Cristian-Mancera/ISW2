package co.edu.poli.ISW.modelo;

public class FormasPagoActivas {

	public String VisualizarFormaPago(String pago) {
		return "Forma de pago seleccionada: " + pago;
	}

	public String ActivarBloquearPago(String pago) {

		return "La forma de pago '" + pago + "' ha sido activada correctamente.";
	}
}
