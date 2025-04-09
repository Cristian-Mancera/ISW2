package co.edu.poli.ISW.controlador;

import co.edu.poli.ISW.modelo.Facade;
import co.edu.poli.ISW.modelo.FormasPagoActivas;
import co.edu.poli.ISW.modelo.HistorialPedidos;
import co.edu.poli.ISW.modelo.InformacionPersonal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorFormulario {

	@FXML
	private Button bttfacade;

	@FXML
	void facade(ActionEvent event) {

		FormasPagoActivas pago = new FormasPagoActivas();
		HistorialPedidos historial = new HistorialPedidos();
		InformacionPersonal info = new InformacionPersonal();

		Facade clienteFacade = new Facade(pago, historial, info);

		clienteFacade.GestionarCliente("Juan Pérez", "Pedido #123", "Tarjeta de crédito");
	

	}

}
