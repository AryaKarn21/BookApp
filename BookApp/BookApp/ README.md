# BookApp - REST API with Comprehensive Testing

![Test Coverage](coverage-screenshot.png)

## Overview
A Spring Boot REST API for managing books with comprehensive unit and API testing.
Achieved **92% test coverage** across all layers.

## Tech Stack
- **Backend**: Java 17, Spring Boot 3.5
- **Database**: MySQL
- **Testing**: JUnit 5, Mockito, Spring MVC Test, Jacoco
- **Build Tool**: Maven
- **Other**: Lombok, Spring Data JPA

## API Endpoints
| Method | Endpoint          | Description                |
|--------|-------------------|----------------------------|
| POST   | /api/books        | Create a new book          |
| GET    | /api/books        | Get all books              |
| GET    | /api/books/{id}   | Get a book by ID           |
| PUT    | /api/books/{id}   | Update a book              |
| DELETE | /api/books/{id}   | Delete a book              |

## Getting Started

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.8+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/bookapp.git
   cd bookapp
   ```

2. Configure database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/book
   spring.datasource.username=root
   spring.datasource.password=Arya@123
   ```

3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```

### Running Tests
```bash
mvn test
```

### Viewing Test Coverage
After running tests, open:
```
target/site/jacoco/index.html
```

## Testing Framework
- **Unit Testing**: JUnit 5, Mockito
- **API Testing**: Spring MVC Test (MockMvc)
- **Coverage**: Jacoco
- **Assertions**: Hamcrest

## Test Coverage
Achieved **92%** overall test coverage:
- Controller: 95%
- Service: 90%
- Repository: 85%
- Model: 100%

![Test Coverage Report](coverage-screenshot.png)

## Learning Experience
Through this project, I learned:
1. How to write comprehensive API tests with MockMvc
2. The importance of testing edge cases and error scenarios
3. How to achieve high test coverage with Jacoco
4. Best practices for REST API testing
5. The value of test-driven development (TDD) in building robust APIs

Challenges included setting up proper test isolation and handling database transactions in tests.
The triumph was achieving 92% test coverage with meaningful tests that validate real business logic.

### Tips for Good Test Coverage
1. Start with unit tests for core business logic
2. Write integration tests for API endpoints
3. Test both success and failure scenarios
4. Use code coverage as a guide, not a target
5. Refactor tests along with code changes