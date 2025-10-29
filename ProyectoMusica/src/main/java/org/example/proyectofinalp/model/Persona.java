package org.example.proyectofinalp.model;

public abstract class Persona {

    // 🔹 Atributos protegidos
    protected String nombre;
    protected String apellido;
    protected String contacto;
    protected String correo;
    protected String identificacion;

    // 🔹 Constructor
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    // 🔹 Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getContacto() { return contacto; }
    public String getCorreo() { return correo; }
    public String getIdentificacion() { return identificacion; }

    // 🔹 Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setContacto(String contacto) { this.contacto = contacto; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
}

