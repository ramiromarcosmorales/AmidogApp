package com.ramiro.controller;

import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;

import java.time.LocalDateTime;

public class TurnoController {

    public Turno registrarTurno(LocalDateTime fechaHora, Propietario propietario) {
        return Turno.crearTurno(fechaHora, propietario);
    }
}
