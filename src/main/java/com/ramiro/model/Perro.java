package com.ramiro.model;

public class Perro {
    private int id;
    private String nombre;
    private int edad;
    private String descripcion;
    private Propietario propietario;

    private Perro(int id, String nombre, int edad, String descripcion, Propietario propietario) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
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
