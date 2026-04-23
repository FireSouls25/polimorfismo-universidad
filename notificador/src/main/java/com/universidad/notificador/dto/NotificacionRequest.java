package com.universidad.notificador.dto;

import com.universidad.notificador.modelo.TipoNotificacion;

public record NotificacionRequest(
    String codigo,
    String destinatario,
    String mensaje,
    TipoNotificacion tipo,
    String medio,
    String email,
    String asunto,
    String telefono,
    String tokenDispositivo
) {}