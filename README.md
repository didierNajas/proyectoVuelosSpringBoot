# Segundo Proyecto - Aerolinea API

API REST construida con Spring Boot para gestionar pasajeros, vuelos y reservas de una aerolínea.

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Springdoc OpenAPI / Swagger UI
- Maven

## Funcionalidades

- CRUD de pasajeros
- CRUD de vuelos
- Creacion de reservas asociando un pasajero y un vuelo
- Persistencia con JPA sobre PostgreSQL
- Validacion basica de datos de entrada
- Documentacion interactiva con Swagger

## Estructura general

- `controllerEndPoint`: expone los endpoints REST
- `serviceMetodosEtc`: contiene la logica de negocio
- `repositoryComunicacion`: acceso a datos con Spring Data JPA
- `modelEntidades`: entidades y enums del dominio
- `DTO`: objetos de entrada y salida para reservas

## Requisitos

- Java 21
- Maven 3.9+ o el wrapper del proyecto
- PostgreSQL ejecutandose localmente
- Base de datos creada con el nombre `aerolineaApi`

## Configuracion

La conexion a base de datos se define en `src/main/resources/application.properties`.

Valores esperados:

- `spring.datasource.url=jdbc:postgresql://localhost:5432/aerolineaApi`
- `spring.datasource.username=postgres`
- `spring.datasource.password=...`

Importante: no dejes credenciales reales en el repositorio. Si vas a compartir el proyecto, mueve usuario y contrasena a variables de entorno o perfiles de Spring.

JPA esta configurado con:

- `spring.jpa.hibernate.ddl-auto=update`
- `spring.jpa.show-sql=true`

Eso hace que Hibernate cree o actualice las tablas automaticamente segun las entidades.

## Ejecucion

Con Maven:

```bash
mvn spring-boot:run
```

Con el wrapper:

```bash
./mvnw spring-boot:run
```

La aplicacion levanta por defecto en:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

## Endpoints

### Pasajeros

- `POST /pasajeros` crea un pasajero
- `GET /pasajeros` lista todos los pasajeros
- `GET /pasajeros/{id}` obtiene un pasajero por id
- `PUT /pasajeros/{id}` actualiza un pasajero
- `DELETE /pasajeros/{id}` elimina un pasajero

### Vuelos

- `POST /vuelos` crea un vuelo
- `GET /vuelos` lista todos los vuelos
- `GET /vuelos/{id}` obtiene un vuelo por id
- `PUT /vuelos/{id}` actualiza un vuelo
- `DELETE /vuelos/{id}` elimina un vuelo

### Reservas

- `POST /reservas` crea una reserva

## Modelo de datos

### Pasajero

Campos:

- `id`
- `nombre`
- `apellido`
- `documento`
- `email`

### Vuelo

Campos:

- `id`
- `origen`
- `destino`
- `fechaHora`
- `estado`

Estados disponibles:

- `PROGRAMADO`
- `EN_VUELO`
- `ATERRIZADO`
- `CANCELADO`

### Reserva

Relaciona:

- un `Pasajero`
- un `Vuelo`
- una `ClaseAsiento`

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

## Notas

- Si el pasajero o el vuelo no existen, `POST /reservas` responde `404 Not Found`.
- `Pasajero` y `Vuelo` usan validacion con Jakarta Validation.
- El proyecto usa nombres de paquetes mixtos heredados del ejercicio original; no afectan la ejecucion.
