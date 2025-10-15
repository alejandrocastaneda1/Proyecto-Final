module org.example.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.proyectofinal to javafx.fxml;
    exports org.example.proyectofinal;
}