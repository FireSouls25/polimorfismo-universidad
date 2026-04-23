package com.universidad.notificador.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class NotificacionSMS extends Notificacion {

    @Column(nullable = false)
    private String telefono;

    public NotificacionSMS() {
    }

    public NotificacionSMS(String codigo, String destinatario, String mensaje, TipoNotificacion tipo, String telefono) {
        super(codigo, destinatario, mensaje, tipo);
        this.telefono = telefono;
    }

    @Override
    public boolean enviar() {
        System.out.println("Enviando SMS al telefono: " + telefono);
        System.out.println("Mensaje: " + getMensaje());
        setEstado(EstadoNotificacion.ENVIADA);
        return true;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}