package com.ramiro;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.model.Turno;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Propietario propietario = Propietario.crearPropietario(1, "Felipe");
        Perro perro = Perro.crearPerro(1, "Matilda", 5, "Es muy inquieta!", propietario);

        propietario.getPerros().add(perro);

        LocalDateTime fechaHora = LocalDateTime.now();

        Turno turno = Turno.crearTurno(1, fechaHora, propietario);
        System.out.println(turno);
    }
}