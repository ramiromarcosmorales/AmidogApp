package com.ramiro.controller;

import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.utils.ValidacionUtils;

import java.util.List;
import java.util.Optional;

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

    public Propietario buscarPropietario(Integer id) {
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

    public void eliminarPropietario(Integer id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        persistencia.eliminarPropietario(id);
    }

    public void agregarPerro(Perro perro, Propietario prop) {
        ValidacionUtils.validarObjeto(perro, "El perro no puede ser nulo");
        ValidacionUtils.validarObjeto(prop, "El propietario no puede ser nulo");
        prop.agregarPerro(perro);
    }

    public Perro buscarPerro(Integer id, Propietario prop) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        ValidacionUtils.validarObjeto(prop, "Propietario null");

        return prop.getPerros().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Perro buscarPerroPorNombre(String nombre, Propietario prop) {
        ValidacionUtils.validarTexto(nombre, "Nombre incompleto");
        ValidacionUtils.validarObjeto(prop, "Propietario null");

        return prop.getPerros().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Perro> buscarPerrosPorEdad(Integer edad, Propietario prop) {
        // crear validacion para edad
        ValidacionUtils.validarObjeto(prop, "Propietario null");

        return prop.getPerros().stream()
                .filter(p -> p.getEdad() >= edad)
                .toList();
    }

    public void borrarPropietarios() {
        persistencia.borrarPropietarios();
    }

    public Propietario buscarPropietarioConPerros(Integer id) {
        return persistencia.buscarPropietarioConPerros(id);
    }
}
