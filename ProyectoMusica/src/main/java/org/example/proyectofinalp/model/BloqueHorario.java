package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class BloqueHorario implements IGestionable {

    // 🔹 Atributos
    private String diaSemana;
    private boolean disponible;
    private String horaInicio;
    private String horaFin;
    private List<Aula> aulas;
    private Academia academia;

    // 🔹 Constructor
    public BloqueHorario(String diaSemana, boolean disponible) {
        this.diaSemana = diaSemana;
        this.disponible = disponible;
        this.aulas = new ArrayList<>();
        this.academia = academia;
    }

    // 🔹 Getters
    public String getDiaSemana() {
        return diaSemana;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public List<Aula> getAulas() {
        return aulas;
    }
    public Academia getAcademia() {
        return academia;
    }

    // 🔹 Setters
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    // 🔹 Implementación del método de la interfaz IGestionable
    @Override
    public void GestionarClase() {
        System.out.println("Gestionando clase en el bloque horario del día " + diaSemana);
    }

}