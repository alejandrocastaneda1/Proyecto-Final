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

    // 🔹 Constructor CORREGIDO (sin asignaciones nulas)
    public BloqueHorario(String diaSemana, String horaInicio, String horaFin, boolean disponible) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
        this.aulas = new ArrayList<>();
    }

    // 🔹 Getters
    public String getDiaSemana() { return diaSemana; }
    public boolean getDisponible() { return disponible; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }
    public List<Aula> getAulas() { return aulas; }

    // 🔹 Setters
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    // 🔹 Métodos de gestión
    public void addAula(Aula aula) {
        if (!aulas.contains(aula)) {
            aulas.add(aula);
        }
    }

    @Override
    public void gestionarClase() {

    }

    // 🔹 Implementación del método de la interfaz IGestionable
    @Override
    public void GestionarClase() {
        System.out.println("Gestionando clase en el bloque horario del día " + diaSemana +
                " de " + horaInicio + " a " + horaFin);
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Ocupado";
        return diaSemana + " " + horaInicio + "-" + horaFin + " [" + estado + "]";
    }

}