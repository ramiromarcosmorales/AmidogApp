package com.ramiro.utils;

import java.time.LocalDateTime;

public class ValidacionUtils {
    private ValidacionUtils() {}

    public static void validarTexto(String texto, String mensajeError) {
        if (texto == null || texto.trim().isEmpty()) throw new IllegalArgumentException(mensajeError);
    }

    public static void validarObjeto(Object objeto, String mensajeError) {
        if (objeto == null) throw new IllegalArgumentException(mensajeError);
    }

    public static void validarFecha(LocalDateTime fechaHora, String mensajeError) {
        if (fechaHora.isBefore(LocalDateTime.now())) throw new IllegalArgumentException(mensajeError);
    }
}
