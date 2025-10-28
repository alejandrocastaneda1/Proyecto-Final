package org.example.proyectofinalp.model;

public class Profesor extends Persona {
    private String idProfesor;

    public Profesor(String idProfesor) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idProfesor = idProfesor;
    }


    // Get y Set
    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }
}
