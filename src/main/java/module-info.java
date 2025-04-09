module co.edu.poli.ISW {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;

	opens co.edu.poli.ISW.controlador to javafx.fxml;

	exports co.edu.poli.ISW.controlador;

	opens co.edu.poli.ISW.vista to javafx.fxml;

	exports co.edu.poli.ISW.vista;
}
