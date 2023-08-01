## API documentation
- [https://documenter.getpostman.com/view/16381907/2s93sgVVCy](https://documenter.getpostman.com/view/26303872/2s9XxvSuX6)
  
## Requirements

- Java Development Kit (JDK) 11 or later
- Gradle 6.0 or later
- PostgreSQL 9.6 or later
 


## Dependencies

The project uses the following dependencies:

- `spring-boot-starter-data-jpa` for easier use of JPA and Hibernate for database operations.
- `spring-boot-starter-web` to facilitate web development in a Spring Boot project, used for creating REST APIs.
- `spring-boot-starter-validation` to facilitate data validation processes in Spring Boot projects.
- `lombok` to help reduce boilerplate code in Java classes.
- `postgresql` for interacting with PostgreSQL databases, includes the PostgreSQL JDBC driver.
- `mapstruct` for automating the mapping of Java beans.

## Configuration

### PostgreSQL Database

1. Install PostgreSQL and create a database named 'EnocaDB'.
2. Create a user with the username 'postgres' and a password of your choosing. Enter this password in the `application.yml` file replacing `${PasswordPostgres}`.

### `application.yml` File

Database connection details are specified in the `src/main/resources/application.yml` file.

### Java and Gradle Installation

Ensure that Java and Gradle are installed correctly.

### Running the Application

./gradlew bootRun
