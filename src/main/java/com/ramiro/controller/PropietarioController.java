package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.utils.ValidacionUtils;

public class PropietarioController {
    public Propietario crearPropietario(String nombre) {
        return Propietario.crearPropietario(nombre);
    }

    public boolean agregarPerro(Perro perro, Propietario prop) {
        ValidacionUtils.validarObjeto(perro, "El perro no puede ser nulo");
        ValidacionUtils.validarObjeto(prop, "El propietario no puede ser nulo");
        return prop.agregarPerro(perro);
    }

    public Perro buscarPerro(int id, Propietario prop) {
        for (Perro perro : prop.getPerros()) {
            if (perro.getId() == id) {
                return perro;
            }
        }
        return null;
    }
}
