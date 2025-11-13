package org.example.proyectofinalp.model;

public class Asignatura {

    // 🔹 Atributos
    private String codigo;
    private String nombre;
    private int creditos;
    private String area;

    // 🔹 Constructor
    public Asignatura(String codigo, String nombre, int creditos, String area) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.area = area;
    }

    // 🔹 Métodos Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void registrarAsignatura() {
        System.out.println("Asignatura registrada: " + nombre);
    }

    public void editarAsignatura(String nuevoNombre, int nuevosCreditos, String nuevaArea) {
        this.nombre = nuevoNombre;
        this.creditos = nuevosCreditos;
        this.area = nuevaArea;
        System.out.println("Asignatura editada correctamente.");
    }
}
