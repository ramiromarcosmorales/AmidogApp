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

    public void eliminarTurno(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        persistencia.eliminarTurno(id);
    }
}
