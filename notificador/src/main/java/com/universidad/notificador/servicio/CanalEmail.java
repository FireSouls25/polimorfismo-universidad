package com.universidad.notificador.servicio;

import com.universidad.notificador.modelo.CanalNotificacion;
import com.universidad.notificador.modelo.Notificacion;
import org.springframework.stereotype.Service;

@Service
public class CanalEmail implements CanalNotificacion {

    private String servidorSMTP = "smtp.universidad.edu";
    private int puerto = 587;

    @Override
    public boolean enviar(Notificacion notificacion) {
        System.out.println("Enviando via Canal Email (SMTP: " + servidorSMTP + ":" + puerto + ")");
        return notificacion.enviar();
    }

    @Override
    public String obtenerInfoAdicional() {
        return "SMTP: " + servidorSMTP + ", Puerto: " + puerto;
    }
}