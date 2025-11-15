package org.example.proyectofinalp.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuPrincipalviewController {

    @FXML
    private void abrirGestionEstudiantes(ActionEvent event) {
        cambiarVista(event, "GestionEstudiantes.fxml");
    }

    @FXML
    private void abrirGestionProfesores(ActionEvent event) {
        cambiarVista(event, "GestionProfesores.fxml");
    }

    @FXML
    private void abrirGestionCursos(ActionEvent event) {
        cambiarVista(event, "GestionCursos.fxml");
    }

    @FXML
    private void abrirGestionClases(ActionEvent event) {
        cambiarVista(event, "GestionClases.fxml");
    }

    @FXML
    private void abrirRegistroAsistencia(ActionEvent event) {
        cambiarVista(event, "RegistroAsistencia.fxml");
    }

    @FXML
    private void abrirReportes(ActionEvent event) {
        cambiarVista(event, "Reportes.fxml");
    }

    private void cambiarVista(ActionEvent event, String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/proyectofinalp/" + fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo cargar la vista: " + fxml);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}