module co.edu.poli.ISW {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.ISW to javafx.fxml;
    exports co.edu.poli.ISW;
}
