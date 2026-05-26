# Sistema Académico MVC - Spring Boot

Proyecto académico desarrollado con Spring Boot MVC para la gestión de usuarios y carreras académicas.

## Autor

**Neider Lizcano Suescun**  
Código: **7502420041**

## Descripción del proyecto

Esta aplicación web permite administrar usuarios y carreras académicas mediante una estructura basada en el patrón MVC.

El sistema incluye:

- CRUD de usuarios.
- CRUDL de carreras académicas.
- Inicio de sesión.
- Cierre de sesión.
- Protección de rutas.
- Recuperación de contraseña mediante Mailpit.
- Validaciones del lado del servidor.
- Interfaz web con Thymeleaf y CSS.
- Persistencia en MySQL usando Spring Data JPA.
- Trabajo con Git y GitHub usando ramas, commits progresivos y push pequeños.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Lombok
- Jakarta Validation
- Mailpit
- Maven
- Git y GitHub
- IntelliJ IDEA

## Estructura principal del proyecto

```txt
src/main/java/com/neider/carreraacademica
│
├── config
│   ├── AutenticacionInterceptor.java
│   └── WebConfig.java
│
├── controladores
│   ├── AuthControlador.java
│   ├── InicioControlador.java
│   ├── UsuarioControlador.java
│   └── CarreraAcademicaControlador.java
│
├── dao
│   ├── IUsuarioDao.java
│   └── ICarreraAcademicaDao.java
│
├── modelo
│   ├── Usuario.java
│   └── CarreraAcademica.java
│
├── servicio
│   ├── IUsuarioServicio.java
│   ├── UsuarioServicioImpl.java
│   ├── ICarreraAcademicaServicio.java
│   ├── CarreraAcademicaServicioImpl.java
│   └── CorreoServicio.java
│
└── CarreraAcademicaSpringApplication.java
```

## Módulos del sistema

### Usuarios

El módulo de usuarios permite:

- Registrar usuarios.
- Listar usuarios.
- Editar usuarios.
- Eliminar usuarios.
- Validar campos obligatorios.
- Usar usuarios registrados para iniciar sesión.

Campos principales:

- Cédula
- Clave
- Nombre
- Email

### Carreras Académicas

El módulo de carreras académicas permite:

- Registrar carreras académicas.
- Listar carreras académicas.
- Consultar el detalle de una carrera.
- Editar carreras académicas.
- Eliminar carreras académicas.
- Validar campos obligatorios y valores numéricos.

Campos principales:

- Nombre
- Número de créditos
- Número de asignaturas
- Número de semestres
- Nivel de formación
- Título otorgado
- Valor del semestre
- Universidad
- Acreditación
- Perfiles
- Área de conocimiento

### Login

El sistema cuenta con autenticación básica mediante correo y contraseña.

Las rutas principales están protegidas, por lo que el usuario debe iniciar sesión antes de ingresar al sistema.

### Recuperación de contraseña

La recuperación de contraseña se realiza mediante Mailpit.

El usuario ingresa su correo registrado y el sistema genera una contraseña temporal. Luego actualiza esa contraseña en la base de datos y envía el mensaje al buzón local de Mailpit.

## Rutas principales

```txt
/login
/logout
/recuperar
/
/usuarios
/usuarios/agregar
/usuarios/editar/{cedula}
/usuarios/eliminar/{cedula}
/carreras
/carreras/agregar
/carreras/ver/{id}
/carreras/editar/{id}
/carreras/eliminar/{id}
```

## Base de datos

Nombre de la base de datos:

```txt
bd_carrera_academica_spring
```

El proyecto usa Spring Data JPA con Hibernate, por lo que las tablas se generan automáticamente a partir de las entidades.

Configuración principal en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_carrera_academica_spring?useSSL=false&serverTimezone=America/Bogota&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.thymeleaf.cache=false
server.port=8080
```

## Configuración de Mailpit

Mailpit debe estar activo en Laragon.

```txt
SMTP: localhost:1025
Panel web: http://localhost:8025
```

Configuración usada en `application.properties`:

```properties
spring.mail.host=localhost
spring.mail.port=1025
spring.mail.username=
spring.mail.password=

spring.mail.properties.mail.smtp.auth=false
spring.mail.properties.mail.smtp.starttls.enable=false
```

## Cómo ejecutar el proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/neiderlizcano/carrera-academica-spring-7502420041.git
```

2. Crear la base de datos en MySQL:

```sql
CREATE DATABASE bd_carrera_academica_spring
CHARACTER SET utf8mb4
COLLATE utf8mb4_spanish_ci;
```

3. Abrir el proyecto en IntelliJ IDEA.

4. Verificar la configuración de `application.properties`.

5. Ejecutar la clase principal:

```txt
CarreraAcademicaSpringApplication
```

6. Abrir el sistema en el navegador:

```txt
http://localhost:8080/login
```

## Usuario de prueba sugerido

Se puede registrar un usuario desde la interfaz del sistema en:

```txt
http://localhost:8080/usuarios/agregar
```

Ejemplo:

```txt
Cédula: 123456789
Nombre: Administrador del sistema
Email: admin@gmail.com
Clave: 12345
```

## Flujo de trabajo con Git

El proyecto se desarrolló usando ramas separadas y commits progresivos.

Ramas usadas:

```txt
main
feature/crud-usuarios
feature/crud-carrera-academica
feature/estilos-y-plantillas
feature/login
feature/validaciones
feature/documentacion
```

Cada funcionalidad fue trabajada en una rama independiente y luego integrada a `main`.

## Funcionalidades implementadas

- CRUD completo de usuarios.
- CRUDL completo de carreras académicas.
- Login con correo y contraseña.
- Logout.
- Protección de rutas mediante interceptor.
- Recuperación de contraseña con Mailpit.
- Validaciones con Jakarta Validation.
- Diseño visual con CSS.
- Conexión a MySQL.
- Persistencia con Spring Data JPA.
- Uso de GitHub con flujo profesional de ramas y commits.

## Estado del proyecto

Proyecto funcional con estructura MVC, persistencia en base de datos, validaciones, login, recuperación de contraseña y diseño web básico profesional.

## Observaciones

El proyecto fue desarrollado siguiendo el modelo de las guías de Spring Boot MVC, replicando el CRUD de usuarios y construyendo el CRUDL de la tabla asignada: **Carrera Académica**.