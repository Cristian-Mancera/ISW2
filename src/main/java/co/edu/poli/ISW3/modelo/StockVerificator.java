package co.edu.poli.ISW3.modelo;

public class StockVerificator extends BaseHandler {

	@Override
	protected boolean puedeManejar(Order pedido) {
		return pedido.getProducto().hayStock(pedido.getCantidad());
	}

	@Override
	protected void ejecutar(Order pedido) {
		System.out.println(
				"✔ Stock verificado para " + pedido.getCantidad() + " unidades de " + pedido.getProducto().getNombre());
	}

}
