package com.universidad.notificador.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class NotificacionEmail extends Notificacion {

    @Column(nullable = false)
    private String email;

    @Column
    private String asunto;

    public NotificacionEmail() {
    }

    public NotificacionEmail(String codigo, String destinatario, String mensaje, TipoNotificacion tipo, String email, String asunto) {
        super(codigo, destinatario, mensaje, tipo);
        this.email = email;
        this.asunto = asunto;
    }

    @Override
    public boolean enviar() {
        System.out.println("Enviando email a: " + email);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + getMensaje());
        setEstado(EstadoNotificacion.ENVIADA);
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}