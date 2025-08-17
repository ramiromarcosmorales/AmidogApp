package com.ramiro.controller;

import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;
import com.ramiro.utils.ValidacionUtils;

import java.time.LocalDateTime;
import java.util.List;

public class TurnoController {
    private final PersistenciaController persistencia;

    public TurnoController(PersistenciaController persistencia) {
        ValidacionUtils.validarObjeto(persistencia, "Persistencia null");
        this.persistencia = persistencia;
    }

    public void crearTurno(LocalDateTime fechaHora, Propietario propietario) {
        ValidacionUtils.validarFecha(fechaHora, "Fecha ");
        Turno turno = Turno.crearTurno(fechaHora, propietario);
        persistencia.crearTurno(turno);
    }

    public void editarTurno(Turno turno) {
        ValidacionUtils.validarObjeto(turno, "Turno null");
        persistencia.editarTurno(turno);
    }

    public Turno obtenerTurno(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        return persistencia.obtenerTurno(id);
    }

    public List<Turno> obtenerTurnos() {
        return persistencia.obtenerTurnos();
    }

    public List<Turno> obtenerTurnosActivos() {
        return persistencia.obtenerTurnos().stream()
                .filter(t -> t.getFechaHora().isAfter(LocalDateTime.now()))
                .toList();
    }

    public List<Turno> obtenerTurnosInactivos() {
        return persistencia.obtenerTurnos().stream()
                .filter(t -> t.getFechaHora().isBefore(LocalDateTime.now()))
                .toList();
    }

    public void eliminarTurno(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        persistencia.eliminarTurno(id);
    }

    public void eliminarTurnos() {
        persistencia.borrarTurnos();
    }
}
