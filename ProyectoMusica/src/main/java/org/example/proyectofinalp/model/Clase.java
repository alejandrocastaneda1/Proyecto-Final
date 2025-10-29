package org.example.proyectofinalp.model;

public abstract class Clase {

    protected String nombre;
    protected String codigo;

    public Clase(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    // Método abstracto que las subclases deben implementar
    public abstract String tipoClase();

    @Override
    public String toString() {
        return tipoClase() + "{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
