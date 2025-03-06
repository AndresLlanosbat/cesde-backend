# Gestor de Cursos - Backend

Este es un proyecto backend desarrollado en **Java (Spring Boot)** para gestionar la información de los cursos ofrecidos por **Cesde**. Permite a los administradores **agregar, editar y eliminar cursos**, así como administrar los **docentes** que dictarán cada curso.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot**
- **MySQL**
- **JPA/Hibernate**
- **Maven**

## Características
- CRUD de **Cursos** y **Docentes**
- Implementación de **DTOs** para la transferencia de datos
- **Filtros de búsqueda** por nombre del curso, precio y duración
- Documentación clara en este README

---

## Instalación y Ejecución
### 1. Clonar el repositorio
```bash
    git clone https://github.com/tu_usuario/tu_repositorio.git
    cd tu_repositorio
```

### 2. Configurar Base de Datos
1. Crear una base de datos en MySQL:
    ```sql
    CREATE DATABASE gestor_cursos;
    ```
2. Configurar `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/gestor_cursos
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

### 3. Ejecutar la Aplicación
```bash
    mvn spring-boot:run
```
La API estará disponible en: `http://localhost:8080`

---

## Endpoints
### **Cursos**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| GET | `/api/cursos` | Listar todos los cursos |
| GET | `/api/cursos?nombre=Java` | Buscar cursos por nombre |
| POST | `/api/cursos` | Crear un curso |
| PUT | `/api/cursos/{id}` | Editar un curso |
| DELETE | `/api/cursos/{id}` | Eliminar un curso |

### **Docentes**
| Método | Endpoint | Descripción |
|--------|---------|-------------|
| GET | `/api/docentes` | Listar todos los docentes |
| POST | `/api/docentes` | Crear un docente |

---

## Base de Datos
### **Estructura de Tablas**
```sql
CREATE TABLE docente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    documento VARCHAR(255),
    correo VARCHAR(255)
);

CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    duracion INT,
    precio DECIMAL(10, 2),
    fecha_inicio DATETIME,
    docente_id BIGINT,
    FOREIGN KEY (docente_id) REFERENCES docente(id)
);
```

---

## Autor
**Andrés Llanos Agudelo**

