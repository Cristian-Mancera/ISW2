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

		launch();
	}

}
