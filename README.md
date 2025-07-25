# 🎬 API REST de Películas - Spring Boot + MySQL

Este proyecto es una **API RESTful** desarrollada con **Spring Boot** que permite gestionar una colección de películas. Se conecta a una base de datos **MySQL** para almacenar la información y permite operaciones CRUD completas, además de una funcionalidad para calificar películas mediante un sistema de ratings.

## 🚀 Funcionalidades

- 🔍 Listar todas las películas
- 🎥 Obtener detalles de una película por su ID
- ➕ Crear una nueva película
- ✏️ Actualizar una película existente
- ❌ Eliminar una película por su ID
- ⭐ Agregar un rating a una película (aumenta el promedio y el número de votos)

## 🛠️ Tecnologías utilizadas

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Postman / Thunder Client (para pruebas de endpoints)

## 📦 Estructura del proyecto

src/
├── main/
│ ├── java/
│ │ └── com/erickdeps/movies/
│ │ ├── com/erickdeps/movies/controllers/
│ │ ├── com/erickdeps/movies/models/
│ │ ├── com/erickdeps/movies/repositories/
│ └── resources/
│ ├── application.properties
└── test/


## 🔧 Instalación y puesta en marcha

1. Clona el repositorio:
   ```bash
   git clone https://github.com/ErickDeps/Movie-REST-API-with-Spring-Boot-MySQL.git
   cd Movie-REST-API-with-Spring-Boot-MySQL

2. Crea el archivo application.properties en src/main/resources/:
## src/main/resources/application.properties
Usa este ejemplo:
spring.application.name=movies
spring.datasource.url=jdbc:mysql://localhost:3306/movies
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

3. Asegúrate de tener una base de datos MySQL creada:
CREATE DATABASE movies;

4. Ejecuta la aplicación desde tu IDE

5. Urls o Endpoints
| Método | Endpoint                       | Descripción                   |
| ------ | -------------------------------| ----------------------------- |
| GET    | `/api/movies`                  | Listar todas las películas    |
| GET    | `/api/movies/{id}`             | Ver detalles de una película  |
| POST   | `/api/movies`                  | Crear una nueva película      |
| PUT    | `/api/movies/{id}`             | Actualizar una película       |
| DELETE | `/api/movies/{id}`             | Eliminar una película         |
| PATCH  | `/api/movies/vote/{id}/rating` | Agregar rating a una película |

## 🛡️ Seguridad y buenas prácticas
- Se ha añadido application.properties al .gitignore para proteger credenciales sensibles.
- Se recomienda usar variables de entorno o un archivo .env al momento del despliegue.



