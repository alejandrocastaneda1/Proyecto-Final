package org.example.proyectofinalp.model;

import java.util.ArrayList;
import java.util.List;

public class BloqueHorario implements IGestionable {

    private String diaSemana;
    private boolean disponible;
    private String horaInicio;
    private String horaFin;
    private List<Aula> aulas;

    public BloqueHorario(String diaSemana, String horaInicio, String horaFin, boolean disponible) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponible = disponible;
        this.aulas = new ArrayList<>();
    }

    // Getters
    public String getDiaSemana() { return diaSemana; }
    public boolean getDisponible() { return disponible; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }
    public List<Aula> getAulas() { return aulas; }

    // Setters
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }

    // Método para agregar aula
    public void addAula(Aula aula) {
        if (!aulas.contains(aula)) {
            aulas.add(aula);
        }
    }

    // Implementación de IGestionable

    @Override
    public void gestionarRecursos() {
        System.out.println("Gestionando recursos del bloque horario: " + diaSemana +
                " de " + horaInicio + " a " + horaFin);
        System.out.println("Aulas disponibles: " + aulas.size());
    }

    @Override
    public void asignarAula() {
        if (!aulas.isEmpty() && disponible) {
            System.out.println("Asignando aula del bloque: " + diaSemana);
            disponible = false;
        } else {
            System.out.println("No hay aulas disponibles en este bloque horario");
        }
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Ocupado";
        return diaSemana + " " + horaInicio + "-" + horaFin + " [" + estado + "]";
    }
}