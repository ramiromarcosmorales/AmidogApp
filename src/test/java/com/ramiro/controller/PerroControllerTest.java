package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PerroControllerTest {
    PersistenciaController persistencia;
    PerroController perroController;
    PropietarioController propietarioController;
    Propietario prop;

    @BeforeEach
    void setUp() {
        persistencia = new PersistenciaController();
        perroController = new PerroController(persistencia);
        propietarioController = new PropietarioController(persistencia);
        propietarioController.crearPropietario("Rama");
        prop = propietarioController.buscarPropietarios().getFirst();
    }

    @AfterEach
    void tearDown() {
        perroController.eliminarPerros();

        List<Perro> perros = perroController.obtenerPerros();

        assertEquals(0, perros.size());
    }

    @Test
    void crearPerro() {
        perroController.crearPerro("Matilda", 8, "Es feliz y dormilona", prop);

        List<Perro> perros = perroController.obtenerPerros();

        assertEquals(1, perros.size());
        assertEquals("Matilda", perros.getFirst().getNombre());
    }

    @Test
    void obtenerPerro() {
        perroController.crearPerro("Matilda", 8, "Es feliz y dormilona", prop);
        Perro perrito = perroController.obtenerPerros().getFirst();
        Perro perritoBuscado = perroController.obtenerPerro(perrito.getId());

        assertEquals("Matilda", perritoBuscado.getNombre());
    }

    @Test
    void obtenerPerros() {
        perroController.crearPerro("Matilda", 8, "Es feliz y dormilona", prop);

        List<Perro> perros = perroController.obtenerPerros();

        assertEquals(1, perros.size());
    }

    @Test
    void eliminarPerro() {
        perroController.crearPerro("Matilda", 8, "Es feliz y dormilona", prop);

        Perro perrito = perroController.obtenerPerros().getFirst();
        Perro perritoBuscado = perroController.obtenerPerro(perrito.getId());

        perroController.eliminarPerro(perrito.getId());

        List<Perro> perros = perroController.obtenerPerros();

        assertEquals(0, perros.size());
    }

    @Test
    void editarPerro() {
        perroController.crearPerro("Matilda", 8, "Es feliz y dormilona", prop);

        Perro perrito = perroController.obtenerPerros().getFirst();

        perrito.setNombre("Dulce");

        perroController.editarPerro(perrito);

        List<Perro> perros = perroController.obtenerPerros();

        assertEquals("Dulce", perros.getFirst().getNombre());
    }
}