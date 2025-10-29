package org.example.proyectofinalp.model;

import java.util.Date;

public class Matricula {
    private Estudiante estudiante;
    private Curso curso;
    private Date fecha;

    public Matricula(Estudiante estudiante, Curso curso, Date fecha) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "Matricula{" +
                "estudiante=" + estudiante.getNombre() +
                ", curso=" + curso.getNombre() +
                ", fecha=" + fecha +
                '}';
    }
}
