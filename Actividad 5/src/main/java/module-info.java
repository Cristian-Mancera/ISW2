module co.edu.poli.software2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.base;

    opens co.edu.poli.ejemplo1.controlador to javafx.fxml;
    opens co.edu.poli.ejemplo1.vista to javafx.fxml;
    exports co.edu.poli.ejemplo1.controlador;
    exports co.edu.poli.ejemplo1.vista;
}
