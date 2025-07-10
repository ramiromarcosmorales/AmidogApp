package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;

public class PerroController {

    public Perro crearPerro(String nombre, int edad, String descripcion, Propietario propietario) {
        return Perro.crearPerro(nombre, edad, descripcion, propietario); // delegar persistencia
    }
}
