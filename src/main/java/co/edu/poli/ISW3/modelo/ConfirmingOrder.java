package co.edu.poli.ISW3.modelo;

public class ConfirmingOrder extends BaseHandler{
	
	@Override
    protected boolean puedeManejar(Pedido pedido) {
        return true;
    }

    @Override
	public String ejecutar(Pedido pedido) {
        return " Pedido confirmado para " + pedido.getCliente().getNombre();
    }

}
