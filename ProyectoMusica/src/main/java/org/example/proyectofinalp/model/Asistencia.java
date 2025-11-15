package org.example.proyectofinalp.model;

import java.time.LocalDate;

public class Asistencia {

    // 🔹 Atributos
    private String idAsistencia;
    private LocalDate fecha;
    private Acudir acudir;

    // 🔹 Constructor CORREGIDO
    public Asistencia(String idAsistencia, Acudir acudir, LocalDate fecha) {
        this.idAsistencia = idAsistencia;
        this.acudir = acudir;
        this.fecha = fecha;
    }

    // 🔹 Getters
    public String getIdAsistencia() { return idAsistencia; }
    public LocalDate getFecha() { return fecha; }
    public Acudir getAcudir() { return acudir; }

    // 🔹 Setters
    public void setIdAsistencia(String idAsistencia) { this.idAsistencia = idAsistencia; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setEstado(Acudir estado) { this.acudir = estado; }

    // 🔹 toString MEJORADO
    @Override
    public String toString() {
        return "Asistencia{" +
                "ID='" + idAsistencia + '\'' +
                ", Fecha=" + fecha +
                ", Estado=" + acudir +
                '}';
    }
}
