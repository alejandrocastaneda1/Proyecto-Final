package org.example.proyectofinalp.model;

public abstract class Clase implements IEvaluable, IAsistible, IProgramable {

    protected String nombre;
    protected String codigo;

    // 🔹 Constructor CORREGIDO
    public Clase(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // 🔹 MÉTODO ABSTRACTO que debe ser implementado
    public abstract String tipoClase();

    // 🔹 Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    // 🔹 Implementación de interfaces
    @Override
    public void programarClase() {
        System.out.println("Programando clase: " + nombre);
    }

    @Override
    public void asistenciaClase() {
        System.out.println("Registrando asistencia en clase: " + nombre);
    }

    @Override
    public void evaluacionClase() {
        System.out.println("Evaluando clase: " + nombre);
    }
}
