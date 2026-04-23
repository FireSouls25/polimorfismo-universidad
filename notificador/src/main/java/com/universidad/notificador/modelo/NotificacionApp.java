package com.universidad.notificador.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class NotificacionApp extends Notificacion {

    @Column
    private String tokenDispositivo;

    public NotificacionApp() {
    }

    public NotificacionApp(String codigo, String destinatario, String mensaje, TipoNotificacion tipo, String tokenDispositivo) {
        super(codigo, destinatario, mensaje, tipo);
        this.tokenDispositivo = tokenDispositivo;
    }

    @Override
    public boolean enviar() {
        System.out.println("Enviando notificacion push al dispositivo: " + tokenDispositivo);
        System.out.println("Mensaje: " + getMensaje());
        setEstado(EstadoNotificacion.ENVIADA);
        return true;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }
}