CREATE DATABASE IF NOT EXISTS bd_carrera_academica_spring
CHARACTER SET utf8mb4
COLLATE utf8mb4_spanish_ci;

USE bd_carrera_academica_spring;

-- =====================================================
-- PROYECTO: Sistema Académico MVC - Spring Boot
-- AUTOR: Neider Lizcano Suescun
-- CÓDIGO: 7502420041
-- =====================================================

-- Nota:
-- Las tablas usuarios y carreras_academicas son generadas automáticamente
-- por Hibernate a partir de las entidades Usuario y CarreraAcademica.
-- Esto ocurre porque en application.properties se usa:
-- spring.jpa.hibernate.ddl-auto=update

-- =====================================================
-- USUARIO DE PRUEBA OPCIONAL
-- =====================================================

INSERT INTO usuarios (cedula, clave, email, nombre)
VALUES ('123456789', '12345', 'admin@gmail.com', 'Administrador del sistema')
    ON DUPLICATE KEY UPDATE
                         clave = VALUES(clave),
                         email = VALUES(email),
                         nombre = VALUES(nombre);

-- =====================================================
-- CARRERA ACADÉMICA DE PRUEBA OPCIONAL
-- =====================================================

INSERT INTO carreras_academicas (
    nombre,
    num_creditos,
    num_asignaturas,
    num_semestres,
    nivel_formacion,
    titulo,
    valor_semestre,
    universidad,
    es_acreditada,
    perfiles,
    area_conocimiento
)
VALUES (
           'Ingeniería de Software',
           160,
           55,
           10,
           'Profesional',
           'Ingeniero de Software',
           3200000.00,
           'Universidad de Cartagena',
           true,
           'Desarrollo web, bases de datos, arquitectura de software',
           'Ingeniería'
       );