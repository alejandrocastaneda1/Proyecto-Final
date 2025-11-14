package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class Academia {

    private String nombre;
    private List<Persona> personas;
    private List<Curso> cursos;
    private List<Clase> clases;

    public Academia(String nombre) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void addProfesor(Profesor profesor) {
        if (!personas.contains(profesor))personas.add(profesor);
    }
    public void addEstudiante(Estudiante estudiante) {
        if (!personas.contains(estudiante))personas.add(estudiante);
    }
    public void addAdminstrador(Administrador administrador) {
        if (!personas.contains(administrador))personas.add(administrador);
    }
    public void addClase(Clase clase) {
        if (!clases.contains(clase))clases.add(clase);
    }
    public void addCurso(Curso curso) {
        if (!cursos.contains(curso)) cursos.add(curso);
    }

    public List<Persona> getpersonas() { return personas; }
    public List<Curso> getCursos() { return cursos; }
    public List<Clase> getClases() { return clases; }



}
