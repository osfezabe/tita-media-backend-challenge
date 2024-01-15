# TITA Backend Challenge
Prueba técnica para TITA MEDIA DESCRIPCIÓN COMPLETA


### Tegnologías
A continuación se describen las tecnologías utilizadas en la aplicación:

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Java JDK 17](https://jdk.java.net/17/)
* [Apache Maven](https://maven.apache.org/)
* [Project Lombok](https://www.projectlombok.org/)
* [liquibase](https://www.liquibase.org/)
* [Mapstruct](https://mapstruct.org/)
* [JDBC API](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Características

La aplicación ofrece los siguientes servicios a través de un API REST.

* Servicio para listar los usuarios existentes en la aplicación
* Servicio para listar los bancos existentes en la aplicación
* Servicio para consultar las daudas que tiene un usuario específico
* Servicio para listar las deudas que tiene un usuario con un banco específico
* Servicio para ver el detalle de la deuda de un usuario y un banco específico
* Servicio para pagar cuotas o la deuda en su totalidad que tiene un usuario con un banco específico

## Herramientas de desarrollo

Para configurar el ambiente de desarrollo, se recomienda el uso de:

* Editor de código para Java. Se recomienda [IntelliJ Idea](https://www.jetbrains.com/idea/), pero puede ser cualquiera. _Tenga presente que las indicaciones en este documento se brindan para IntelliJ_
* JDK versión 17. En IntelliJ se puede configurar un JDK por proyecto y no es necesario tener un JDK global en el sistema

### Plugins adicionales

Si usa IntelliJ, puede activar los siguientes plugins que ayudarán a la navegación del código.


* Lombok
* Spring (Spring Core + Spring Boot)
* Spring Core


## Ejecución del proyecto


### Preparación

Antes de ejecutar el proyecto, es necesario configurar las variables de entorno necesarias por la aplicación.
Por favor asegúrese de añadir las siguientes variables.


- `SPRING_DATASOURCE_PASSWORD`: Contraseña del usuario utilizado para la conexión con la base de datos.
- `SPRING_DATASOURCE_URL`: Es la cadena de conexión completa hacia la base de datos.
- `SPRING_DATASOURCE_USERNAME`: El usuario con el que la aplicación se conectará con la base de datos.

### Ejecución en modo local

Luego de configurar las variables de entorno, puede ejecutar el proyecto desde la línea de comandos en el directorio root de la siguiente forma:

```shell
mvn spring-boot:run
```

### Ejecución desde el IDE

Cada entorno de desarrollo ofrece su propia forma de ejecutar el proyecto.
En IntelliJ basta con hacer clic en el icono de "play" ▶️ que aparece al lado de la clase principal del proyecto [TechnicalTestApplication.java](src/main/java/com/titamedia/challenge/TechnicalTestApplication.java).

Una ventaja adicional de ejecutar el proyecto desde el IDE es la posibilidad de realizar la ejecución en modo depuración
para realizar seguimiento paso a paso y ver cómo se comportan los valores dentro de las variables en tiempo de ejecución.


El siguiente comando compilará el proyecto y permitirá generar el archivo jar ejecutable.
```shell
mvn clean package
```