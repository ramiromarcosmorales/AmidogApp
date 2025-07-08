package com.ramiro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Propietario {
    private Integer id;
    private String nombre;
    private List<Perro> perros = new ArrayList<Perro>();

    private Propietario(Integer id, String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre no puede ser nulo o vacio");
        this.id = id;
        this.nombre = nombre;
    }

    public static Propietario crearPropietario(Integer id, String nombre) {
        return new Propietario(id, nombre);
    }

    public boolean agregarPerro(Perro perro) {
        return perros.add(perro);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre no puede ser nulo o vacio");
        this.nombre = nombre;
    }

    public List<Perro> getPerros() {
        return Collections.unmodifiableList(perros);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", perros=" + perros +
                '}';
    }
}
