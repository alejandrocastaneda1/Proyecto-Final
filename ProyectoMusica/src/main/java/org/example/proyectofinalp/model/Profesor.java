package org.example.proyectofinalp.model;

public class Profesor extends Persona {

    // 🔹 Atributo
    private String idProfesor;

    // 🔹 Constructor
    public Profesor(String idProfesor) {
        super(idProfesor);
        this.idProfesor = idProfesor;
    }

    // 🔹 Get y Set
    public String getIdProfesor() { return idProfesor; }
    public void setIdProfesor(String idProfesor) { this.idProfesor = idProfesor; }

    // 🔹 Métodos
    public void GestionHorario() {}
    public void CrearClase() {}
    public void EditarClase() {}
    public void RegistroAsistencia() {}
    public void Comentario() {}
}
