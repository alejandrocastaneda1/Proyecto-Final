package org.example.proyectofinalp.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.proyectofinalp.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CursoviewController implements Initializable {

    @FXML private TextField txtNombreCurso;
    @FXML private TextField txtDuracion;
    @FXML private ComboBox<Instrumento> comboInstrumento;
    @FXML private ComboBox<Nivel> comboNivel;

    @FXML private TableView<Curso> tablaCursos;
    @FXML private TableColumn<Curso, String> colNombreCurso;
    @FXML private TableColumn<Curso, Integer> colDuracion;
    @FXML private TableColumn<Curso, String> colInstrumento;
    @FXML private TableColumn<Curso, Integer> colEstudiantes;

    private ObservableList<Curso> listaCursos = FXCollections.observableArrayList();
    private Academia academia = new Academia("Mi Academia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Cargar ComboBox de Instrumentos
        comboInstrumento.setItems(FXCollections.observableArrayList(Instrumento.values()));
        comboNivel.setItems(FXCollections.observableArrayList(Nivel.values()));

        // Configurar columnas
        colNombreCurso.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionSemanas"));
        colInstrumento.setCellValueFactory(cellData -> {
            Instrumento inst = cellData.getValue().getInstrumento();
            return new javafx.beans.property.SimpleStringProperty(
                    inst != null ? inst.toString() : "Sin asignar"
            );
        });
        colEstudiantes.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getEstudiantes().size()
                ).asObject()
        );

        tablaCursos.setItems(listaCursos);

        // Listener para selección
        tablaCursos.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        cargarCursoEnFormulario(newSelection);
                    }
                }
        );
    }

    @FXML
    private void crearCurso(ActionEvent event) {
        if (validarCampos()) {
            try {
                int duracion = Integer.parseInt(txtDuracion.getText());
                Curso curso = new Curso(txtNombreCurso.getText(), duracion);

                if (comboInstrumento.getValue() != null) {
                    curso.setInstrumento(comboInstrumento.getValue());
                }

                listaCursos.add(curso);
                academia.addCurso(curso);
                limpiarCampos();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Curso creado correctamente");
            } catch (NumberFormatException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "La duración debe ser un número");
            }
        }
    }

    @FXML
    private void editarCurso(ActionEvent event) {
        Curso seleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombreCurso.getText());
            seleccionado.setDuracionSemanas(Integer.parseInt(txtDuracion.getText()));
            seleccionado.setInstrumento(comboInstrumento.getValue());

            tablaCursos.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Curso actualizado");
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un curso");
        }
    }

    @FXML
    private void eliminarCurso(ActionEvent event) {
        Curso seleccionado = tablaCursos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Eliminar curso?");
            confirmacion.setContentText(seleccionado.getNombre());

            if (confirmacion.showAndWait().get() == ButtonType.OK) {
                listaCursos.remove(seleccionado);
                limpiarCampos();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Curso eliminado");
            }
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
    }

    private void cargarCursoEnFormulario(Curso curso) {
        txtNombreCurso.setText(curso.getNombre());
        txtDuracion.setText(String.valueOf(curso.getDuracionSemanas()));
        comboInstrumento.setValue(curso.getInstrumento());
    }

    private boolean validarCampos() {
        if (txtNombreCurso.getText().isEmpty() || txtDuracion.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Complete todos los campos");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txtNombreCurso.clear();
        txtDuracion.clear();
        comboInstrumento.getSelectionModel().clearSelection();
        comboNivel.getSelectionModel().clearSelection();
    }

    private void cambiarVista(ActionEvent event, String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/example/proyectofinalp/" + fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}