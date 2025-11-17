package org.example.proyectofinalp.viewController;

import javafx.beans.property.SimpleStringProperty;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AsistenciaviewController implements Initializable {

    @FXML private ComboBox<Curso> comboCurso;
    @FXML private ComboBox<Clase> comboClase;
    @FXML private DatePicker dateFecha;

    @FXML private TableView<AsistenciaWrapper> tablaAsistencia;
    @FXML private TableColumn<AsistenciaWrapper, String> colIdEstudiante;
    @FXML private TableColumn<AsistenciaWrapper, String> colNombreEstudiante;
    @FXML private TableColumn<AsistenciaWrapper, String> colEstadoAsistencia;
    @FXML private TableColumn<AsistenciaWrapper, Void> colAcciones;

    private ObservableList<AsistenciaWrapper> listaAsistencias = FXCollections.observableArrayList();
    private Academia academia = new Academia("Mi Academia");


    public static class AsistenciaWrapper {
        private Estudiante estudiante;
        private Acudir estado;

        public AsistenciaWrapper(Estudiante estudiante) {
            this.estudiante = estudiante;
            this.estado = Acudir.NOASISTIO; // Por defecto no asistió
        }

        public Estudiante getEstudiante() { return estudiante; }
        public String getIdEstudiante() { return estudiante.getIdEstudiante(); }
        public String getNombreCompleto() {
            return estudiante.getNombre() + " " + estudiante.getApellido();
        }
        public Acudir getEstado() { return estado; }
        public void setEstado(Acudir estado) { this.estado = estado; }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colIdEstudiante.setCellValueFactory(new PropertyValueFactory<>("idEstudiante"));
        colNombreEstudiante.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colEstadoAsistencia.setCellValueFactory(cellData ->
                new SimpleStringProperty(getEstadoTexto(cellData.getValue().getEstado()))
        );


        colAcciones.setCellFactory(param -> new TableCell<>() {
            private final ComboBox<Acudir> comboEstado = new ComboBox<>();

            {
                comboEstado.setItems(FXCollections.observableArrayList(Acudir.values()));
                comboEstado.setOnAction(event -> {
                    AsistenciaWrapper wrapper = getTableView().getItems().get(getIndex());
                    if (comboEstado.getValue() != null) {
                        wrapper.setEstado(comboEstado.getValue());
                        getTableView().refresh();
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    AsistenciaWrapper wrapper = getTableView().getItems().get(getIndex());
                    comboEstado.setValue(wrapper.getEstado());
                    setGraphic(comboEstado);
                }
            }
        });

        tablaAsistencia.setItems(listaAsistencias);


        dateFecha.setValue(LocalDate.now());


        cargarDatosPrueba();
    }

    private void cargarDatosPrueba() {
        // Crear algunos cursos y estudiantes de prueba
        Curso curso1 = new Curso("Guitarra Básica", 12);
        Curso curso2 = new Curso("Piano Avanzado", 16);

        Estudiante est1 = new Estudiante("Juan", "Pérez", "123456", "juan@mail.com", "ID001", "EST001");
        Estudiante est2 = new Estudiante("María", "García", "789012", "maria@mail.com", "ID002", "EST002");

        curso1.addEstudiante(est1);
        curso1.addEstudiante(est2);

        academia.addCurso(curso1);
        academia.addCurso(curso2);

        comboCurso.setItems(FXCollections.observableArrayList(academia.getCursos()));

        comboCurso.setOnAction(e -> {
            Curso seleccionado = comboCurso.getValue();
            if (seleccionado != null) {
                comboClase.setItems(FXCollections.observableArrayList(seleccionado.getClases()));
            }
        });
    }

    @FXML
    private void cargarEstudiantes(ActionEvent event) {
        Curso curso = comboCurso.getValue();
        if (curso == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un curso");
            return;
        }

        listaAsistencias.clear();
        for (Estudiante estudiante : curso.getEstudiantes()) {
            listaAsistencias.add(new AsistenciaWrapper(estudiante));
        }

        if (listaAsistencias.isEmpty()) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Información",
                    "Este curso no tiene estudiantes inscritos");
        }
    }

    @FXML
    private void guardarAsistencia(ActionEvent event) {
        if (listaAsistencias.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "No hay registros para guardar");
            return;
        }

        LocalDate fecha = dateFecha.getValue();
        if (fecha == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione una fecha");
            return;
        }

        int contador = 0;
        for (AsistenciaWrapper wrapper : listaAsistencias) {
            String idAsistencia = "ASIST_" + wrapper.getIdEstudiante() + "_" + fecha.toString();
            Asistencia asistencia = new Asistencia(idAsistencia, wrapper.getEstado(), fecha);

            contador++;
        }

        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito",
                "Se guardaron " + contador + " registros de asistencia");
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
    }

    private String getEstadoTexto(Acudir estado) {
        switch (estado) {
            case ASISTIO: return "✅ Asistió";
            case NOASISTIO: return "❌ No Asistió";
            case EXCUSAMEDICA: return "🏥 Excusa Médica";
            case EXCUSADOMESTICA: return "🏠 Excusa Doméstica";
            default: return "-";
        }
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
