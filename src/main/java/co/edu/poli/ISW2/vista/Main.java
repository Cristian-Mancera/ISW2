package co.edu.poli.ISW2.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.poli.ISW2modelo.AdaptadorNequi;
import co.edu.poli.ISW2modelo.AdaptadorPayPal;
import co.edu.poli.ISW2modelo.Departamento;
import co.edu.poli.ISW2modelo.Empleado;

public class Main extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {

		TabPane root = (TabPane) FXMLLoader.load(getClass().getResource("/co/edu/poli/ISW2/vista/Form.fxml"));
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Programa");
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {

		AdaptadorPayPal adaptadorPayPal = new AdaptadorPayPal("paypal@gmail.com");
		AdaptadorNequi adaptadorNequi = new AdaptadorNequi("3001234567", adaptadorPayPal);

		adaptadorPayPal.conectarNequi(adaptadorNequi);

		double montoNequi = 250.0;
		System.out.println(
				"Iniciando pago desde Nequi por $" + montoNequi + " al número: " + adaptadorNequi.getNumeroTelefono());
		adaptadorNequi.realizarPago(montoNequi);
		System.out.println("-> Pago de $" + montoNequi + " adaptado desde Nequi a PayPal " + "al correo: "
				+ adaptadorPayPal.getCorreo() + "\n");

		double montoPayPal = 250.0;
		System.out.println(
				"Iniciando pago desde PayPal por $" + montoPayPal + " al correo: " + adaptadorPayPal.getCorreo());
		adaptadorPayPal.realizarPago(montoPayPal);
		System.out.println("-> Pago de $" + montoPayPal + " adaptado desde PayPal a Nequi" + " al número: "
				+ adaptadorNequi.getNumeroTelefono() + "\n");

		Empleado empleado1 = new Empleado("Juan Pérez", "Desarrollador");
		Empleado empleado2 = new Empleado("Ana Gómez", "Diseñadora");

		Departamento deptoIT = new Departamento("TI");
		deptoIT.agregar(empleado1);
		deptoIT.agregar(empleado2);

		Departamento empresa = new Departamento("Empresa");
		empresa.agregar(deptoIT);
		empresa.agregar(new Empleado("Carlos López", "Gerente"));

		empresa.mostrarInformacion();
		
		launch();
	}

}
