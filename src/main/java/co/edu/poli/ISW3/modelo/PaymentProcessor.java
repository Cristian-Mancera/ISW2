package co.edu.poli.ISW3.modelo;

public class PaymentProcessor extends BaseHandler{
	
	@Override
    protected boolean puedeManejar(Order pedido) {
        return true;
    }

    @Override
    protected void ejecutar(Order pedido) {
        double total = pedido.getCantidad() * pedido.getProducto().getPrecio();
        pedido.getProducto().reducirStock(pedido.getCantidad());
        System.out.println("Pago procesado por $" + total);
    }

}
