# Segundo Proyecto - Aerolinea API

Proyecto backend hecho con Spring Boot para manejar pasajeros, vuelos y reservas.

## Lo que hace

- Crear, listar, buscar, editar y eliminar pasajeros
- Crear, listar, buscar, editar y eliminar vuelos
- Crear reservas asociando un pasajero con un vuelo

## Tecnologias

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Swagger / OpenAPI
- Maven

## Como correr

La aplicacion esta configurada para conectarse a Supabase usando PostgreSQL por JDBC.

### Conexion a Supabase

1. Crea un archivo `.env` en la raiz del proyecto.
2. Copia el formato de `.env.example`.
3. Reemplaza la contrasena por la de tu proyecto Supabase.

Ejemplo:

```env
DATABASE_URL=jdbc:postgresql://db.fdbyrydvbfoovrvebxae.supabase.co:5432/postgres?sslmode=require
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=tu_password_de_supabase
JPA_DDL_AUTO=update
SERVER_PORT=8080
```

Spring Boot importa ese archivo `.env` al iniciar. Supabase exige SSL, por eso el `sslmode=require` va dentro de la URL JDBC.

Para levantarla:

```bash
./mvnw spring-boot:run
```

Si prefieres Maven instalado:

```bash
mvn spring-boot:run
```

La app queda en:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

## Endpoints

### Pasajeros

- `POST /pasajeros`
- `GET /pasajeros`
- `GET /pasajeros/{id}`
- `PUT /pasajeros/{id}`
- `DELETE /pasajeros/{id}`

### Vuelos

- `POST /vuelos`
- `GET /vuelos`
- `GET /vuelos/{id}`
- `PUT /vuelos/{id}`
- `DELETE /vuelos/{id}`

### Reservas

- `POST /reservas`

## Modelo

### Pasajero

- `id`
- `nombre`
- `apellido`
- `documento`
- `email`

### Vuelo

- `id`
- `origen`
- `destino`
- `fechaHora`
- `estado`

Estados de vuelo:

- `PROGRAMADO`
- `EN_VUELO`
- `ATERRIZADO`
- `CANCELADO`

### Reserva

Relaciona un pasajero con un vuelo y una clase de asiento.

Clases disponibles:

- `ECONOMICA`
- `EJECUTIVA`
- `PRIMERA_CLASE`

## Ejemplo de reserva

Request:

```json
{
  "pasajeroId": 1,
  "vueloId": 2,
  "claseAsiento": "ECONOMICA"
}
```

Response:

```json
{
  "reservaId": 10,
  "nombrePasajero": "Juan",
  "origenVuelo": "Bogota",
  "destinoVuelo": "Medellin",
  "claseAsiento": "ECONOMICA"
}
```

## Nota

- Si el pasajero o el vuelo no existen, la reserva responde con `404`.
- La validacion de datos esta hecha con Jakarta Validation.

## Desplegar en Render

1. Conecta este repositorio en [Render](https://render.com) como **Web Service** con runtime **Docker**.
2. Configura las variables de entorno de Supabase (`DATABASE_URL`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`).
3. Agrega `APP_CORS_ALLOWED_ORIGIN_PATTERNS` con el origin de tu GitHub Pages:

```env
APP_CORS_ALLOWED_ORIGIN_PATTERNS=http://localhost:*,http://127.0.0.1:*,https://didiernajas.github.io
```

> **Nota:** Desde la version actual, `localhost` y `https://*.github.io` ya vienen permitidos en codigo. Si en Render tienes `APP_CORS_ALLOWED_ORIGIN_PATTERNS` solo con localhost, eliminala o agrega GitHub Pages.

4. Tras el deploy, usa la URL publica (por ejemplo `https://aerolinea-api.onrender.com`) en el frontend en `js/config.js`.

Tambien puedes usar el archivo `render.yaml` incluido en la raiz del proyecto como blueprint de Render.
