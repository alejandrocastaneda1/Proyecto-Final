package org.example.proyectofinalp.model;

public class Prerequisito {
    private Curso cursoRequerido;

    public Prerequisito(Curso cursoRequerido) {
        this.cursoRequerido = cursoRequerido;
    }

    public Curso getCursoRequerido() { return cursoRequerido; }
    public void setCursoRequerido(Curso cursoRequerido) { this.cursoRequerido = cursoRequerido; }

}
