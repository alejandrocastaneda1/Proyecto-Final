package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class Academia {

    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Academia(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void addProfesor(Profesor profesor) {
        if (!profesores.contains(profesor)) profesores.add(profesor);
    }

    public void addCurso(Curso curso) {
        if (!cursos.contains(curso)) cursos.add(curso);
    }

    public List<Profesor> getProfesores() { return profesores; }
    public List<Curso> getCursos() { return cursos; }

    @Override
    public String toString() {
        return "Academia{" +
                "nombre='" + nombre + '\'' +
                ", profesores=" + profesores.size() +
                ", cursos=" + cursos.size() +
                '}';
    }
}
