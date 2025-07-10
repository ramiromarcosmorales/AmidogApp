package com.ramiro.model;

import com.ramiro.utils.ValidacionUtils;

import java.time.LocalDateTime;

public class Turno {
    private int id;
    private LocalDateTime fechaHora;
    private Propietario propietario;

    private Turno(int id, LocalDateTime fechaHora, Propietario propietario) {
        ValidacionUtils.validarFecha(fechaHora, "La fecha no puede ser pasada");
        ValidacionUtils.validarObjeto(propietario, "El propietario no puede ser nulo");

        this.id = id;
        this.fechaHora = fechaHora;
        this.propietario = propietario;
    }

    public static Turno crearTurno(int id, LocalDateTime fecha, Propietario propietario) {
        return new Turno(id, fecha, propietario);
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
        ValidacionUtils.validarFecha(fechaHora, "La fecha no puede ser pasada");
        this.fechaHora = fechaHora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario prop) {
        ValidacionUtils.validarObjeto(prop, "El propietario no puede ser nulo");
        this.propietario = prop;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fechaHora=" + fechaHora +
                ", propietario=" + propietario +
                '}';
    }
}
