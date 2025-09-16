package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PropietarioControllerTest {
    PersistenciaController persistencia;
    PropietarioController propietarioController;

    @BeforeEach
    void setUp() {
        persistencia = new PersistenciaController();
        persistencia.borrarTurnos();
        persistencia.borrarPerros();
        persistencia.borrarPropietarios();
        propietarioController = new PropietarioController(persistencia);
    }

    @AfterEach
    void tearDown() {
        propietarioController.borrarPropietarios();

        List<Propietario> props = propietarioController.buscarPropietarios();

        assertEquals(0, props.size());
    }

    @Test
    void crearPropietario() {
        propietarioController.crearPropietario("Ramiro");

        List<Propietario> propietarios = propietarioController.buscarPropietarios();

        assertEquals(1, propietarios.size());

        assertEquals("Ramiro", propietarios.getFirst().getNombre());
    }


    @Test
    void buscarPropietario() {
        propietarioController.crearPropietario("Ramiro");

        Propietario prop = propietarioController.buscarPropietarios().getFirst();
        Propietario propBuscado = propietarioController.buscarPropietario(prop.getId());

        assertEquals("Ramiro", propBuscado.getNombre(), "Error al buscar propietario");
    }

    @Test
    void buscarPropietarios() {
        propietarioController.crearPropietario("Ramiro");

        List<Propietario> props = propietarioController.buscarPropietarios();

        assertEquals(1, props.size());
    }

    @Test
    void editarPropietario() {
        propietarioController.crearPropietario("Ramiro");

        Propietario prop = propietarioController.buscarPropietarios().getFirst();

        prop.setNombre("Bautista");

        propietarioController.editarPropietario(prop);

        assertTrue(propietarioController.buscarPropietarios().stream()
                .anyMatch(p -> p.getNombre().equals("Bautista")), "Error al editar propietario");
    }

    @Test
    void eliminarPropietario() {
        propietarioController.crearPropietario("Ramiro");

        List<Propietario> propietarios = propietarioController.buscarPropietarios();
        propietarioController.eliminarPropietario(propietarios.getFirst().getId());
        propietarios = propietarioController.buscarPropietarios();

        assertTrue(propietarios.isEmpty());
    }

    @Test
    void agregarPerro() {
        PerroController perroController = new PerroController(persistencia);
        propietarioController.crearPropietario("Ramiro");
        Propietario prop = propietarioController.buscarPropietarios().getFirst();
        perroController.crearPerro("Matilda", 8, "juguetona y dormilona", prop);

        prop = propietarioController.buscarPropietarioConPerros(prop.getId());
        assertTrue(prop.getPerros().stream()
                .anyMatch(p -> p.getNombre().equals("Matilda")), "Error al agregar Perro a Propietario");
    }
}
