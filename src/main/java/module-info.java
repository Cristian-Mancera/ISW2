module co.edu.poli.ISW3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.ISW3 to javafx.fxml;
    exports co.edu.poli.ISW3;
}
