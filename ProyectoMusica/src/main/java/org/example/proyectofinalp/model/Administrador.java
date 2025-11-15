package org.example.proyectofinalp.model;

public class Administrador extends Persona {

    // 🔹 Atributo
    private String idAdministrador;

    // 🔹 Constructor CORREGIDO
    public Administrador(String nombre, String apellido, String contacto,
                         String correo, String identificacion, String idAdministrador) {
        super(nombre, apellido, contacto, correo, identificacion);
        this.idAdministrador = idAdministrador;
    }

    // 🔹 Implementación del método abstracto toString()
    @Override
    public String toString() {
        return "Administrador: " + nombre + " " + apellido + "\n" +
                "ID: " + idAdministrador + "\n" +
                "Correo: " + correo + "\n" +
                "Contacto: " + contacto;
    }

    // 🔹 Getters y Setters
    public String getIdAdministrador() { return idAdministrador; }
    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    // 🔹 Métodos IMPLEMENTADOS (nombres corregidos a camelCase)
    public void modificarEstudiante(Estudiante estudiante, String nuevoContacto, String nuevoCorreo) {
        if (estudiante != null) {
            estudiante.actualizarDato(nuevoContacto, nuevoCorreo);
            System.out.println("Administrador " + nombre + " ha modificado al estudiante " +
                    estudiante.getNombre());
        }
    }

    public void modificarProfesor(Profesor profesor, String nuevoContacto) {
        if (profesor != null) {
            profesor.setContacto(nuevoContacto);
            System.out.println("Administrador " + nombre + " ha modificado al profesor " +
                    profesor.getNombre());
        }
    }

    public void crearCurso(String nombreCurso, int duracion, Instrumento instrumento, Academia academia) {
        Curso nuevoCurso = new Curso(nombreCurso, duracion);
        nuevoCurso.setInstrumento(instrumento);
        academia.addCurso(nuevoCurso);
        System.out.println("Administrador " + nombre + " ha creado el curso: " + nombreCurso);
    }

    public boolean verificarConflictoHorario(Curso curso1, Curso curso2) {
        System.out.println("Verificando conflictos de horario entre " +
                curso1.getNombre() + " y " + curso2.getNombre());
        // Aquí iría la lógica real de verificación
        return false; // Por ahora retorna sin conflicto
    }

    public void reporte(Academia academia) {
        System.out.println("=== REPORTE GENERAL ===");
        System.out.println("Academia: " + academia.getNombre());
        System.out.println("Total personas: " + academia.getpersonas().size());
        System.out.println("Total cursos: " + academia.getCursos().size());
        System.out.println("Total clases: " + academia.getClases().size());
        System.out.println("Generado por: " + nombre);
    }
}