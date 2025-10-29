package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private String instrumento;
    private int duracionSemanas;
    private List<Clase> clases;
    private List<Estudiante> estudiantes;

    public Curso(String nombre, String instrumento, int duracionSemanas) {
        this.nombre = nombre;
        this.instrumento = instrumento;
        this.duracionSemanas = duracionSemanas;
        this.clases = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getInstrumento() { return instrumento; }
    public void setInstrumento(String instrumento) { this.instrumento = instrumento; }

    public int getDuracionSemanas() { return duracionSemanas; }
    public void setDuracionSemanas(int duracionSemanas) { this.duracionSemanas = duracionSemanas; }

    public void addClase(Clase clase) {
        if (!clases.contains(clase)) clases.add(clase);
    }

    public void addEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) estudiantes.add(estudiante);
    }

    public List<Clase> getClases() { return clases; }
    public List<Estudiante> getEstudiantes() { return estudiantes; }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", instrumento='" + instrumento + '\'' +
                ", duracionSemanas=" + duracionSemanas +
                ", clases=" + clases.size() +
                ", estudiantes=" + estudiantes.size() +
                '}';
    }
}
