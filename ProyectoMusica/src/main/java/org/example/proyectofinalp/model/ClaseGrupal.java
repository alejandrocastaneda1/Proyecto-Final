package org.example.proyectofinalp.model;

public class ClaseGrupal extends Clase {

    private int cupo;
    private int inscritos;

    public ClaseGrupal(String nombre, String codigo, int cupo) {
        super(nombre, codigo);
        this.cupo = cupo;
        this.inscritos = 0;
    }

    // 🔹 Implementación del método abstracto
    @Override
    public String tipoClase() {
        return "Clase Grupal";
    }

    public int getCupo() { return cupo; }
    public void setCupo(int cupo) { this.cupo = cupo; }

    public int getInscritos() { return inscritos; }

    public boolean hayEspacio() {
        return inscritos < cupo;
    }

    public void inscribirEstudiante() {
        if (hayEspacio()) {
            inscritos++;
            System.out.println("Estudiante inscrito. Cupo: " + inscritos + "/" + cupo);
        } else {
            System.out.println("No hay cupo disponible");
        }
    }

    @Override
    public String toString() {
        return tipoClase() + ": " + nombre + " (Cupo: " + inscritos + "/" + cupo + ")";
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
