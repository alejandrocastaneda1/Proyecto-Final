module org.example.proyectofinalp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.proyectofinalp to javafx.fxml;
    opens org.example.proyectofinalp.model to javafx.fxml;
    opens org.example.proyectofinalp.viewcontroller to javafx.fxml;

    exports org.example.proyectofinalp;
    exports org.example.Proyectofinalp.model;
    exports org.example.Proyectofinalp.viewcontroller;
}
