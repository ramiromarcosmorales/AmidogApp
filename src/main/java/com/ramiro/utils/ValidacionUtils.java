package com.ramiro.utils;

public class ValidacionUtils {
    private ValidacionUtils() {}

    public static void validarTexto(String texto, String mensajeError) {
        if (texto == null || texto.trim().isEmpty()) throw new IllegalArgumentException(mensajeError);
    }
}
