module software2_ejercicio1 {
    
    requires java.sql;

    opens co.edu.poli.ejemplo1.vista to javafx.graphics, javafx.fxml; 
    
    exports co.edu.poli.ejemplo1.controlador;  
    
}