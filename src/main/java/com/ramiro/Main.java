package com.ramiro;

import com.ramiro.controller.PerroController;
import com.ramiro.controller.PersistenciaController;
import com.ramiro.controller.PropietarioController;
import com.ramiro.model.Perro;
import com.ramiro.model.Propietario;
import com.ramiro.persistence.PerroJpaController;
import com.ramiro.persistence.PropietarioJpaController;
import org.eclipse.persistence.internal.jpa.rs.metadata.model.Link;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersistenciaController persistenciaController = new PersistenciaController();
        PropietarioController propietarioController = new PropietarioController();
        PerroController perroController = new PerroController();

        Propietario prop = persistenciaController.obtenerPropietario(5);
        // Forzar a que JPA consulte en la db con el size()
        prop.getPerros().size();

        System.out.println(prop);

    }
}