# 🌱 Spring Boot Web Basics

A clean, beginner-friendly REST API built with **Spring Boot**, demonstrating the fundamentals of backend development — MVC architecture, JPA, and full CRUD operations with MySQL.

---

## 🚀 Features

- RESTful API with full CRUD support
- MVC architecture (Controller → Service → Repository)
- Spring Data JPA + Hibernate ORM
- MySQL database integration
- JSON request & response handling
- Global exception handling with meaningful error responses
- Bean Validation (JSR-380) on request bodies
- Structured logging

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| ORM | Spring Data JPA / Hibernate |
| Database | MySQL 8 |
| Build Tool | Maven |
| Validation | Jakarta Bean Validation |
| Testing | JUnit 5 + Mockito |

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com/example/app/
    │       ├── controller/       # REST controllers (HTTP layer)
    │       ├── service/          # Business logic
    │       ├── repository/       # JPA repositories (DB layer)
    │       ├── model/            # JPA entities
    │       ├── dto/              # Request/Response DTOs
    │       └── exception/        # Global exception handler
    └── resources/
        ├── application.properties
        └── application-dev.properties
```

---

## ⚙️ Setup Instructions

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8+

### 1. Clone the Repository

```bash
git clone https://github.com/Minokainduwara/springboot-web-basics.git
cd springboot-web-basics
```

### 2. Create the Database

```sql
CREATE DATABASE springboot_db;
```

### 3. Configure `application.properties`

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# App
server.port=8080
```

> ⚠️ Never commit real credentials. Use environment variables or a `.env` file in production.

### 4. Run the Application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## 📡 API Endpoints

### Base URL: `/api/users`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `GET` | `/api/users` | Get all users | 200 OK |
| `GET` | `/api/users/{id}` | Get user by ID | 200 OK / 404 Not Found |
| `POST` | `/api/users` | Create a new user | 201 Created |
| `PUT` | `/api/users/{id}` | Update an existing user | 200 OK / 404 Not Found |
| `DELETE` | `/api/users/{id}` | Delete user by ID | 204 No Content |

---

## 🧪 Example Usage

### Create a User — `POST /api/users`

**Request:**
```json
{
  "name": "John Doe",
  "email": "john@example.com"
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com"
}
```

### Validation Error — `POST /api/users` (missing email)

**Response:** `400 Bad Request`
```json
{
  "timestamp": "2025-04-15T10:30:00",
  "status": 400,
  "errors": {
    "email": "Email is required"
  }
}
```

### Not Found — `GET /api/users/99`

**Response:** `404 Not Found`
```json
{
  "timestamp": "2025-04-15T10:30:00",
  "status": 404,
  "message": "User not found with id: 99"
}
```

---

## 🧱 Key Implementation Notes

### DTO Pattern
Request and response bodies use separate DTO classes to decouple the API surface from JPA entities. This prevents over-posting and gives you full control over what gets exposed.

### Global Exception Handling
`@ControllerAdvice` catches `ResourceNotFoundException` and `MethodArgumentNotValidException` and returns consistent JSON error responses.

### Bean Validation
Fields like `name` and `email` are validated using `@NotBlank` and `@Email` annotations on the DTO, validated automatically via `@Valid` in the controller.

---

## 🧪 Running Tests

```bash
mvn test
```

Tests cover:
- Service layer logic (unit tests with Mockito)
- Controller layer (slice tests with `@WebMvcTest`)

---

## 📌 Roadmap

- [ ] JWT-based authentication & authorization (Spring Security)
- [ ] Pagination and sorting for list endpoints
- [ ] Docker + Docker Compose setup
- [ ] Swagger / OpenAPI documentation
- [ ] CI/CD pipeline (GitHub Actions)
- [ ] Frontend integration (React)

---

## 🤝 Contributing

Contributions are welcome! To get started:

1. Fork this repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m "Add: your feature"`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

Please follow standard Java naming conventions and include tests for new features.

---

## 📄 License

This project is open-source under the [MIT License](LICENSE).

---

## 👨‍💻 Author

**Minokainduwara**
GitHub: [@Minokainduwara](https://github.com/Minokainduwara)