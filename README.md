# TITA Backend Challenge
Prueba técnica para TITA MEDIA  
Realizar una aplicación que le permite a un cliente pagar las deudas que posee con sus bancos, se deben soportar las siguientes necesidades:
* Se debe mostrar el listado de bancos que tiene el usuario.
* Se debe mostrar el listado de deudas según el banco seleccionado.
* Permitir al cliente pagar la deuda.

#### Aspectos Funcionales

* Debe permitir al usuario ver el listado de sus bancos.
* El sistema debe permitir al usuario seleccionar un Banco y mostrar las deudas que posee en ese banco.
* El sistema debe permitir al usuario seleccionar una deuda y mostrar cuánto ha pagado, cuando cuotas debe, cuanto es el dinero total que debe.
* El sistema debe permitir al usuario pagar una deuda, el usuario podrá indicar cuantas cuotas quiere pagar o si quiere pagar su deuda en su totalidad. Posteriormente el sistema debe actualizar para mostrar el nuevo saldo que debe, cuántas cuotas debe o si la deuda ya fue cancelada.

### Tecnologías
A continuación, se describen las tecnologías utilizadas en la aplicación:

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Java JDK 17](https://jdk.java.net/17/)
* [Apache Maven](https://maven.apache.org/)
* [Project Lombok](https://www.projectlombok.org/)
* [liquibase](https://www.liquibase.org/)
* [Mapstruct](https://mapstruct.org/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Características

La aplicación ofrece los siguientes endpoints a través de un API REST.

* Endpoint para listar los usuarios existentes en la aplicación
* Endpoint para listar los bancos existentes en la aplicación
* Endpoint para consultar las deudas que tiene un usuario específico
* Endpoint para listar las deudas que tiene un usuario con un banco específico
* Endpoint para ver el detalle de la deuda de un usuario y un banco específico
* Endpoint para pagar cuotas o la deuda en su totalidad que tiene un usuario con un banco específico

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

## Generar el archivo ejecutable

El siguiente comando compilará el proyecto y permitirá generar el archivo jar ejecutable.
```shell
mvn clean package
```
La aplicación se puede ejecutar con el siguiente comando:
```shell
java -jar technical_test-0.0.1-SNAPSHOT.jar
```