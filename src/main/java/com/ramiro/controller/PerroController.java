package com.ramiro.controller;

import com.mysql.cj.exceptions.InvalidConnectionAttributeException;
import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.utils.ValidacionUtils;

import java.util.List;

public class PerroController {
    private final PersistenciaController persistencia;

    public PerroController(PersistenciaController persistencia) {
        ValidacionUtils.validarObjeto(persistencia, "Persistencia null");
        this.persistencia = persistencia;
    }

    public void crearPerro(String nombre, int edad, String descripcion, Propietario propietario) {
        ValidacionUtils.validarTexto(nombre, "Nombre incompleto");
        if (edad < 0 || edad > 30) throw new IllegalArgumentException("Edad invalida");
        ValidacionUtils.validarTexto(descripcion, "Descripcion incompleta");
        ValidacionUtils.validarObjeto(propietario, "Propietario incompleto");

        Perro perro = Perro.crearPerro(nombre, edad, descripcion, propietario);
        persistencia.crearPerro(perro);
    }

    public Perro obtenerPerro(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        return persistencia.obtenerPerro(id);
    }

    public List<Perro> obtenerPerros() {
        return persistencia.obtenerPerros();
    }

    public void eliminarPerro(int id) {
        ValidacionUtils.validarId(id, "ID invalido, debe ser mayor que 0");
        persistencia.eliminarPerro(id);
    }

    public void editarPerro(Perro perro) {
        ValidacionUtils.validarObjeto(perro, "Perro null");
        persistencia.editarPerro(perro);
    }
}
