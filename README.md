# Challenge-Literalura
https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.larazon.es%2Fcultura%2Fhombre-escribe-mas-90-libros-inteligencia-artificial-gana-fortuna_202306016478b08621debe000195c8bc.html&psig=AOvVaw382xYoGU0-c-Qhk7f7i-Yg&ust=1721261885577000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCOj5sq3mrIcDFQAAAAAdAAAAABAE


## Descripción del Proyecto

Literalura es una aplicación de gestión de libros y autores desarrollada como parte del programa ONE. Este sistema permite a los usuarios buscar, agregar y gestionar información sobre libros y sus autores, utilizando datos de una API externa y almacenándolos en una base de datos local.

## Características Principales

- Búsqueda de libros por título
- Listado de todos los libros y autores en la base de datos
- Filtrado de autores por año de vida
- Filtrado de libros por idioma
- Visualización de los libros más populares basados en descargas
- Interfaz de línea de comandos intuitiva

## Tecnologías Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- H2 Database (para desarrollo)
- Maven

## Instalación y Configuración

1. Clona el repositorio:

2. Navega al directorio del proyecto:
cd literalura

3. Compila el proyecto con Maven:
mvn clean install

4. Ejecuta la aplicación:
java -jar target/literalura-1.0.0.jar

## Uso

Al iniciar la aplicación, se presentará un menú con las siguientes opciones:

1. Buscar un libro por título
2. Listar todos los libros
3. Listar todos los autores
4. Buscar autores vivos en un año específico
5. Listar libros por idioma
6. Ver top 10 de libros más populares
7. Salir

Sigue las instrucciones en pantalla para navegar por las diferentes funcionalidades.

## Estructura del Proyecto

- `src/main/java/com/cursosalura/Literalura/`: Contiene el código fuente de la aplicación
- `controller/`: Controladores de la aplicación
- `model/`: Entidades y DTOs
- `repository/`: Interfaces de repositorio para acceso a datos
- `service/`: Lógica de negocio
- `util/`: Clases utilitarias
- `src/main/resources/`: Archivos de configuración
- `src/test/`: Pruebas unitarias y de integración

## Contacto
lacaro@ut.edu.co
