package org.example.proyectofinalp.model;

public class Administrador extends Persona {
    private String idAdministrador;

    public Administrador(String idAdministrador) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idAdministrador = idAdministrador;
    }

    // Get y Set
    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}
