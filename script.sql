CREATE DATABASE gestor_cursos;

USE gestor_cursos;

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