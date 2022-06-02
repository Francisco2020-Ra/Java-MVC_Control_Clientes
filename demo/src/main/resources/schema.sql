USE test;

CREATE TABLE IF NOT EXISTS persona (
    id_persona BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefono VARCHAR(255),
    saldo DOUBLE,
    CONSTRAINT pk_persona PRIMARY KEY (id_persona)
);

CREATE TABLE IF NOT EXISTS usuario(
    id_usuario BIGINT       NOT NULL AUTO_INCREMENT,
    username   VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS rol(
  id_rol      BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(255) NOT NULL,
  CONSTRAINT pk_rol PRIMARY KEY (id_rol)
);

ALTER TABLE rol ADD CONSTRAINT FK_ROL_ON_USUARIO FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)