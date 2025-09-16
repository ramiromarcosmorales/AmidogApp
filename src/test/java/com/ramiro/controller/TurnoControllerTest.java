package com.ramiro.controller;

import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurnoControllerTest {
    PersistenciaController persistencia;
    TurnoController turnoController;
    PropietarioController propController;

    @BeforeEach
    void setup() {
        persistencia = new PersistenciaController();
        persistencia.borrarTurnos();
        persistencia.borrarPerros();
        persistencia.borrarPropietarios();
        turnoController = new TurnoController(persistencia);
        propController = new PropietarioController(persistencia);
    }

    @AfterEach
    void tearDown() {
        turnoController.eliminarTurnos();
    }

    @Test
    void crearTurno() {
        // crear un propietario uhmm y deberia estar almacenado en la DB
        propController.crearPropietario("Ramiro");
        Propietario prop = propController.buscarPropietarios().getFirst();
        turnoController.crearTurno(LocalDateTime.of(2025, 8, 20, 17, 30), prop);

        assertEquals(1, turnoController.obtenerTurnos().size());
    }

    @Test
    void editarTurno() {
        propController.crearPropietario("Ramiro");
        Propietario prop = propController.buscarPropietarios().getFirst();
        turnoController.crearTurno(LocalDateTime.of(2025, 8, 20, 17, 30), prop);
        Turno turno = turnoController.obtenerTurnos().getFirst();
        
        turno.setFechaHora(LocalDateTime.of(2025, 10, 20, 13, 30));
        
        turnoController.editarTurno(turno);

        assertEquals(LocalDateTime.of(2025, 10, 20, 13, 30), turnoController.obtenerTurnos().getFirst().getFechaHora());
    }

    @Test
    void obtenerTurno() {
        propController.crearPropietario("Ramiro");
        Propietario prop = propController.buscarPropietarios().getFirst();
        turnoController.crearTurno(LocalDateTime.of(2025, 8, 20, 17, 30), prop);

        Turno turno = turnoController.obtenerTurnos().getFirst();

        assertEquals("Ramiro", turno.getPropietario().getNombre());
    }

    @Test
    void obtenerTurnos() {
        propController.crearPropietario("Ramiro");
        Propietario prop = propController.buscarPropietarios().getFirst();
        turnoController.crearTurno(LocalDateTime.of(2025, 8, 20, 17, 30), prop);
        List<Turno> turnos = turnoController.obtenerTurnos();

        assertEquals(1, turnos.size());
    }

    @Test
    void eliminarTurno() {
        propController.crearPropietario("Ramiro");
        Propietario prop = propController.buscarPropietarios().getFirst();
        turnoController.crearTurno(LocalDateTime.of(2025, 8, 20, 17, 30), prop);

        turnoController.eliminarTurno(turnoController.obtenerTurnos().getFirst().getId());

        assertEquals(0, turnoController.obtenerTurnos().size());
    }
}