package org.example.proyectofinalp.model;

public class Estudiante extends Persona {
    private String idEstudiante;

    public Estudiante(String idEstudiante) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idEstudiante = idEstudiante;
    }

    // Get y Set
    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}