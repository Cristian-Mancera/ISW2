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

	public void GestionarCliente(String cliente, String pedido, String tipoPago) {
		System.out.println(infoP.MostrarInformacion(cliente));
		System.out.println(infoP.ActualizarInformacion(cliente));

		System.out.println(historial.MostrarHistorial(pedido));
		System.out.println(historial.RealizarPedido(pedido));

		System.out.println(pago.VisualizarFormaPago(tipoPago));
		System.out.println(pago.ActivarBloquearPago(tipoPago));
	}
}
