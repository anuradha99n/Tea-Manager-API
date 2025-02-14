# Tea Manager API

The Tea Manager API is designed to manage and streamline the operations of small-scale tea plantations. It provides functionalities for managing employees, recording tea picking data, tracking pricing details, and calculating salaries for employees based on their work.

## Features

- **Employee Management**: Add, update, and manage employee details.
- **Tea Picking Records**: Record daily tea picking data for employees.
- **Pricing Management**: Set and manage price per kilo details with effective date ranges.
- **Salary Calculation**: Automatically calculate and save salaries based on tea picking data and pricing details.

## Tech Stack

- **Backend**: Spring Boot (Java)
- **Database**: MySQL

[//]: # (- **Testing**: Playwright &#40;for API testing&#41;)
- **Build Tool**: Maven

---

## Installation and Setup

### Prerequisites

- Java 17 or later
- Maven
- MySQL
- Git

### Clone the Repository

```bash
$ git clone https://github.com/YourUsername/TeaManagerAPI.git
$ cd TeaManagerAPI
```

### Configure the Database

1. Create a new MySQL database:
   ```sql
   CREATE DATABASE tea_manager;
   ```
2. Update the database connection details in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tea_manager
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

### Build and Run the Application

1. Build the project:
   ```bash
   $ mvn clean install
   ```
2. Run the application:
   ```bash
   $ mvn spring-boot:run
   ```

---

## Project Structure

```
TeaManagerAPI/
|│   pom.xml                  # Maven configuration
|└── src/
    |└── main/
    |    |└── java/com/teamanager/
    |    |         |└── controllers/  # REST Controllers
    |    |         |└── services/     # Business Logic
    |    |         |└── models/       # Entities
    |    |         |└── repositories/ # JPA Repositories
    |    |└── resources/
    |         application.properties # Configuration
    |└── test/
          |└── playwright/          # API Test Scripts
```

---

[//]: # (## Usage)

[//]: # ()
[//]: # (### Example Salary Calculation)

[//]: # ()
[//]: # (1. Add an employee:)

[//]: # (   ```json)

[//]: # (   POST /api/employees)

[//]: # (   {)

[//]: # (     "name": "John Doe",)

[//]: # (     "role": "Picker")

[//]: # (   })

[//]: # (   ```)

[//]: # (2. Add a tea picking record:)

[//]: # (   ```json)

[//]: # (   POST /api/tea-picking-records)

[//]: # (   {)

[//]: # (     "employeeId": 1,)

[//]: # (     "weightPicked": 25,)

[//]: # (     "date": "2025-01-01")

[//]: # (   })

[//]: # (   ```)

[//]: # (3. Set price per kilo:)

[//]: # (   ```json)

[//]: # (   POST /api/price-per-kilo)

[//]: # (   {)

[//]: # (     "pricePerKilo": 100,)

[//]: # (     "effectiveDate": "2025-01-01",)

[//]: # (     "endDate": "2025-01-31")

[//]: # (   })

[//]: # (   ```)

[//]: # (4. Generate salary:)

[//]: # (   ```json)

[//]: # (   POST /api/salary/generate)

[//]: # (   {)

[//]: # (     "employeeId": 1,)

[//]: # (     "year": 2025,)

[//]: # (     "month": "JANUARY")

[//]: # (   })
[//]: # (   ```)

[//]: # (---)

[//]: # (## Running Tests)

[//]: # ()
[//]: # (### Prerequisites)

[//]: # ()
[//]: # (- Node.js and npm &#40;for Playwright&#41;)

[//]: # ()
[//]: # (### Install Playwright)

[//]: # ()
[//]: # (```bash)

[//]: # ($ npm install playwright)

[//]: # (```)

[//]: # ()
[//]: # (### Run Tests)

[//]: # ()
[//]: # (```bash)

[//]: # ($ npx playwright test)

[//]: # (```)