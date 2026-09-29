# Taller 06 – API REST con Spring Boot

Microservicio en Java con Spring Boot que expone una API REST para gestionar
productos (CRUD) usando los verbos HTTP **GET, POST, PUT y DELETE**.

**Universidad del Cauca – Laboratorio de Ingeniería de Software II – 2026.2**

Integrantes:
- Nombre 1 – código
- Nombre 2 – código

## Tecnologías
- Java 17 o 21
- Spring Boot 3.x (Spring Web)
- Maven
- Postman para las pruebas

## Arquitectura en capas

```
controller/  -> ProductController      (endpoints HTTP)
service/     -> IProductService         (contrato)
                ProductServiceImpl      (lógica de negocio)
repository/  -> ProductRepository       (almacenamiento en memoria)
model/       -> Product                 (entidad de dominio / JSON)
```

## Cómo ejecutar

Desde el IDE: ejecutar `MicroserviceApplication.java`.

Desde la terminal (en la carpeta del proyecto; el wrapper `mvnw` lo incluye el proyecto generado con Spring Initializr):

```bash
./mvnw spring-boot:run      # Linux / macOS
mvnw.cmd spring-boot:run    # Windows
```

El servicio queda disponible en `http://localhost:8080/api/products`.

## Endpoints

| Método | Ruta                  | Descripción              | Respuesta        |
|--------|-----------------------|--------------------------|------------------|
| GET    | `/api/products`       | Lista todos los productos| 200 OK           |
| GET    | `/api/products/{id}`  | Busca un producto por id | 200 OK / 404     |
| POST   | `/api/products`       | Crea un producto         | 201 Created      |
| PUT    | `/api/products/{id}`  | Actualiza un producto    | 200 OK / 404     |
| DELETE | `/api/products/{id}`  | Elimina un producto      | 204 No Content / 404 |

### Ejemplo de body (POST / PUT)

```json
{
  "id": 3,
  "name": "Teclado Mecánico",
  "price": 250000.0
}
```

> Los datos se guardan en memoria: al reiniciar la aplicación vuelven
> los dos productos iniciales (Laptop Dell y Mouse Inalámbrico).
