package org.example.proyectofinalp.model;
import java.util.ArrayList;
import java.util.List;

public class Academia {

    private String nombre;
    private List<Persona> personas;
    private List<Curso> cursos;
    private List<Clase> clases;

    // 🔹 Constructor
    public Academia(String nombre) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    // 🔹 Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // 🔹 Métodos para agregar personas
    public void addProfesor(Profesor profesor) {
        if (!personas.contains(profesor)) {
            personas.add(profesor);
        }
    }

    public void addEstudiante(Estudiante estudiante) {
        if (!personas.contains(estudiante)) {
            personas.add(estudiante);
        }
    }

    public void addAdministrador(Administrador administrador) {
        if (!personas.contains(administrador)) {
            personas.add(administrador);
        }
    }

    public void addClase(Clase clase) {
        if (!clases.contains(clase)) {
            clases.add(clase);
        }
    }

    public void addCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    // 🔹 Getters de listas
    public List<Persona> getpersonas() { return personas; }
    public List<Curso> getCursos() { return cursos; }
    public List<Clase> getClases() { return clases; }

    // 🔹 Métodos de búsqueda
    public Estudiante buscarEstudiante(String id) {
        for (Persona p : personas) {
            if (p instanceof Estudiante) {
                Estudiante est = (Estudiante) p;
                if (est.getIdEstudiante().equals(id)) {
                    return est;
                }
            }
        }
        return null;
    }

    public Profesor buscarProfesor(String id) {
        for (Persona p : personas) {
            if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                if (prof.getIdProfesor().equals(id)) {
                    return prof;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Academia: " + nombre + "\n" +
                "Personas: " + personas.size() + "\n" +
                "Cursos: " + cursos.size() + "\n" +
                "Clases: " + clases.size();
    }
}
