package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private int duracionSemanas;
    private Academia academia;
    private Instrumento instrumento;
    private List<Asistencia> asistencias;
    private List<Clase> clases;
    private List<Estudiante> estudiantes;
    private List<Asignatura> asigntatura;
    private List<Reporte> reportes;

    public Curso(String nombre, int duracionSemanas) {
        this.nombre = nombre;
        this.duracionSemanas = duracionSemanas;
        this.instrumento = instrumento;
        this.reportes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.asigntatura = new ArrayList<>();
        this.academia = academia;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Instrumento getInstrumento() { return instrumento; }
    public void setInstrumento(Instrumento instrumento) { this.instrumento = instrumento; }

    public int getDuracionSemanas() { return duracionSemanas; }
    public void setDuracionSemanas(int duracionSemanas) { this.duracionSemanas = duracionSemanas; }

    public Academia getAcademia() { return academia; }


    public void addClase(Clase clase) {
        if (!clases.contains(clase)) clases.add(clase);
    }

    public void addEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) estudiantes.add(estudiante);
    }

    public List<Clase> getClases() { return clases; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }
    public List<Asignatura> getAsigntatura() {return asigntatura; }
    public List<Asistencia> getAsistencias() { return asistencias; }
    public void addAsistencia(Asistencia asistencia) {
        if (!asistencias.contains(asistencia)) asistencias.add(asistencia);
    }
    public List<Reporte> getReportes() { return reportes; }
    public void setReportes(List<Reporte> reportes) { this.reportes = reportes; }
    public void addReporte(Reporte reporte) { this.reportes.add(reporte); }



}
