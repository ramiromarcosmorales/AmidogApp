package com.ramiro;

import com.ramiro.controller.PerroController;
import com.ramiro.controller.PersistenciaController;
import com.ramiro.controller.PropietarioController;
import com.ramiro.controller.TurnoController;
import com.ramiro.model.Turno;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersistenciaController persistencia = new PersistenciaController();

        PropietarioController propietarioController = new PropietarioController(persistencia);
        PerroController perroController = new PerroController(persistencia);
        TurnoController turnoController = new TurnoController(persistencia);
    }
}