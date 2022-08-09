module com.arya.javafxio {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.arya.javafxio to javafx.fxml, com.google.gson;
    exports com.arya.javafxio;
}