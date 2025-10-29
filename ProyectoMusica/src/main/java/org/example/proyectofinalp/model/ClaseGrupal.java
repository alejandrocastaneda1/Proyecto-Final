package org.example.proyectofinalp.model;

public class ClaseGrupal extends Clase {

    private int cupo;

    public ClaseGrupal(String nombre, String codigo, int cupo) {
        super(nombre, codigo);
        this.cupo = cupo;
    }

    public int getCupo() { return cupo; }
    public void setCupo(int cupo) { this.cupo = cupo; }

    @Override
    public String tipoClase() {
        return "ClaseGrupal";
    }
}
