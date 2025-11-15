package org.example.proyectofinalp.model;

public class Profesor extends Persona {
    private String idProfesor;

    public Profesor(String nombre, String apellido, String contacto,
                    String correo, String identificacion, String idProfesor) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
        return "Profesor: " + getNombre() + " " + getApellido() + "\n" +
                "ID: " + idProfesor + "\n" +
                "Correo: " + getCorreo() + "\n" +
                "Contacto: " + getContacto();
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void crearClase() {
        System.out.println("El profesor " + getNombre() + " ha creado una nueva clase");
    }

    public void editarClase() {
        System.out.println("El profesor " + getNombre() + " ha editado una clase");
    }

    public void registrarAsistencia() {
        System.out.println("El profesor " + getNombre() + " ha registrado la asistencia");
    }

    public void comentario() {
        System.out.println("El profesor " + getNombre() + " ha dejado un comentario");
    }
}