package org.example.proyectofinalp.model;

public class Estudiante extends Persona {

    // 🔹 Atributo
    private String idEstudiante;

    // 🔹 Constructor
    public Estudiante(String idEstudiante) {
        super(idEstudiante);
        this.idEstudiante = idEstudiante;
    }

    // 🔹 Get y Set
    public String getIdEstudiante() { return idEstudiante; }
    public void setIdEstudiante(String idEstudiante) { this.idEstudiante = idEstudiante; }

    // 🔹 Métodos
    public void RegistroDato() {}
    public void ActualizarDato() {}
    public void Inscribirse() {}
    public void ObtenerHorario() {}
    public void ObtenerAsistencia() {}
    public void GenerarReporte() {}
    public void SolicitudClase() {}
}
