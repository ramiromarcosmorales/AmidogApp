package com.ramiro.controller;

import com.ramiro.persistence.PerroJpaController;
import com.ramiro.persistence.PropietarioJpaController;

public class PersistenciaController {
    PropietarioJpaController propietarioJpaController = new PropietarioJpaController();
    PerroJpaController perroJpaController = new PerroJpaController();

    public PropietarioJpaController getPropietarioJpaController() {
        return propietarioJpaController;
    }

    public PerroJpaController getPerroJpaController() {
        return perroJpaController;
    }
}
