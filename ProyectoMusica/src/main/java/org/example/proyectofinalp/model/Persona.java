package org.example.proyectofinalp.model;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String contacto;
    protected String correo;
    protected String identificacion;

    public Persona(String nombre, String apellido, String contacto, String correo, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.correo = correo;
        this.identificacion = identificacion;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
