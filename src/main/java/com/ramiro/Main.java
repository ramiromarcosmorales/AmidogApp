package com.ramiro;

import com.ramiro.controller.PerroController;
import com.ramiro.controller.PropietarioController;
import com.ramiro.controller.TurnoController;
import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PropietarioController controllerProp = new PropietarioController();
        PerroController controllerPerro = new PerroController();
        TurnoController controllerTurno = new TurnoController();

        Propietario prop = controllerProp.crearPropietario(1, "");
        Perro perro = controllerPerro.crearPerro(1, "Matilda", 8, "es feliz :)", prop);
        Turno turno = controllerTurno.registrarTurno(1, LocalDateTime.now(), prop);


        prop.agregarPerro(perro);
        Perro perritoBuscado = controllerProp.buscarPerro(1000);
        System.out.println(perritoBuscado);
    }
}