package org.example.proyectofinalp.model;

public class ClaseIndividual extends Clase {

    private boolean disponible;
    private String estudianteAsignado;

    public ClaseIndividual(String nombre, String codigo, boolean disponible) {
        super(nombre, codigo);
        this.disponible = disponible;
        this.estudianteAsignado = null;
    }

    // 🔹 Implementación del método abstracto
    @Override
    public String tipoClase() {
        return "Clase Individual";
    }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public String getEstudianteAsignado() { return estudianteAsignado; }

    public void asignarEstudiante(String nombreEstudiante) {
        if (disponible) {
            this.estudianteAsignado = nombreEstudiante;
            this.disponible = false;
            System.out.println("Clase asignada a: " + nombreEstudiante);
        } else {
            System.out.println("Clase no disponible");
        }
    }

    public void liberarClase() {
        this.estudianteAsignado = null;
        this.disponible = true;
        System.out.println("Clase liberada y disponible");
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Ocupada por " + estudianteAsignado;
        return tipoClase() + ": " + nombre + " - " + estado;
    }

    @Override
    public void AsistenciaClase() {

    }

    @Override
    public void EvaluacionClase() {

    }

    @Override
    public void ProgramarClase() {

    }
}
