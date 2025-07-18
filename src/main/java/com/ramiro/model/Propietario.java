package com.ramiro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Basic
    private String nombre;
    @OneToMany(mappedBy="propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Perro> perros = new ArrayList<Perro>();
    @OneToMany(mappedBy="propietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos = new ArrayList<>();

    protected Propietario() {
    }

    private Propietario(String nombre) {
        this.nombre = nombre;
    }

    public static Propietario crearPropietario(String nombre) {
        return new Propietario(nombre);
    }

    public boolean agregarPerro(Perro perro) {
        return perros.add(perro);
    }

    public boolean agregarTurno(Turno turno) {
        return turnos.add(turno);
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
        return Collections.unmodifiableList(perros);
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
//                ", perros=" + (perros != null ? perros.size() + " perros" : "null") +
                ", perros=" + perros +
                ", turnos=" + turnos +
                '}';
    }
}
