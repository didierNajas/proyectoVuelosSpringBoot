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

## Como corre

La aplicacion usa PostgreSQL local. La conexion esta en `src/main/resources/application.properties`.

Datos que espera por defecto:

- `jdbc:postgresql://localhost:5432/aerolineaApi`
- usuario `postgres`
- contrasena configurada en el archivo de propiedades

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
