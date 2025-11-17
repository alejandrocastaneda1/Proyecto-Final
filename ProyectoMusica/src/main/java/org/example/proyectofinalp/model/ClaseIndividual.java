package org.example.proyectofinalp.model;

public class ClaseIndividual extends Clase {

    private boolean disponible;
    private String estudianteAsignado;

    public ClaseIndividual(String nombre, String codigo, boolean disponible) {
        super(nombre, codigo);
        this.disponible = disponible;
        this.estudianteAsignado = null;
    }


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


    // Sobrescritura de métodos de interfaces

    @Override
    public void registrarAsistencia() {
        if (estudianteAsignado != null) {
            System.out.println("Registrando asistencia individual para: " + estudianteAsignado);
        } else {
            System.out.println("No hay estudiante asignado a esta clase");
        }
    }

    @Override
    public void evaluarClase() {
        if (estudianteAsignado != null) {
            System.out.println("Evaluando clase individual de: " + estudianteAsignado);
        } else {
            System.out.println("No hay estudiante para evaluar");
        }
    }

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "Ocupada por " + estudianteAsignado;
        return tipoClase() + ": " + nombre + " - " + estado;
    }
}

