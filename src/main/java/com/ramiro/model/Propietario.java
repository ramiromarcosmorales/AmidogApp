package com.ramiro.model;


import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private Integer id;
    private String nombre;
    private List<Perro> perros = new ArrayList<Perro>();

    private Propietario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Propietario crearPropietario(Integer id, String nombre) {
        return new Propietario(id, nombre);
    }

    public void agregarPerro(Perro perro) {
        perros.add(perro);
        System.out.println("lo agregue");
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
        this.nombre = nombre;
    }

    public List<Perro> getPerros() {
        return perros;
    }

    public void setPerros(List<Perro> perros) {
        this.perros = perros;
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
