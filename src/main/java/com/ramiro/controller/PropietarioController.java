package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.utils.ValidacionUtils;

import java.util.List;

public class PropietarioController {
    private final PersistenciaController persistencia;

    public PropietarioController(PersistenciaController persistencia) {
        ValidacionUtils.validarObjeto(persistencia, "Persistencia null");

        this.persistencia = persistencia;
    }

    public void crearPropietario(String nombre) {
        ValidacionUtils.validarTexto(nombre, "Nombre incompleto");

        Propietario prop = Propietario.crearPropietario(nombre);
        persistencia.crearPropietario(prop);
    }

    public Propietario buscarPropietario(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        return persistencia.obtenerPropietario(id);
    }

    public List<Propietario> buscarPropietarios() {
        return persistencia.obtenerPropietarios();
    }

    public void editarPropietario(Propietario prop) {
        ValidacionUtils.validarObjeto(prop, "Propietario null");
        persistencia.editarPropietario(prop);
    }

    public void eliminarPropietario(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        persistencia.eliminarPropietario(id);
    }

    // repensar esto
    public boolean agregarPerro(Perro perro, Propietario prop) {
        ValidacionUtils.validarObjeto(perro, "El perro no puede ser nulo");
        ValidacionUtils.validarObjeto(prop, "El propietario no puede ser nulo");
        return prop.agregarPerro(perro);
    }

    public Perro buscarPerro(int id, Propietario prop) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        ValidacionUtils.validarObjeto(prop, "Propietario null");

        for (Perro perro : prop.getPerros()) {
            if (perro.getId() == id) {
                return perro;
            }
        }
        return null;
    }

    public void borrarPropietarios() {
        persistencia.borrarPropietarios();
    }
}
