package org.example.proyectofinalp.model;

public class BloqueHorario implements IGestionable{

    // 🔹 Atributos
    private String diaSemana;
    private boolean disponible;
    private String horaInicio;
    private String horaFin;

    // 🔹 Constructor
    public BloqueHorario(String diaSemana, boolean disponible) {
        this.diaSemana = diaSemana;
        this.disponible = disponible;
    }

    // 🔹 Getters
    public String getDiaSemana() { return diaSemana; }
    public boolean getDisponible() { return disponible; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFin() { return horaFin; }

    // 🔹 Setters
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(String horaFin) { this.horaFin = horaFin; }
}
