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
import org.example.proyectofinalp.model.Profesor;
import org.example.proyectofinalp.model.Academia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfesorviewController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtIdProfesor;
    @FXML private TextField txtContacto;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField txtBuscar;

    @FXML private TableView<Profesor> tablaProfesores;
    @FXML private TableColumn<Profesor, String> colId;
    @FXML private TableColumn<Profesor, String> colNombre;
    @FXML private TableColumn<Profesor, String> colApellido;
    @FXML private TableColumn<Profesor, String> colContacto;
    @FXML private TableColumn<Profesor, String> colCorreo;
    @FXML private TableColumn<Profesor, String> colIdentificacion;

    private ObservableList<Profesor> listaProfesores = FXCollections.observableArrayList();
    private Academia academia = new Academia("Mi Academia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar columnas
        colId.setCellValueFactory(new PropertyValueFactory<>("idProfesor"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));

        tablaProfesores.setItems(listaProfesores);


        tablaProfesores.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        cargarProfesorEnFormulario(newSelection);
                    }
                }
        );
    }

    @FXML
    private void agregarProfesor(ActionEvent event) {
        if (validarCampos()) {
            Profesor profesor = new Profesor(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtContacto.getText(),
                    txtCorreo.getText(),
                    txtIdentificacion.getText(),
                    txtIdProfesor.getText()
            );

            listaProfesores.add(profesor);
            academia.addProfesor(profesor);
            limpiarCampos(null);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Profesor agregado correctamente");
        }
    }

    @FXML
    private void modificarProfesor(ActionEvent event) {
        Profesor seleccionado = tablaProfesores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setApellido(txtApellido.getText());
            seleccionado.setContacto(txtContacto.getText());
            seleccionado.setCorreo(txtCorreo.getText());
            seleccionado.setIdentificacion(txtIdentificacion.getText());

            tablaProfesores.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Profesor modificado correctamente");
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un profesor de la tabla");
        }
    }

    @FXML
    private void eliminarProfesor(ActionEvent event) {
        Profesor seleccionado = tablaProfesores.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Está seguro de eliminar este profesor?");
            confirmacion.setContentText(seleccionado.getNombre() + " " + seleccionado.getApellido());

            if (confirmacion.showAndWait().get() == ButtonType.OK) {
                listaProfesores.remove(seleccionado);
                limpiarCampos(null);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Profesor eliminado");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un profesor");
        }
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        txtNombre.clear();
        txtApellido.clear();
        txtIdProfesor.clear();
        txtContacto.clear();
        txtCorreo.clear();
        txtIdentificacion.clear();
        tablaProfesores.getSelectionModel().clearSelection();
    }

    @FXML
    private void buscarProfesor(ActionEvent event) {
        String busqueda = txtBuscar.getText().toLowerCase();
        if (!busqueda.isEmpty()) {
            ObservableList<Profesor> resultados = FXCollections.observableArrayList();
            for (Profesor p : listaProfesores) {
                if (p.getNombre().toLowerCase().contains(busqueda) ||
                        p.getIdProfesor().toLowerCase().contains(busqueda)) {
                    resultados.add(p);
                }
            }
            tablaProfesores.setItems(resultados);
        } else {
            tablaProfesores.setItems(listaProfesores);
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
    }

    private void cargarProfesorEnFormulario(Profesor profesor) {
        txtNombre.setText(profesor.getNombre());
        txtApellido.setText(profesor.getApellido());
        txtIdProfesor.setText(profesor.getIdProfesor());
        txtContacto.setText(profesor.getContacto());
        txtCorreo.setText(profesor.getCorreo());
        txtIdentificacion.setText(profesor.getIdentificacion());
    }

    private boolean validarCampos() {
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
                txtIdProfesor.getText().isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos vacíos",
                    "Complete los campos obligatorios: Nombre, Apellido e ID");
            return false;
        }
        return true;
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