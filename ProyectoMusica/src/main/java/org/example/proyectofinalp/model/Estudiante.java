package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona {

    // 🔹 Atributos
    private String idEstudiante;
    private List<Matricula> matriculas;
    private List<Curso> cursosInscritos;

    // 🔹 Constructor CORREGIDO
    public Estudiante(String nombre, String apellido, String contacto,
                      String correo, String identificacion, String idEstudiante) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idEstudiante = idEstudiante;
        this.matriculas = new ArrayList<>();
        this.cursosInscritos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Estudiante: " + nombre + " " + apellido + "\n" +
                "ID: " + idEstudiante + "\n" +
                "Correo: " + correo + "\n" +
                "Contacto: " + contacto + "\n" +
                "Cursos inscritos: " + cursosInscritos.size();
    }

    // 🔹 Getters y Setters
    public String getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public List<Matricula> getMatriculas() { return matriculas; }
    public List<Curso> getCursosInscritos() { return cursosInscritos; }

    // 🔹 Métodos IMPLEMENTADOS (nombres corregidos a camelCase)
    public void registrarDato() {
        System.out.println("Datos del estudiante " + nombre + " registrados correctamente");
    }

    public void actualizarDato(String nuevoContacto, String nuevoCorreo) {
        this.contacto = nuevoContacto;
        this.correo = nuevoCorreo;
        System.out.println("Datos actualizados para " + nombre);
    }

    public void inscribirse(Curso curso, Matricula matricula) {
        if (curso == null || matricula == null) {
            System.out.println("Error: Curso o matrícula inválidos");
            return;
        }

        if (!cursosInscritos.contains(curso)) {
            cursosInscritos.add(curso);
            matriculas.add(matricula);
            curso.addEstudiante(this);
            System.out.println("Estudiante " + nombre + " inscrito en " + curso.getNombre());
        } else {
            System.out.println("El estudiante ya está inscrito en este curso");
        }
    }

    public void obtenerHorario() {
        System.out.println("=== Horario de " + nombre + " " + apellido + " ===");
        for (Curso curso : cursosInscritos) {
            System.out.println("- " + curso.getNombre());
        }
    }

    public void obtenerAsistencia() {
        System.out.println("=== Asistencia de " + nombre + " ===");
        for (Curso curso : cursosInscritos) {
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Total asistencias: " + curso.getAsistencias().size());
        }
    }

    public void generarReporte() {
        System.out.println("=== Reporte Académico ===");
        System.out.println("Estudiante: " + nombre + " " + apellido);
        System.out.println("ID: " + idEstudiante);
        System.out.println("Cursos inscritos: " + cursosInscritos.size());
        System.out.println("Matrículas activas: " + matriculas.size());
    }

    public void solicitarClase(String tipoCurso) {
        System.out.println("Estudiante " + nombre + " ha solicitado una clase de " + tipoCurso);
    }
}