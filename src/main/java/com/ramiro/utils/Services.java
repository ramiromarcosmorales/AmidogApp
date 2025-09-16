package com.ramiro.utils;

import com.ramiro.controller.PerroController;
import com.ramiro.controller.PersistenciaController;
import com.ramiro.controller.PropietarioController;
import com.ramiro.controller.TurnoController;

public class Services {
    public final PersistenciaController persist;
    public final PropietarioController props;
    public final PerroController perros;
    public final TurnoController turnos;
    
    public Services() {
        this.persist = new PersistenciaController();
        this.props = new PropietarioController(persist);
        this.perros = new PerroController(persist);
        this.turnos = new TurnoController(persist);
    }
}
