package org.example.proyectofinalp.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuPrincipalviewController {

    @FXML
    private void abrirGestionEstudiantes(ActionEvent event) {
        cambiarVista(event, "CrudEstudiante.fxml");
    }

    @FXML
    private void abrirGestionProfesores(ActionEvent event) {
        cambiarVista(event, "CrudProfesor.fxml");  // ✅ CORREGIDO
    }

    @FXML
    private void abrirGestionCursos(ActionEvent event) {
        cambiarVista(event, "CrudCurso.fxml");
    }

    @FXML
    private void abrirGestionClases(ActionEvent event) {
        cambiarVista(event, "CrudClase.fxml");
    }

    @FXML
    private void abrirRegistroAsistencia(ActionEvent event) {
        cambiarVista(event, "CrudAsistencia.fxml");
    }

    @FXML
    private void abrirReportes(ActionEvent event) {
        cambiarVista(event, "Reporte.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxml) {
        try {
            System.out.println("Intentando cargar: /org/example/proyectofinalp/" + fxml);

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/org/example/proyectofinalp/" + fxml)
            );

            if (loader.getLocation() == null) {
                mostrarAlerta("Error", "No se encontró el archivo: " + fxml +
                        "\nVerifica que esté en: src/main/resources/org/example/proyectofinalp/");
                return;
            }

            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error de Carga",
                    "No se pudo cargar la vista: " + fxml +
                            "\n\nError: " + e.getMessage() +
                            "\n\nVerifica:\n" +
                            "1. El archivo existe en resources/org/example/proyectofinalp/\n" +
                            "2. El nombre del archivo es correcto\n" +
                            "3. El controlador está correctamente referenciado en el FXML");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error Inesperado",
                    "Ocurrió un error al cargar: " + fxml +
                            "\n\nError: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
