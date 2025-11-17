package org.example.proyectofinalp.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.proyectofinalp.model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ReporteviewController implements Initializable {

    @FXML private ComboBox<String> comboTipoReporte;
    @FXML private Label lblTotalEstudiantes;
    @FXML private Label lblTotalProfesores;
    @FXML private Label lblTotalCursos;
    @FXML private Label lblTotalClases;
    @FXML private TextArea areaReporte;

    private Academia academia = new Academia("Mi Academia");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar tipos de reportes
        comboTipoReporte.getItems().addAll(
                "Reporte General de la Academia",
                "Lista de Estudiantes",
                "Lista de Profesores",
                "Cursos y Matriculados",
                "Asistencia por Curso",
                "Estadísticas Generales"
        );

        cargarDatosPrueba();
        actualizarEstadisticas();
    }

    private void cargarDatosPrueba() {

        Estudiante est1 = new Estudiante("Juan", "Pérez", "123", "juan@mail.com", "ID1", "EST001");
        Estudiante est2 = new Estudiante("María", "García", "456", "maria@mail.com", "ID2", "EST002");
        Estudiante est3 = new Estudiante("Carlos", "López", "789", "carlos@mail.com", "ID3", "EST003");

        academia.addEstudiante(est1);
        academia.addEstudiante(est2);
        academia.addEstudiante(est3);


        Profesor prof1 = new Profesor("Ana", "Martínez", "111", "ana@mail.com", "ID4", "PROF001");
        Profesor prof2 = new Profesor("Luis", "Rodríguez", "222", "luis@mail.com", "ID5", "PROF002");

        academia.addProfesor(prof1);
        academia.addProfesor(prof2);


        Curso curso1 = new Curso("Guitarra Básica", 12);
        curso1.setInstrumento(Instrumento.GUITARRA);
        curso1.addEstudiante(est1);
        curso1.addEstudiante(est2);

        Curso curso2 = new Curso("Piano Avanzado", 16);
        curso2.setInstrumento(Instrumento.PIANO);
        curso2.addEstudiante(est3);

        academia.addCurso(curso1);
        academia.addCurso(curso2);


        ClaseGrupal clase1 = new ClaseGrupal("Teoría Musical", "CL001", 20);
        ClaseIndividual clase2 = new ClaseIndividual("Clase Privada Piano", "CL002", true);

        academia.addClase(clase1);
        academia.addClase(clase2);
    }

    @FXML
    private void generarReporte(ActionEvent event) {
        String tipoReporte = comboTipoReporte.getValue();
        if (tipoReporte == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Advertencia", "Seleccione un tipo de reporte");
            return;
        }

        StringBuilder reporte = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);

        reporte.append("═══════════════════════════════════════════════════════════\n");
        reporte.append("           🎵 ACADEMIA MUSICAL - REPORTE 🎵\n");
        reporte.append("═══════════════════════════════════════════════════════════\n");
        reporte.append("Fecha y hora: ").append(fechaHora).append("\n");
        reporte.append("Tipo: ").append(tipoReporte).append("\n");
        reporte.append("═══════════════════════════════════════════════════════════\n\n");

        switch (tipoReporte) {
            case "Reporte General de la Academia":
                reporte.append(generarReporteGeneral());
                break;
            case "Lista de Estudiantes":
                reporte.append(generarListaEstudiantes());
                break;
            case "Lista de Profesores":
                reporte.append(generarListaProfesores());
                break;
            case "Cursos y Matriculados":
                reporte.append(generarReporteCursos());
                break;
            case "Asistencia por Curso":
                reporte.append(generarReporteAsistencia());
                break;
            case "Estadísticas Generales":
                reporte.append(generarEstadisticas());
                break;
        }

        reporte.append("\n═══════════════════════════════════════════════════════════\n");
        reporte.append("                    FIN DEL REPORTE\n");
        reporte.append("═══════════════════════════════════════════════════════════\n");

        areaReporte.setText(reporte.toString());
    }

    private String generarReporteGeneral() {
        StringBuilder sb = new StringBuilder();
        sb.append("📊 INFORMACIÓN GENERAL DE LA ACADEMIA\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");
        sb.append("Academia: ").append(academia.getNombre()).append("\n\n");

        sb.append("RESUMEN:\n");
        sb.append("  • Total de Estudiantes: ").append(academia.getpersonas().stream()
                .filter(p -> p instanceof Estudiante).count()).append("\n");
        sb.append("  • Total de Profesores: ").append(academia.getpersonas().stream()
                .filter(p -> p instanceof Profesor).count()).append("\n");
        sb.append("  • Total de Cursos: ").append(academia.getCursos().size()).append("\n");
        sb.append("  • Total de Clases: ").append(academia.getClases().size()).append("\n\n");

        sb.append("CURSOS ACTIVOS:\n");
        for (Curso curso : academia.getCursos()) {
            sb.append("  ▪ ").append(curso.getNombre())
                    .append(" (").append(curso.getEstudiantes().size()).append(" estudiantes)\n");
        }

        return sb.toString();
    }

    private String generarListaEstudiantes() {
        StringBuilder sb = new StringBuilder();
        sb.append("👨‍🎓 LISTA COMPLETA DE ESTUDIANTES\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");

        int contador = 1;
        for (Persona p : academia.getpersonas()) {
            if (p instanceof Estudiante) {
                Estudiante est = (Estudiante) p;
                sb.append(contador++).append(". ").append(est.getNombre())
                        .append(" ").append(est.getApellido()).append("\n");
                sb.append("   ID: ").append(est.getIdEstudiante()).append("\n");
                sb.append("   Correo: ").append(est.getCorreo()).append("\n");
                sb.append("   Contacto: ").append(est.getContacto()).append("\n");
                sb.append("   Cursos inscritos: ").append(est.getCursosInscritos().size()).append("\n\n");
            }
        }

        if (contador == 1) {
            sb.append("No hay estudiantes registrados.\n");
        }

        return sb.toString();
    }

    private String generarListaProfesores() {
        StringBuilder sb = new StringBuilder();
        sb.append("👨‍🏫 LISTA COMPLETA DE PROFESORES\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");

        int contador = 1;
        for (Persona p : academia.getpersonas()) {
            if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                sb.append(contador++).append(". ").append(prof.getNombre())
                        .append(" ").append(prof.getApellido()).append("\n");
                sb.append("   ID: ").append(prof.getIdProfesor()).append("\n");
                sb.append("   Correo: ").append(prof.getCorreo()).append("\n");
                sb.append("   Contacto: ").append(prof.getContacto()).append("\n\n");
            }
        }

        if (contador == 1) {
            sb.append("No hay profesores registrados.\n");
        }

        return sb.toString();
    }

    private String generarReporteCursos() {
        StringBuilder sb = new StringBuilder();
        sb.append("📚 CURSOS Y ESTUDIANTES MATRICULADOS\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");

        for (Curso curso : academia.getCursos()) {
            sb.append("🎓 ").append(curso.getNombre()).append("\n");
            sb.append("   Duración: ").append(curso.getDuracionSemanas()).append(" semanas\n");
            sb.append("   Instrumento: ").append(curso.getInstrumento() != null ?
                    curso.getInstrumento() : "No asignado").append("\n");
            sb.append("   Estudiantes matriculados: ").append(curso.getEstudiantes().size()).append("\n");

            if (!curso.getEstudiantes().isEmpty()) {
                sb.append("   Lista de estudiantes:\n");
                for (Estudiante est : curso.getEstudiantes()) {
                    sb.append("     • ").append(est.getNombre())
                            .append(" ").append(est.getApellido())
                            .append(" (").append(est.getIdEstudiante()).append(")\n");
                }
            }
            sb.append("\n");
        }

        if (academia.getCursos().isEmpty()) {
            sb.append("No hay cursos registrados.\n");
        }

        return sb.toString();
    }

    private String generarReporteAsistencia() {
        StringBuilder sb = new StringBuilder();
        sb.append("✅ REPORTE DE ASISTENCIA POR CURSO\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");

        for (Curso curso : academia.getCursos()) {
            sb.append("📖 Curso: ").append(curso.getNombre()).append("\n");
            sb.append("   Total de registros de asistencia: ")
                    .append(curso.getAsistencias().size()).append("\n");

            if (!curso.getAsistencias().isEmpty()) {
                sb.append("   Detalles:\n");
                for (Asistencia asist : curso.getAsistencias()) {
                    sb.append("     • ").append(asist.getFecha())
                            .append(" - Estado: ").append(asist.getAcudir()).append("\n");
                }
            } else {
                sb.append("   No hay registros de asistencia para este curso.\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private String generarEstadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("📈 ESTADÍSTICAS GENERALES\n");
        sb.append("───────────────────────────────────────────────────────────\n\n");

        long totalEstudiantes = academia.getpersonas().stream()
                .filter(p -> p instanceof Estudiante).count();
        long totalProfesores = academia.getpersonas().stream()
                .filter(p -> p instanceof Profesor).count();
        int totalCursos = academia.getCursos().size();
        int totalClases = academia.getClases().size();

        sb.append("PERSONAL:\n");
        sb.append("  👨‍🎓 Estudiantes activos: ").append(totalEstudiantes).append("\n");
        sb.append("  👨‍🏫 Profesores activos: ").append(totalProfesores).append("\n");
        sb.append("  👥 Total personas: ").append(totalEstudiantes + totalProfesores).append("\n\n");

        sb.append("OFERTA ACADÉMICA:\n");
        sb.append("  📚 Cursos disponibles: ").append(totalCursos).append("\n");
        sb.append("  🎓 Clases programadas: ").append(totalClases).append("\n\n");

        sb.append("DISTRIBUCIÓN POR INSTRUMENTO:\n");
        for (Instrumento inst : Instrumento.values()) {
            long count = academia.getCursos().stream()
                    .filter(c -> c.getInstrumento() == inst).count();
            if (count > 0) {
                sb.append("  ♪ ").append(inst).append(": ").append(count).append(" curso(s)\n");
            }
        }

        sb.append("\nTIPO DE CLASES:\n");
        long clasesGrupales = academia.getClases().stream()
                .filter(c -> c instanceof ClaseGrupal).count();
        long clasesIndividuales = academia.getClases().stream()
                .filter(c -> c instanceof ClaseIndividual).count();
        sb.append("  👥 Clases Grupales: ").append(clasesGrupales).append("\n");
        sb.append("  👤 Clases Individuales: ").append(clasesIndividuales).append("\n");

        return sb.toString();
    }

    private void actualizarEstadisticas() {
        long estudiantes = academia.getpersonas().stream()
                .filter(p -> p instanceof Estudiante).count();
        long profesores = academia.getpersonas().stream()
                .filter(p -> p instanceof Profesor).count();

        lblTotalEstudiantes.setText(String.valueOf(estudiantes));
        lblTotalProfesores.setText(String.valueOf(profesores));
        lblTotalCursos.setText(String.valueOf(academia.getCursos().size()));
        lblTotalClases.setText(String.valueOf(academia.getClases().size()));
    }

    @FXML
    private void exportarPDF(ActionEvent event) {
        mostrarAlerta(Alert.AlertType.INFORMATION, "Función en desarrollo",
                "La exportación a PDF estará disponible próximamente.\n" +
                        "Por ahora puede copiar el texto del reporte.");
    }

    @FXML
    private void exportarExcel(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Reporte");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de texto", "*.txt")
        );
        fileChooser.setInitialFileName("reporte_academia.txt");

        Stage stage = (Stage) areaReporte.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(areaReporte.getText());
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito",
                        "Reporte exportado correctamente a:\n" + file.getAbsolutePath());
            } catch (IOException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error",
                        "No se pudo guardar el archivo: " + e.getMessage());
            }
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        cambiarVista(event, "MenuPrincipal.fxml");
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
