package com.universidad.notificador.servicio;

import com.universidad.notificador.dto.NotificacionRequest;
import com.universidad.notificador.modelo.*;
import com.universidad.notificador.repositorio.NotificacionRepositorio;
import org.springframework.stereotype.Service;

@Service
public class NotificacionServicio {

    private final NotificacionRepositorio repositorio;

    public NotificacionServicio(NotificacionRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Notificacion crearNotificacion(NotificacionRequest request) {
        Notificacion notificacion = switch (request.medio().toLowerCase()) {
            case "email" -> new NotificacionEmail(
                request.codigo(),
                request.destinatario(),
                request.mensaje(),
                request.tipo(),
                request.email(),
                request.asunto()
            );
            case "sms" -> new NotificacionSMS(
                request.codigo(),
                request.destinatario(),
                request.mensaje(),
                request.tipo(),
                request.telefono()
            );
            case "app" -> new NotificacionApp(
                request.codigo(),
                request.destinatario(),
                request.mensaje(),
                request.tipo(),
                request.tokenDispositivo()
            );
            default -> throw new IllegalArgumentException("Medio de notificacion no soportado: " + request.medio());
        };

        return repositorio.save(notificacion);
    }

    public void enviarNotificacion(Long id) {
        Notificacion notificacion = repositorio.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Notificacion no encontrada: " + id));
        
        boolean exitoso = notificacion.enviar();
        if (exitoso) {
            notificacion.setEstado(EstadoNotificacion.ENVIADA);
        } else {
            notificacion.setEstado(EstadoNotificacion.FALLIDA);
        }
        repositorio.save(notificacion);
    }

    public Iterable<Notificacion> listarNotificaciones() {
        return repositorio.findAll();
    }

    public Notificacion obtenerNotificacion(Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Notificacion no encontrada: " + id));
    }
}