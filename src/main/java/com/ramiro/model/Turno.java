package com.ramiro.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    @Basic
    private LocalDateTime fechaHora;
    @ManyToOne
    @JoinColumn(name = "propietario_id", nullable = false)
    private Propietario propietario;

    protected Turno() {}

    private Turno(LocalDateTime fechaHora, Propietario propietario) {
        this.fechaHora = fechaHora;
        this.propietario = propietario;
    }

    public static Turno crearTurno(LocalDateTime fecha, Propietario propietario) {
        return new Turno(fecha, propietario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario prop) {
        this.propietario = prop;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
