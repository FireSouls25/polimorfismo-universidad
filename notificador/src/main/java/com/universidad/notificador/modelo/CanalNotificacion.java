package com.universidad.notificador.modelo;

public interface CanalNotificacion {
    boolean enviar(Notificacion notificacion);
    String obtenerInfoAdicional();
}