package com.ramiro.model;

import com.ramiro.utils.ValidacionUtils;
import org.eclipse.persistence.annotations.PrimaryKey;

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

    protected Propietario() {
    }

    private Propietario(String nombre) {
        ValidacionUtils.validarTexto(nombre, "Nombre no puede ser nulo o vacio");
        this.nombre = nombre;
    }

    public static Propietario crearPropietario(String nombre) {
        return new Propietario(nombre);
    }

    public boolean agregarPerro(Perro perro) {
        ValidacionUtils.validarObjeto(perro, "El perro no puede ser nulo");
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
        ValidacionUtils.validarTexto(nombre, "Nombre no puede ser nulo o vacio");
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
//                ", perros=" + (perros != null ? perros.size() + " perros" : "null") +
                ", perros=" + perros +
                '}';
    }
}
