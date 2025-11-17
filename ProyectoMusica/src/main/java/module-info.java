module org.example.proyectofinalp {
    requires javafx.controls;
    requires javafx.fxml;

    // Abrir TODOS los paquetes necesarios
    opens org.example.proyectofinalp to javafx.fxml, javafx.graphics;
    opens org.example.proyectofinalp.model to javafx.fxml, javafx.base;
    opens org.example.proyectofinalp.viewController to javafx.fxml;

    // Exportar paquetes
    exports org.example.proyectofinalp;
    exports org.example.proyectofinalp.model;
    exports org.example.proyectofinalp.viewController;
}