package org.example.proyectofinalp.model;

import org.junit.jupiter.api.Test;
import java.util.List;
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
        Profesor profesor = new Profesor("Juan", "123");

        academia.addProfesor(profesor);

        assertTrue(academia.getpersonas().contains(profesor));
    }

    @Test
    public void testAgregarEstudiante() {
        Academia academia = new Academia("Academia");
        Estudiante estudiante = new Estudiante("Ana", "456");

        academia.addEstudiante(estudiante);

        assertEquals(1, academia.getpersonas().size());
        assertTrue(academia.getpersonas().contains(estudiante));
    }

    @Test
    public void testAgregarAdministradorNoDuplica() {
        Academia academia = new Academia("Academia");
        Administrador admin = new Administrador("Pedro", "789");

        academia.addAdminstrador(admin);
        academia.addAdminstrador(admin); // repetir

        assertEquals(1, academia.getpersonas().size());
    }

    @Test
    public void testAgregarCurso() {
        Academia academia = new Academia("Academia");
        Curso curso = new Curso("C001", "Matemáticas");

        academia.addCurso(curso);

        assertNotNull(academia.getCursos());
        assertEquals(1, academia.getCursos().size());
        assertTrue(academia.getCursos().contains(curso));
    }

    @Test
    public void testAgregarClase() {
        Academia academia = new Academia("Academia");
        Clase clase = new ClaseTeorica("Clase 1", "CL001");

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
        Curso curso = new Curso("C01", "Historia");

        academia.addCurso(curso);
        academia.addCurso(curso); // intentar duplicar

        assertEquals(1, academia.getCursos().size());
    }

    @Test
    public void testAgregarNullLanzaError() {
        Academia academia = new Academia("Academia");

        assertThrows(NullPointerException.class, () -> {
            academia.addCurso(null);
        });
    }
}
