# Employee & Department Management System

A RESTful Spring Boot application for managing Employees and Departments. The application provides APIs to perform CRUD operations on employees and departments, along with validation, exception handling, DTO mapping, and database persistence.

## Features

* Create, Read, Update, and Delete Employees
* Create, Read, Update, and Delete Departments
* RESTful API design
* DTO-based architecture
* Entity-DTO mapping using ModelMapper
* Global Exception Handling
* Input Validation
* Spring Data JPA integration
* H2 Database support
* Maven-based project structure

## Tech Stack

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* ModelMapper
* Lombok
* Maven

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── org.premanshuray
│   │       ├── controllers
│   │       ├── services
│   │       ├── repositories
│   │       ├── entities
│   │       ├── dto
│   │       ├── advices
│   │       ├── exceptions
│   │       └── configs
│   └── resources
│       └── application.properties
└── test
```

## API Endpoints

### Employee APIs

| Method | Endpoint        | Description        |
| ------ | --------------- | ------------------ |
| GET    | /employees      | Get all employees  |
| GET    | /employees/{id} | Get employee by ID |
| POST   | /employees      | Create employee    |
| PUT    | /employees/{id} | Update employee    |
| DELETE | /employees/{id} | Delete employee    |

### Department APIs

| Method | Endpoint          | Description          |
| ------ | ----------------- | -------------------- |
| GET    | /departments      | Get all departments  |
| GET    | /departments/{id} | Get department by ID |
| POST   | /departments      | Create department    |
| PUT    | /departments/{id} | Update department    |
| DELETE | /departments/{id} | Delete department    |

## Sample Employee Request

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "salary": 50000,
  "designation": "Software Engineer"
}
```

## Sample Department Request

```json
{
  "title": "Information Technology",
  "isActive": true
}
```

## Running the Project

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate to Project

```bash
cd EmployeeManagementSystem
```

### Run Application

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## H2 Database Console

```text
http://localhost:8080/h2-console
```

Use the database credentials configured in `application.properties`.

## Future Improvements

* Authentication & Authorization using Spring Security
* JWT-based login system
* Pagination and Sorting
* Search and Filtering APIs
* Swagger/OpenAPI Documentation
* Unit & Integration Testing

## Author

**Premanshu Ray**

Software Engineer

