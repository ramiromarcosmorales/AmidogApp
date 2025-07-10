package com.ramiro.model;

import com.ramiro.utils.ValidacionUtils;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Perro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String nombre;
    private int edad;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    protected Perro() {
    }

    private Perro(String nombre, int edad, String descripcion, Propietario propietario) {
        ValidacionUtils.validarTexto(nombre, "El nombre no puede ser nulo o vacio");
        if (edad < 0 || edad > 30) throw new IllegalArgumentException("La edad razonable es entre 0 a 30");
        ValidacionUtils.validarTexto(descripcion, "La descripcion no puede ser nulo o vacio");
        ValidacionUtils.validarObjeto(propietario, "El propietario no puede ser vacio");

        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }

    public static Perro crearPerro(String nombre, int edad, String descripcion, Propietario propietario) {
        return new Perro(nombre, edad, descripcion, propietario);
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
        ValidacionUtils.validarObjeto(propietario, "El propietario no puede ser vacio");
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
