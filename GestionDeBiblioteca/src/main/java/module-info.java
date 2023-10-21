module com.mycompany.gestiondebiblioteca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.naming;
    requires mysql.connector.java;
    requires java.sql;

    opens com.mycompany.gestiondebiblioteca to javafx.fxml;
    exports com.mycompany.gestiondebiblioteca;
    
    opens model to javafx.fxml;
    exports model;
    opens controller to javafx.fxml;
    exports controller;
    
    exports Conexion;
}
