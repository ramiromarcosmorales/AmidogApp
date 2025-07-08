package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;

public class PropietarioController {
    private Propietario propietario;

    public Propietario crearPropietario(Integer id, String nombre) {
        Propietario prop = Propietario.crearPropietario(id, nombre);
        this.propietario = prop;
        return prop;
    }

    public boolean agregarPerro(Perro perro) {
        if (perro == null) throw new IllegalArgumentException("El perro no puede ser nulo");
        if (this.propietario == null) throw new IllegalArgumentException("El propietario no puede ser nulo");
        return this.propietario.agregarPerro(perro);
    }

    public Perro buscarPerro(int id) {
        for (Perro perro : this.propietario.getPerros()) {
            if (perro.getId() == id) {
                return perro;
            }
        }
        return null;
    }
}
