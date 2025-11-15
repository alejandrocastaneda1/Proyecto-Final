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
import org.example.proyectofinalp.model.Estudiante;
import org.example.proyectofinalp.model.Academia;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EstudianteviewController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtIdEstudiante;
    @FXML private TextField txtContacto;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField txtBuscar;

    @FXML private TableView<Estudiante> tablaEstudiantes;
    @FXML private TableColumn<Estudiante, String> colId;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colApellido;
    @FXML private TableColumn<Estudiante, String> colContacto;
    @FXML private TableColumn<Estudiante, String> colCorreo;
    @FXML private TableColumn<Estudiante, String> colIdentificacion;

    private ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();
    private Academia academia = new Academia("Mi Academia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar columnas
        colId.setCellValueFactory(new PropertyValueFactory<>("idEstudiante"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colIdentificacion.setCellValueFactory(new PropertyValueFactory<>("identificacion"));

        tablaEstudiantes.setItems(listaEstudiantes);

        // Listener para selección de tabla
        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        cargarEstudianteEnFormulario(newSelection);
                    }
                }
        );
    }

    @FXML
    private void agregarEstudiante(ActionEvent event) {
        if (validarCampos()) {
            Estudiante estudiante = new Estudiante(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtContacto.getText(),
                    txtCorreo.getText(),
                    txtIdentificacion.getText(),
                    txtIdEstudiante.getText()
            );

            listaEstudiantes.add(estudiante);
            academia.addEstudiante(estudiante);
            limpiarCampos(null);
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Estudiante agregado correctamente");
        }
    }

    @FXML
    private void modificarEstudiante(ActionEvent event) {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setApellido(txtApellido.getText());
            seleccionado.setContacto(txtContacto.getText());
            seleccionado.setCorreo(txtCorreo.getText());
            seleccionado.setIdentificacion(txtIdentificacion.getText());

            tablaEstudiantes.refresh();
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Estudiante modificado correctamente");
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un estudiante de la tabla");
        }
    }

    @FXML
    private void eliminarEstudiante(ActionEvent event) {
        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmar eliminación");
            confirmacion.setHeaderText("¿Está seguro de eliminar este estudiante?");
            confirmacion.setContentText(seleccionado.getNombre() + " " + seleccionado.getApellido());

            if (confirmacion.showAndWait().get() == ButtonType.OK) {
                listaEstudiantes.remove(seleccionado);
                limpiarCampos(null);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Estudiante eliminado");
            }
        } else {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un estudiante");
        }
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        txtNombre.clear();
        txtApellido.clear();
        txtIdEstudiante.clear();
        txtContacto.clear();
        txtCorreo.clear();
        txtIdentificacion.clear();
        tablaEstudiantes.getSelectionModel().clearSelection();
    }

    @FXML
    private void buscarEstudiante(ActionEvent event) {
        String busqueda = txtBuscar.getText().toLowerCase();
        if (!busqueda.isEmpty()) {
            ObservableList<Estudiante> resultados = FXCollections.observableArrayList();
            for (Estudiante e : listaEstudiantes) {
                if (e.getNombre().toLowerCase().contains(busqueda) ||
                        e.getIdEstudiante().toLowerCase().contains(busqueda)) {
                    resultados.add(e);
                }
            }
            tablaEstudiantes.setItems(resultados);
        } else {
            tablaEstudiantes.setItems(listaEstudiantes);
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
    }

    private void cargarEstudianteEnFormulario(Estudiante estudiante) {
        txtNombre.setText(estudiante.getNombre());
        txtApellido.setText(estudiante.getApellido());
        txtIdEstudiante.setText(estudiante.getIdEstudiante());
        txtContacto.setText(estudiante.getContacto());
        txtCorreo.setText(estudiante.getCorreo());
        txtIdentificacion.setText(estudiante.getIdentificacion());
    }

    private boolean validarCampos() {
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() ||
                txtIdEstudiante.getText().isEmpty()) {
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