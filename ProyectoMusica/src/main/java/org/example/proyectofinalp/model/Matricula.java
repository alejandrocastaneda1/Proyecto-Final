package org.example.proyectofinalp.model;

public class Matricula {

    // 🔹 Atributos
    private String idMatricula;
    private double costo;
    private Estado estado;
    private Nivel nivel;

    // 🔹 Constructor
    public Matricula(String idMatricula, double costo, Estado estado, Nivel nivel) {
        this.idMatricula = idMatricula;
        this.costo = costo;
        this.estado = estado;
        this.nivel = nivel;
    }

    // 🔹 Getters
    public String getIdMatricula() {
        return idMatricula;
    }

    public double getCosto() {
        return costo;
    }

    public Estado getEstado() {
        return estado;
    }

    public Nivel getNivel() {
        return nivel;
    }

    // 🔹 Setters
    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
