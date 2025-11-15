module org.example.proyectofinalp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.proyectofinalp to javafx.fxml;
    opens org.example.proyectofinalp.model to javafx.fxml;
    opens org.example.proyectofinalp.viewcontroller to javafx.fxml;

    // EXPORTS correctos
    exports org.example.proyectofinalp to javafx.graphics;
    exports org.example.proyectofinalp.model;
    exports org.example.proyectofinalp.viewController;
}
