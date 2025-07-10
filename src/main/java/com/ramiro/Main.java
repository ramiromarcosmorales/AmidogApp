package com.ramiro;

import com.ramiro.controller.PerroController;
import com.ramiro.controller.PersistenciaController;
import com.ramiro.controller.PropietarioController;
import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;

public class Main {
    public static void main(String[] args) {
//        PropietarioController controllerProp = new PropietarioController();
//        PerroController controllerPerro = new PerroController();
//        TurnoController controllerTurno = new TurnoController();
//
//        Propietario prop = controllerProp.crearPropietario(1, "");
//        Perro perro = controllerPerro.crearPerro(1, "Matilda", 8, "es feliz :)", prop);
//        Turno turno = controllerTurno.registrarTurno(1, LocalDateTime.now(), prop);
//
//
//        prop.agregarPerro(perro);
//        Perro perritoBuscado = controllerProp.buscarPerro(1000);
//        System.out.println(perritoBuscado);

        PersistenciaController persistenciaController = new PersistenciaController();

        PropietarioController propietarioController = new PropietarioController();
        PerroController perroController = new PerroController();

        Propietario prop = persistenciaController.getPropietarioJpaController().findPropietario(1);
        System.out.println(prop);

        Perro per = persistenciaController.getPerroJpaController().findPerro(1);
        System.out.println(per);
    }
}