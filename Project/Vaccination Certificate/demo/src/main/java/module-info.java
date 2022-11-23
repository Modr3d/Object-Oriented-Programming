module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires javafx.web;
    requires java.logging;
    requires java.desktop;
    requires javafx.swing;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}