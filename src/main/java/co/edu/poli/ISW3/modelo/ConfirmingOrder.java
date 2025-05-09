package co.edu.poli.ISW3.modelo;

public class ConfirmingOrder extends BaseHandler{
	
	@Override
    protected boolean puedeManejar(Order pedido) {
        return true;
    }

    @Override
    protected void ejecutar(Order pedido) {
        System.out.println(" Pedido confirmado para " + pedido.getCliente().getNombre());
    }

}
