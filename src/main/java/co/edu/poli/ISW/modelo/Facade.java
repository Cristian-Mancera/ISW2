package co.edu.poli.ISW.modelo;

public class Facade {

	FormasPagoActivas pago;
	HistorialPedidos historial;
	InformacionPersonal infoP;

	public Facade(FormasPagoActivas pago, HistorialPedidos historial, InformacionPersonal infoP) {
		this.pago = pago;
		this.historial = historial;
		this.infoP = infoP;
	}

	public String GestionarCliente(String cliente, String pedido, String tipoPago) {

		String texto = "\n";
		texto += infoP.MostrarInformacion(cliente);
		texto += infoP.ActualizarInformacion(cliente);

		texto += historial.MostrarHistorial(pedido);
		texto += historial.RealizarPedido(pedido);

		texto += pago.VisualizarFormaPago(tipoPago);
		texto += pago.ActivarBloquearPago(tipoPago);

		return texto;
	}
}
