package org.example.proyectofinalp.model;
import java.util.ArrayList;
import java.util.List;

public class Academia {

    private String nombre;
    private String nit;
    private List<Persona> personas;
    private List<Curso> cursos;
    private List<Clase> clases;
    private List <Aula> aulas;
    private List <BloqueHorario>  bloqueHorarios;
    private String buscarPorCodigo;

    //  Constructor
    public Academia(String nombre, String nit) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.clases = new ArrayList<>();
        this.aulas = new ArrayList<>();
        this.bloqueHorarios = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    //  Métodos para agregar personas
    public void addProfesor(Profesor profesor) {
        if (!personas.contains(profesor)) {
            personas.add(profesor);
        }
    }

    public void addEstudiante(Estudiante estudiante) {
        if (!personas.contains(estudiante)) {
            personas.add(estudiante);
        }
    }

    public void addAdministrador(Administrador administrador) {
        if (!personas.contains(administrador)) {
            personas.add(administrador);
        }
    }

    public void addClase(Clase clase) {
        if (!clases.contains(clase)) {
            clases.add(clase);
        }
    }

    public void addCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    //  Getters de listas
    public List<Persona> getpersonas() {
        return personas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Clase> getClases() {
        return clases;
    }

    //  Métodos de búsqueda
    public Estudiante buscarEstudiante(String id) {
        for (Persona p : personas) {
            if (p instanceof Estudiante) {
                Estudiante est = (Estudiante) p;
                if (est.getIdEstudiante().equals(id)) {
                    return est;
                }
            }
        }
        return null;
    }

    public Profesor buscarProfesor(String id) {
        for (Persona p : personas) {
            if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                if (prof.getIdProfesor().equals(id)) {
                    return prof;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Academia: " + nombre + "\n" +
                "Personas: " + personas.size() + "\n" +
                "Cursos: " + cursos.size() + "\n" +
                "Clases: " + clases.size();
    }
//CRUD PERSONA
    public void agregarPersona(Persona persona) {
        if (!personas.contains(persona)) {
            personas.add(persona);
            System.out.println("Persona agregada: " + persona);
        } else {
            System.out.println("Ya existe esta persona.");
        }
    }

    public Persona buscarPorIdentificacion(String identificacion) {
        for (Persona p : personas) {
            if (p.getIdentificacion().equals(identificacion)) {
                return p;
            }
        }
        return null;

    }

    public boolean actualizarPersona(String identificacion, String nuevoNombre, String nuevoApellido, String nuevoContacto, String nuevoCorreo, String nuevaIdentificacion) {
        Persona p = buscarPorIdentificacion(identificacion);
        if (p != null) {
            p.nombre = nuevoNombre;
            p.setApellido(nuevoApellido);
            p.setContacto(nuevoContacto);
            p.setCorreo(nuevoCorreo);
            p.setIdentificacion(nuevaIdentificacion);
            System.out.println("Persona actualizada: " + p);
            return true;
        }
        return false;
    }

    public boolean eliminarPersona(String identificacion) {
        Persona p = buscarPorIdentificacion(identificacion);
        if (p != null) {
            personas.remove(p);
            System.out.println("Persona eliminada: " + p);
            return true;
        }
        return false;
    }

    public void listarPersonas() {
        System.out.println("Listado de personas:");
        for (Persona p : personas) {
            System.out.println(p);
        }
    }
//CRUD CURSO
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        System.out.println("Curso agregado: " + curso);
    }

    public boolean actualizarCurso(String nombre, String nuevoNivel, int nuevaCapacidad, String nuevoTipo) {
        Curso c = buscarPorNombre(nombre);
        if (c != null) {
            c.setNivel(nuevoNivel);
            c.setCapacidad(nuevaCapacidad);
            c.setTipo(nuevoTipo);
            System.out.println("Curso actualizado: " + c);
            return true;
        }
        return false;
    }

    private Curso buscarPorNombre(String nombre) {
        for (Curso c : cursos) {
        }
        return null;
    }

    public boolean eliminarCurso(String nombre) {
        Curso c = buscarPorNombre(nombre);
        if (c != null) {
            cursos.remove(c);
            System.out.println("Curso eliminado: " + c);
            return true;
        }
        return false;
    }
    public void listarCursos() {
        System.out.println("Listado de cursos:");
        for (Curso c : cursos) {
            System.out.println(c);
        }

    }
    //CRUD CLASE
    public void agregarClase(Clase clase) {
        clases.add(clase);
        System.out.println("Clase agregada: " + clase);
    }

    public boolean actualizarClase(String codigo, String nuevoNombre, String nuevoCodigo) {
        Aula c = buscarPorCodigo(codigo);
        if (c != null) {
            c.setNombre(nuevoNombre);
            c.setCodigoClase(nuevoCodigo);
            System.out.println("Clase actualizada: " + c);
            return true;
        }
        return false;
    }
    public boolean eliminarClase(String codigo) {
        Aula c = buscarPorCodigo(codigo);
        if (c != null) {
            clases.remove(c);
            System.out.println("Clase eliminada: " + c);
            return true;
        }
        return false;
    }
    public void listarClases() {
        System.out.println("Listado de clases:");
        for (Clase c : clases) {
            System.out.println(c);
        }
    }
//CRUD AULA
    public void agregarAula(Aula aula) {
        aulas.add(aula);
        System.out.println("Aula agregada: " + aula);
    }
    public Aula buscarPorCodigo(String codigo) {
        this.buscarPorCodigo = codigo;
        for (Aula a : aulas) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }
    public boolean actualizarAula(String codigo, String nuevoCodigo, int nuevaCapacidad) {
        Aula a = buscarPorCodigo(codigo);
        if (a != null) {
            a.setAula(nuevoCodigo);
            a.setCapacidad(nuevaCapacidad);
            System.out.println("Aula actualizada: " + a);
            return true;
        }
        return false;
    }
    public boolean eliminarAula(String codigo) {
        Aula a = buscarPorCodigo(codigo);
        if (a != null) {
            aulas.remove(a);
            System.out.println("Aula eliminada: " + a);
            return true;
        }
        return false;
    }
    public void listarAulas() {
        System.out.println("Listado de aulas:");
        for (Aula a : aulas) {
            System.out.println(a);
        }
    }
//CRUD BLOQUEHORARIO
    public void agregarBloque(BloqueHorario bloque) {
        bloqueHorarios.add(bloque);
        System.out.println("Bloque agregado: " +bloque);
    }
    public BloqueHorario buscarPorDiaYHora(String dia, String horaInicio) {
        for (BloqueHorario b : bloqueHorarios) {
            if (b.getDiaSemana().equalsIgnoreCase(dia) && b.getHoraInicio().equals(horaInicio)) {
                return b;
            }
        }
        return null;
    }
    public boolean actualizarBloque(String dia, String horaInicio, boolean nuevaDisponibilidad, String nuevaHoraInicio, String nuevaHoraFin) {
        BloqueHorario b = buscarPorDiaYHora(dia, horaInicio);
        if (b != null) {
            b.setDisponible(nuevaDisponibilidad);
            b.setHoraInicio(nuevaHoraInicio);
            b.setHoraFin(nuevaHoraFin);
            System.out.println("Bloque actualizado: " + b);
            return true;
        }
        return false;
    }
    public boolean eliminarBloque(String dia, String horaInicio) {
        BloqueHorario b = buscarPorDiaYHora(dia, horaInicio);
        if (b != null) {
            bloqueHorarios.remove(b);
            System.out.println("Bloque eliminado: " + b);
            return true;
        }
        return false;
    }
    public void listarBloques() {
        System.out.println("Listado de bloques horarios:");
        for (BloqueHorario b : bloqueHorarios) {
            System.out.println(b);
        }
    }


}
