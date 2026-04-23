# Sistema de Notificaciones - Universidad

## Requisitos

- Java 21
- Maven
- Docker (para PostgreSQL)

## Configuración con Docker

### 1. Iniciar PostgreSQL

```bash
docker-compose up -d
```

### 2. Verificar que esté corriendo

```bash
docker-compose ps
```

## Ejecutar la aplicación

```bash
cd notificador
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## Endpoints API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/notificaciones` | Crear notificación |
| POST | `/api/notificaciones/{id}/enviar` | Enviar notificación |
| GET | `/api/notificaciones` | Listar notificaciones |
| GET | `/api/notificaciones/{id}` | Obtener notificación |

## Tipos de Notificación

- `PUBLICACION_CALIFICACIONES`
- `RECORDATORIO_MATRICULA`
- `AVISO_CANCELACION`
- `CONFIRMACION_INSCRIPCION`

## Medios de Envío

- `email` - Requiere: `email`, `asunto`
- `sms` - Requiere: `telefono`
- `app` - Requiere: `tokenDispositivo`

## Estados

- `PENDIENTE`
- `ENVIADA`
- `FALLIDA`

## Consultas de Ejemplo (tambien se puede importar postman_collection.json)

### Crear notificación por Email

```json
{
  "codigo": "NOT-001",
  "destinatario": "Juan Perez",
  "mensaje": "Sus calificaciones del semestre están disponibles",
  "tipo": "PUBLICACION_CALIFICACIONES",
  "medio": "email",
  "email": "juan@universidad.edu",
  "asunto": "Publicación de Calificaciones"
}
```

### Crear notificación por SMS

```json
{
  "codigo": "NOT-002",
  "destinatario": "Maria Lopez",
  "mensaje": "Recuerde que vence el pago de matrícula mañana",
  "tipo": "RECORDATORIO_MATRICULA",
  "medio": "sms",
  "telefono": "+573001234567"
}
```

### Crear notificación por App

```json
{
  "codigo": "NOT-003",
  "destinatario": "Carlos Gomez",
  "mensaje": "Clase de Matemáticas cancelada para mañana",
  "tipo": "AVISO_CANCELACION",
  "medio": "app",
  "tokenDispositivo": "fcm-token-12345"
}
```
