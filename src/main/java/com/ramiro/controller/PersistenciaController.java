package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;
import com.ramiro.persistence.PerroJpaController;
import com.ramiro.persistence.PropietarioJpaController;
import com.ramiro.persistence.TurnoJpaController;

import java.util.List;

public class PersistenciaController {
    private final PropietarioJpaController propietarioJpaController = new PropietarioJpaController();
    private final PerroJpaController perroJpaController = new PerroJpaController();
    private final TurnoJpaController turnoJpaController = new TurnoJpaController();

    // Metodos de Propietario
    public void crearPropietario(Propietario propietario) {
        propietarioJpaController.create(propietario);
    }

    public Propietario obtenerPropietario(int id) {
        return propietarioJpaController.findPropietario(id);
    }

    public List<Propietario> obtenerPropietarios() {
        return propietarioJpaController.findPropietarioEntities();
    }

    public void editarPropietario(Propietario propietario) {
        propietarioJpaController.edit(propietario);
    }

    public void eliminarPropietario(int id) {
        propietarioJpaController.destroy(id);
    }

    public void borrarPropietarios() {
        propietarioJpaController.deleteAll();
    }

    public Propietario buscarPropietarioConPerros(int id) {
        return propietarioJpaController.findPropietarioConPerros(id);
    }

    // Metodos de Perro
    public void crearPerro(Perro perro) {
        perroJpaController.create(perro);
    }

    public Perro obtenerPerro(int id) {
        return perroJpaController.findPerro(id);
    }

    public List<Perro> obtenerPerros() {
        return perroJpaController.findPerroEntities();
    }

    public void editarPerro(Perro perro) {
        perroJpaController.edit(perro);
    }

    public void eliminarPerro(int id) {
        perroJpaController.destroy(id);
    }

    public void borrarPerros() {
        perroJpaController.deleteAll();
    }

    // Metodo de Turno
    public void crearTurno(Turno turno) {
        turnoJpaController.create(turno);
    }

    public Turno obtenerTurno(int id) {
        return turnoJpaController.findTurno(id);
    }

    public List<Turno> obtenerTurnos() {
        return turnoJpaController.findTurnoEntities();
    }

    public void editarTurno(Turno turno) {
        turnoJpaController.edit(turno);
    }

    public void eliminarTurno(int id) {
        turnoJpaController.destroy(id);
    }

    public void borrarTurnos() {
        turnoJpaController.deleteAll();
    }
}
