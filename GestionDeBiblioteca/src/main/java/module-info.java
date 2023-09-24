module com.mycompany.gestiondebiblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.gestiondebiblioteca to javafx.fxml;
    exports com.mycompany.gestiondebiblioteca;
    
    opens model to javafx.fxml;
    exports model;
    
}
