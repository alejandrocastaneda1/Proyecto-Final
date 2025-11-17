package org.example.proyectofinalp.model;

public abstract class Clase implements IEvaluable, IAsistible, IProgramable {

    protected String nombre;
    protected String codigo;

    // Constructor
    public Clase(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public abstract String tipoClase();

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }


    // Implementación de IAsistible
    @Override
    public void registrarAsistencia() {
        System.out.println("Registrando asistencia en clase: " + nombre);
    }

    @Override
    public void consultarAsistencia() {
        System.out.println("Consultando asistencia de la clase: " + nombre);
    }


    // Implementación de IEvaluable

    @Override
    public void evaluarClase() {
        System.out.println("Evaluando clase: " + nombre);
    }

    @Override
    public void obtenerCalificacion() {
        System.out.println("Obteniendo calificaciones de la clase: " + nombre);
    }


    // Implementación de IProgramable

    @Override
    public void programarClase() {
        System.out.println("Programando clase: " + nombre);
    }

    @Override
    public void modificarHorario() {
        System.out.println("Modificando horario de la clase: " + nombre);
    }
}
