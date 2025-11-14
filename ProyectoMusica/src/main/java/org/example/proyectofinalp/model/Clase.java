package org.example.proyectofinalp.model;

public abstract class Clase implements IEvaluable, IAsistible, IProgramable{

    protected String nombre;
    protected String codigo;
    private Matricula matricula;
    private Academia academia;


    public Clase(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.matricula = matricula;
        this.academia = academia;
    }

    public String getNombre() { return nombre;
    }
    public void setNombre(String nombre) { this.nombre = nombre;
    }

    public String getCodigo() { return codigo;
    }
    public void setCodigo(String codigo) { this.codigo = codigo;
    }
    public Matricula getMatricula() { return matricula; }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    public Academia getAcademia() { return academia; }


    @Override
    public void ProgramarClase() { }

    @Override
    public void AsistenciaClase() { }

    @Override
    public void EvaluacionClase() { }

}
