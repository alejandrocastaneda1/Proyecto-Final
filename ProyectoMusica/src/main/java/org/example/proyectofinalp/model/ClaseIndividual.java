package org.example.proyectofinalp.model;

public class ClaseIndividual extends Clase {

    private boolean disponible;

    public ClaseIndividual(String nombre, String codigo, boolean disponible) {
        super(nombre, codigo);
        this.disponible = disponible;
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String tipoClase() {
        return "ClaseIndividual";
    }
}
