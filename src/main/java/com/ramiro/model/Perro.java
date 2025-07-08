package com.ramiro.model;

import com.ramiro.utils.ValidacionUtils;

public class Perro {
    private int id;
    private String nombre;
    private int edad;
    private String descripcion;
    private Propietario propietario;

    private Perro(int id, String nombre, int edad, String descripcion, Propietario propietario) {
        ValidacionUtils.validarTexto(nombre, "El nombre no puede ser nulo o vacio");
        if (edad < 0 || edad > 30) throw new IllegalArgumentException("La edad razonable es entre 0 a 30");
        ValidacionUtils.validarTexto(descripcion, "La descripcion no puede ser nulo o vacio");
        if (propietario == null) throw new IllegalArgumentException("Propietario no puede ser nulo.");

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }

    public static Perro crearPerro(int id, String nombre, int edad, String descripcion, Propietario propietario) {
        return new Perro(id, nombre, edad, descripcion, propietario);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        ValidacionUtils.validarTexto(nombre, "El nombre no puede ser nulo o vacio");
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 30) throw new IllegalArgumentException("La edad razonable es entre 0 a 30");
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        ValidacionUtils.validarTexto(descripcion, "La descripcion no puede ser nulo o vacio");
        this.descripcion = descripcion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
