package co.edu.poli.ISW3.modelo;

public class PaymentProcessor extends BaseHandler{
	
	@Override
    protected boolean puedeManejar(Pedido pedido) {
        return true;
    }

    @Override
	public String ejecutar(Pedido pedido) {
        double total = pedido.getCantidad() * pedido.getProducto().getPrecio();
        pedido.getProducto().reducirStock(pedido.getCantidad());
       return "Pago procesado por $" + total;
    }

}
