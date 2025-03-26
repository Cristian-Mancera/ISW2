module co.edu.poli.ISW2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;

	opens co.edu.poli.ISW2.controlador to javafx.fxml;
	opens co.edu.poli.ISW2.vista to javafx.fxml;

	exports co.edu.poli.ISW2.controlador;
	exports co.edu.poli.ISW2.vista;
}
