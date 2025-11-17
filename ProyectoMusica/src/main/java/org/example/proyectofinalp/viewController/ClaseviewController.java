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

public class ClaseviewController implements Initializable {

    @FXML private ComboBox<String> comboTipoClase;
    @FXML private TextField txtNombreClase;
    @FXML private TextField txtCodigoClase;
    @FXML private TextField txtCapacidad;
    @FXML private Label lblCapacidad;

    @FXML private TableView<Clase> tablaClases;
    @FXML private TableColumn<Clase, String> colCodigoClase;
    @FXML private TableColumn<Clase, String> colNombreClase;
    @FXML private TableColumn<Clase, String> colTipo;
    @FXML private TableColumn<Clase, String> colCupo;

    private ObservableList<Clase> listaClases = FXCollections.observableArrayList();
    private Academia academia = new Academia("Mi Academia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboTipoClase.setItems(FXCollections.observableArrayList("Clase Grupal", "Clase Individual"));


        comboTipoClase.setOnAction(e -> {
            String tipo = comboTipoClase.getValue();
            if (tipo != null) {
                if (tipo.equals("Clase Grupal")) {
                    lblCapacidad.setText("Cupo:");
                    txtCapacidad.setPromptText("Ejemplo: 20");
                    txtCapacidad.setDisable(false);
                } else {
                    lblCapacidad.setText("Disponibilidad:");
                    txtCapacidad.setPromptText("true/false");
                    txtCapacidad.setDisable(false);
                }
            }
        });


        colCodigoClase.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombreClase.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipo.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().tipoClase())
        );
        colCupo.setCellValueFactory(cellData -> {
            Clase clase = cellData.getValue();
            if (clase instanceof ClaseGrupal) {
                ClaseGrupal cg = (ClaseGrupal) clase;
                return new javafx.beans.property.SimpleStringProperty(
                        cg.getInscritos() + "/" + cg.getCupo()
                );
            } else if (clase instanceof ClaseIndividual) {
                ClaseIndividual ci = (ClaseIndividual) clase;
                return new javafx.beans.property.SimpleStringProperty(
                        ci.isDisponible() ? "Disponible" : "Ocupada"
                );
            }
            return new javafx.beans.property.SimpleStringProperty("-");
        });

        tablaClases.setItems(listaClases);


        tablaClases.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        cargarClaseEnFormulario(newSelection);
                    }
                }
        );
    }

    @FXML
    private void crearClase(ActionEvent event) {
        if (validarCampos()) {
            String tipo = comboTipoClase.getValue();
            Clase nuevaClase = null;

            if (tipo.equals("Clase Grupal")) {
                try {
                    int cupo = Integer.parseInt(txtCapacidad.getText());
                    nuevaClase = new ClaseGrupal(txtNombreClase.getText(), txtCodigoClase.getText(), cupo);
                } catch (NumberFormatException e) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "El cupo debe ser un número");
                    return;
                }
            } else {
                boolean disponible = txtCapacidad.getText().toLowerCase().equals("true");
                nuevaClase = new ClaseIndividual(txtNombreClase.getText(), txtCodigoClase.getText(), disponible);
            }

            listaClases.add(nuevaClase);
            academia.addClase(nuevaClase);
            limpiarCampos();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Clase creada correctamente");
        }
    }

    @FXML
    private void editarClase(ActionEvent event) {
        Clase seleccionada = tablaClases.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            seleccionada.setNombre(txtNombreClase.getText());
            seleccionada.setCodigo(txtCodigoClase.getText());

            if (seleccionada instanceof ClaseGrupal) {
                try {
                    int cupo = Integer.parseInt(txtCapacidad.getText());
                    ((ClaseGrupal) seleccionada).setCupo(cupo);
                } catch (NumberFormatException e) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "El cupo debe ser un número");
                    return;
                }
            } else if (seleccionada instanceof ClaseIndividual) {
                boolean disponible = txtCapacidad.getText().toLowerCase().equals("true");
                ((ClaseIndividual) seleccionada).setDisponible(disponible);
            }

            tablaClases.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Clase actualizada");
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione una clase");
        }
    }

    @FXML
    private void eliminarClase(ActionEvent event) {
        Clase seleccionada = tablaClases.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Eliminar clase?");
            confirmacion.setContentText(seleccionada.getNombre());

            if (confirmacion.showAndWait().get() == ButtonType.OK) {
                listaClases.remove(seleccionada);
                limpiarCampos();
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Clase eliminada");
            }
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
    }

    private void cargarClaseEnFormulario(Clase clase) {
        txtNombreClase.setText(clase.getNombre());
        txtCodigoClase.setText(clase.getCodigo());

        if (clase instanceof ClaseGrupal) {
            comboTipoClase.setValue("Clase Grupal");
            txtCapacidad.setText(String.valueOf(((ClaseGrupal) clase).getCupo()));
        } else if (clase instanceof ClaseIndividual) {
            comboTipoClase.setValue("Clase Individual");
            txtCapacidad.setText(String.valueOf(((ClaseIndividual) clase).isDisponible()));
        }
    }

    private boolean validarCampos() {
        if (txtNombreClase.getText().isEmpty() || txtCodigoClase.getText().isEmpty() ||
                comboTipoClase.getValue() == null || txtCapacidad.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos", "Complete todos los campos");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        txtNombreClase.clear();
        txtCodigoClase.clear();
        txtCapacidad.clear();
        comboTipoClase.getSelectionModel().clearSelection();
        tablaClases.getSelectionModel().clearSelection();
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