package org.example.proyectofinalp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcademiaTest {

    @Test
    public void testNombreInicial() {
        Academia academia = new Academia("Mi Academia");
        assertEquals("Mi Academia", academia.getNombre());
    }

    @Test
    public void testSetNombre() {
        Academia academia = new Academia("A");
        academia.setNombre("Nueva Academia");
        assertEquals("Nueva Academia", academia.getNombre());
    }

    @Test
    public void testAgregarProfesor() {
        Academia academia = new Academia("Academia");
        Profesor profesor = new Profesor("Juan", "Perez", "123456789",
                "juan@mail.com", "ID123", "PROF001");

        academia.addProfesor(profesor);

        assertTrue(academia.getpersonas().contains(profesor));
        assertEquals(1, academia.getpersonas().size());
    }

    @Test
    public void testAgregarEstudiante() {
        Academia academia = new Academia("Academia");
        Estudiante estudiante = new Estudiante("Ana", "Garcia", "987654321",
                "ana@mail.com", "ID456", "EST001");

        academia.addEstudiante(estudiante);

        assertEquals(1, academia.getpersonas().size());
        assertTrue(academia.getpersonas().contains(estudiante));
    }

    @Test
    public void testAgregarAdministradorNoDuplica() {
        Academia academia = new Academia("Academia");
        Administrador admin = new Administrador("Pedro", "Lopez", "555555555",
                "pedro@mail.com", "ID789", "ADM001");

        academia.addAdministrador(admin);
        academia.addAdministrador(admin); // repetir

        assertEquals(1, academia.getpersonas().size());
    }

    @Test
    public void testAgregarCurso() {
        Academia academia = new Academia("Academia");
        Curso curso = new Curso("Guitarra Básica", 12);

        academia.addCurso(curso);

        assertNotNull(academia.getCursos());
        assertEquals(1, academia.getCursos().size());
        assertTrue(academia.getCursos().contains(curso));
    }

    @Test
    public void testAgregarClase() {
        Academia academia = new Academia("Academia");
        ClaseGrupal clase = new ClaseGrupal("Teoría Musical", "CL001", 20);

        academia.addClase(clase);

        assertEquals(1, academia.getClases().size());
        assertTrue(academia.getClases().contains(clase));
    }

    @Test
    public void testListasInicialesVacias() {
        Academia academia = new Academia("Academia");

        assertTrue(academia.getClases().isEmpty());
        assertTrue(academia.getpersonas().isEmpty());
        assertTrue(academia.getCursos().isEmpty());
    }

    @Test
    public void testAgregarCursoNoDuplicado() {
        Academia academia = new Academia("Academia");
        Curso curso = new Curso("Piano Intermedio", 16);

        academia.addCurso(curso);
        academia.addCurso(curso); // intentar duplicar

        assertEquals(1, academia.getCursos().size());
    }

    @Test
    public void testBuscarEstudiante() {
        Academia academia = new Academia("Academia");
        Estudiante estudiante = new Estudiante("Maria", "Rodriguez", "111222333",
                "maria@mail.com", "ID999", "EST002");

        academia.addEstudiante(estudiante);

        Estudiante encontrado = academia.buscarEstudiante("EST002");
        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNombre());
    }

    @Test
    public void testBuscarEstudianteNoExiste() {
        Academia academia = new Academia("Academia");

        Estudiante encontrado = academia.buscarEstudiante("EST999");
        assertNull(encontrado);
    }

    @Test
    public void testBuscarProfesor() {
        Academia academia = new Academia("Academia");
        Profesor profesor = new Profesor("Carlos", "Sanchez", "444555666",
                "carlos@mail.com", "ID777", "PROF002");

        academia.addProfesor(profesor);

        Profesor encontrado = academia.buscarProfesor("PROF002");
        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNombre());
    }

    @Test
    public void testBuscarProfesorNoExiste() {
        Academia academia = new Academia("Academia");

        Profesor encontrado = academia.buscarProfesor("PROF999");
        assertNull(encontrado);
    }

    @Test
    public void testAgregarClaseIndividual() {
        Academia academia = new Academia("Academia");
        ClaseIndividual claseIndiv = new ClaseIndividual("Clase Piano Privada", "CL002", true);

        academia.addClase(claseIndiv);

        assertEquals(1, academia.getClases().size());
        assertTrue(academia.getClases().contains(claseIndiv));
    }

    @Test
    public void testAgregarVariasPersonas() {
        Academia academia = new Academia("Academia");

        Estudiante est1 = new Estudiante("Laura", "Gomez", "111111111",
                "laura@mail.com", "ID001", "EST001");
        Estudiante est2 = new Estudiante("Diego", "Martinez", "222222222",
                "diego@mail.com", "ID002", "EST002");
        Profesor prof = new Profesor("Ana", "Torres", "333333333",
                "ana@mail.com", "ID003", "PROF001");

        academia.addEstudiante(est1);
        academia.addEstudiante(est2);
        academia.addProfesor(prof);

        assertEquals(3, academia.getpersonas().size());
    }

    @Test
    public void testToString() {
        Academia academia = new Academia("Academia de Música");
        Curso curso = new Curso("Violín", 10);
        Estudiante estudiante = new Estudiante("Sofia", "Ruiz", "555555555",
                "sofia@mail.com", "ID100", "EST100");
        ClaseGrupal clase = new ClaseGrupal("Solfeo", "CL100", 15);

        academia.addCurso(curso);
        academia.addEstudiante(estudiante);
        academia.addClase(clase);

        String resultado = academia.toString();

        assertTrue(resultado.contains("Academia de Música"));
        assertTrue(resultado.contains("Personas: 1"));
        assertTrue(resultado.contains("Cursos: 1"));
        assertTrue(resultado.contains("Clases: 1"));
    }
}