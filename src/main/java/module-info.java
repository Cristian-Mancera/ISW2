
module co.edu.poli.ISW3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;

	opens co.edu.poli.ISW3.controlador to javafx.fxml;
	opens co.edu.poli.ISW3.vista to javafx.fxml;

	exports co.edu.poli.ISW3.controlador;
	exports co.edu.poli.ISW3.vista;

}