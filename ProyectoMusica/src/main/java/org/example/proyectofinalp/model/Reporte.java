package org.example.proyectofinalp.model;

public class Reporte {

    // 🔹 Atributos
    private String valoracion;
    private String comentarioFormativo;
    private String progresoInstrumento;
    private String progresoNivel;
    private String asistencia;

    // 🔹 Constructor
    public Reporte(String valoracion) {
        this.valoracion = valoracion;
        this.comentarioFormativo = "";
        this.progresoInstrumento = "";
        this.progresoNivel = "";
        this.asistencia = "";
    }

    // 🔹 Getters
    public String getAsistencia() { return asistencia; }
    public String getValoracion() { return valoracion; }
    public String getComentarioFormativo() { return comentarioFormativo; }
    public String getProgresoInstrumento() { return progresoInstrumento; }
    public String getProgresoNivel() { return progresoNivel; }

    // 🔹 Setters
    public void setAsistencia(String asistencia) { this.asistencia = asistencia; }
    public void setValoracion(String valoracion) { this.valoracion = valoracion; }
    public void setComentarioFormativo(String comentarioFormativo) { this.comentarioFormativo = comentarioFormativo; }
    public void setProgresoInstrumento(String progresoInstrumento) { this.progresoInstrumento = progresoInstrumento; }
    public void setProgresoNivel(String progresoNivel) { this.progresoNivel = progresoNivel; }

    // 🔹 Métodos adicionales
    public String GenerarReporte() {
        return "Reporte generado: " + valoracion + " - Nivel: " + progresoNivel + " - Instrumento: " + progresoInstrumento;
    }

    public String ActualizarReporte() {
        return "El reporte ha sido actualizado correctamente.";
    }

    public String ModificarReporte() {
        return "Se modificó el reporte: " + comentarioFormativo;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "valoracion='" + valoracion + '\'' +
                ", comentarioFormativo='" + comentarioFormativo + '\'' +
                ", progresoInstrumento='" + progresoInstrumento + '\'' +
                ", progresoNivel='" + progresoNivel + '\'' +
                ", asistencia='" + asistencia + '\'' +
                '}';
    }
}
