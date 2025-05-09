
module co.edu.poli.ISW3 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

	opens co.edu.poli.ISW3.controlador to javafx.fxml;

	exports co.edu.poli.ISW3.controlador;

	opens co.edu.poli.ISW3.vista to javafx.fxml;

	exports co.edu.poli.ISW3.vista;
}
