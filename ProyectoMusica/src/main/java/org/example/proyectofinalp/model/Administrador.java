package org.example.proyectofinalp.model;

public class Administrador extends Persona {

    // 🔹 Atributo
    private String idAdministrador;

    // 🔹 Constructor
    public Administrador(String idAdministrador) {
        super(idAdministrador);
        this.idAdministrador = idAdministrador;
    }

    // 🔹 Get y Set
    public String getIdAdministrador() { return idAdministrador; }
    public void setIdAdministrador(String idAdministrador) { this.idAdministrador = idAdministrador; }

    // 🔹 Métodos
    public void ModificarEstudiante() {}
    public void ModificarProfesor() {}
    public void CrearCurso() {}
    public void verificarConflictoHorario() {}
    public void Reporte() {}
}
