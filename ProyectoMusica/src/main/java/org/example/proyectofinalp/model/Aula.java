package org.example.proyectofinalp.model;

public class Aula {

    //  Atributos
    private String codigo;
    private int capacidad;

    //  Constructor
    public Aula(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    // Métodos Getters
    public String getCodigo() {
        return codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Métodos Setters
    public void setAula(String codigo) {
        this.codigo = codigo;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public void setNombre(String nuevoNombre) {
    }
    public void setCodigoClase(String nuevoCodigo) {
    }
}
