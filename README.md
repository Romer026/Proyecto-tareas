# Proyecto-tareas-BackEnd
Aplicación web con Spring boot de creación de proyectos y asignación de tareas

## Requisitos Previos

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html) (versión 11 o superior)
- [Spring Boot](https://spring.io/projects/spring-boot) (versión 4.1 o superior)
- [Maven](https://maven.apache.org/download.cgi) (versión X.X o superior) o [Gradle](https://gradle.org/install/) (versión 3.2.0o superior)
- [Base de Datos](#configuración-de-base-de-datos) (H2)

## Configuración de Base de Datos

1. Configura tu base de datos en `src/main/resources/application.properties` o `src/main/resources/application.yml`.
2. Asegúrate de especificar las credenciales y la URL de conexión correctamente.

```yml
spring.datasource.url: jdbc:h2:mem:nombrebd

spring.datasource.driverClassName: org.h2.Driver
spring.datasource.username: sa
spring.datasource.password: password
spring.jpa.database-platform: org.hibernate.dialect.H2Dialect
spring.h2.console.enabled: true


spring.jpa.show-sql: true
spring.jpa.properties.hibernate.format_sql: true

spring:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    properties:
      hibernate:
        show_sql: true
        format_sql: true
        enable_lazy_load_no_trans: true

logging:
  level:
    root: DEBUG


## Ejecución desde el Método `main`

Puedes ejecutar la aplicación directamente desde el método `main` de la clase principal de la aplicación Spring Boot. Aquí tienes los pasos para hacerlo:

1. Abre la clase principal de la aplicación, que generalmente se encuentra en `src/main/java/com/tuempresa/tuproyecto/TuProyectoApplication.java`.

2. Dentro de esta clase, encontrarás un método `main` que luce similar a esto:

```java
@SpringBootApplication
public class TuProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuProyectoApplication.class, args);
    }

}
Simplemente ejecuta este método main como una aplicación Java estándar. Esto iniciará la aplicación Spring Boot y la pondrá en funcionamiento.
Desde tu IDE, puedes hacer clic derecho en la clase TuProyectoApplication y seleccionar "Run" o "Debug".
Desde la línea de comandos, puedes utilizar el siguiente comando en la raíz del proyecto:
shell
Copy code
mvn spring-boot:run
La aplicación se iniciará y estará disponible en la URL especificada en la configuración de application.properties o application.yml (por defecto, http://localhost:8080).
Asegúrate de que tu base de datos esté configurada correctamente antes de ejecutar la aplicación desde el método main, ya que esto puede requerir que la base de datos esté en funcionamiento para que la aplicación se inicie sin problemas.




