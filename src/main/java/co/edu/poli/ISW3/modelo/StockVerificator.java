package co.edu.poli.ISW3.modelo;

public class StockVerificator extends BaseHandler {

	@Override
	protected boolean puedeManejar(Pedido pedido) {
		return pedido.getProducto().hayStock(pedido.getCantidad());
	}

	@Override
	public String ejecutar(Pedido pedido) {
		return	"✔ Stock verificado para " + pedido.getCantidad() + " unidades de " + pedido.getProducto().getNombre();
	}

}
