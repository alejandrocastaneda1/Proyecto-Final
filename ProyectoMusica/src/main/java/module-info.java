module org.example.proyectofinalp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.proyectofinalp.model to javafx.fxml;
    opens org.example.proyectofinalp.viewController to javafx.fxml;

    exports org.example.proyectofinalp.model;
}
