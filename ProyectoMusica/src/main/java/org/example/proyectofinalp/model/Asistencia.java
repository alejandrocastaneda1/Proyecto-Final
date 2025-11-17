package org.example.proyectofinalp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Asistencia {

    //  Atributos
    private String idAsistencia;
    private LocalDate fecha;
    private Acudir acudir;
    private String TheAula;
    private String TheCurso;

    //  Constructor CORREGIDO
    public Asistencia(String idAsistencia, Acudir acudir, LocalDate fecha) {
        this.idAsistencia = idAsistencia;
        this.acudir = acudir;
        this.fecha = fecha;
    }
    private List<Asistencia> asistencias = new ArrayList<>();

    // Getters
    public String getIdAsistencia() { return idAsistencia; }
    public LocalDate getFecha() { return fecha; }
    public Acudir getAcudir() { return acudir; }
    public String getTheAula() { return TheAula; }
    public String getTheCurso() { return TheCurso; }
    public List<Asistencia> getAsistencias() { return asistencias; }

    //  Setters
    public void setIdAsistencia(String idAsistencia) { this.idAsistencia = idAsistencia; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setEstado(Acudir estado) { this.acudir = estado; }

    //  toString MEJORADO
    @Override
    public String toString() {
        return "Asistencia{" +
                "ID='" + idAsistencia + '\'' +
                ", Fecha=" + fecha +
                ", Estado=" + acudir +
                '}';
    }
    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
        System.out.println("Asistencia registrada: " + asistencia);
    }
    public Asistencia buscarPorId(String idAsistencia) {
        for (Asistencia a : asistencias) {
            if (a.getIdAsistencia().equals(idAsistencia)) {
                return a;
            }
        }
        return null;
    }
    public boolean actualizarAsistencia(String idAsistencia, boolean nuevoEstado, LocalDate nuevaFecha) {
        Asistencia a = buscarPorId(idAsistencia);
        if (a != null) {
            a.setAsistio(nuevoEstado);
            a.setFecha(nuevaFecha);
            System.out.println("Asistencia actualizada: " + a);
            return true;
        }
        return false;
    }

    private void setAsistio(boolean nuevoEstado) {
    }

    public boolean eliminarAsistencia(String idAsistencia) {
        Asistencia a = buscarPorId(idAsistencia);
        if (a != null) {
            asistencias.remove(a);
            System.out.println("Asistencia eliminada: " + a);
            return true;
        }
        return false;
    }
    public void listarAsistencias() {
        System.out.println("Listado de asistencias:");
        for (Asistencia a : asistencias) {
            System.out.println(a);
        }
    }
}
