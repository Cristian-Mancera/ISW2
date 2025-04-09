package co.edu.poli.ISW.modelo;

public class Facade {

	FormasPagoActivas pago;
	HistorialPedidos historial;
	InformacionPersonal infoP;

	public Facade(FormasPagoActivas pago, HistorialPedidos historial, InformacionPersonal infoP) {
		super();
		this.pago = pago;
		this.historial = historial;
		this.infoP = infoP;
	}

	public void GestionarCliente(String Cliente, String pedido, String tipoPago) {

		infoP.MostrarInformacion(Cliente);
		infoP.ActualizarInformacion(Cliente);
		historial.MostrarHistorial(pedido);
		historial.RealizarPedido(pedido);
		pago.VisualizarFormaPago(tipoPago);
		pago.ActivarBloquearPago(tipoPago);

	}

}
