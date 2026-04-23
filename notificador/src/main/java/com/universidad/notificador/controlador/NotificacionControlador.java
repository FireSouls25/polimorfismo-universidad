package com.universidad.notificador.controlador;

import com.universidad.notificador.dto.NotificacionRequest;
import com.universidad.notificador.modelo.Notificacion;
import com.universidad.notificador.servicio.NotificacionServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionControlador {

    private final NotificacionServicio servicio;

    public NotificacionControlador(NotificacionServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody NotificacionRequest request) {
        try {
            Notificacion notificacion = servicio.crearNotificacion(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(notificacion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}/enviar")
    public ResponseEntity<Notificacion> enviarNotificacion(@PathVariable Long id) {
        try {
            servicio.enviarNotificacion(id);
            Notificacion notificacion = servicio.obtenerNotificacion(id);
            return ResponseEntity.ok(notificacion);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Notificacion>> listarNotificaciones() {
        return ResponseEntity.ok(servicio.listarNotificaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtenerNotificacion(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(servicio.obtenerNotificacion(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}