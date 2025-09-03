# Hospital Management System

A Spring Boot REST API application for managing **appointments**, **doctors**, **patients**, and **bills**. This project uses **Spring Boot**, **Spring Data JPA**, and **MySQL**, allowing CRUD operations with a clean and professional service layer design.

---

## Features

* **CRUD for Appointments**

  * Create, read, update, and delete appointments
  * Track appointment date, doctor, and patient
* **CRUD for Doctors**

  * Add, update, view, and delete doctors
* **CRUD for Patients**

  * Add, update, view, and delete patients
* **Service Layer Handling**

  * Each entity has a dedicated service with proper error handling
* **Repository Layer**

  * Spring Data JPA repositories for all entities
* **Exception Handling**

  * Graceful error handling in the service layer
* **Postman-ready API**

  * Supports JSON requests/responses for all endpoints

---

## Technology Stack

| Layer       | Technology                 |
| ----------- | -------------------------- |
| Backend     | Spring Boot                |
| Persistence | Spring Data JPA, Hibernate |
| Database    | MySQL                      |
| Build Tool  | Maven/Gradle               |
| API Testing | Postman                    |
| Language    | Java 21+                   |

---

## Table of Contents

* [Getting Started](#getting-started)
* [Database Setup](#database-setup)
* [Running the Application](#running-the-application)
* [Example Requests](#example-requests)

---

## Getting Started

1. **Clone the repository:**

```bash
git clone https://github.com/Jai-Anand-JA/Hospital-Management-System.git
cd Hospital Management System
```

2. **Configure database connection** in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Build and run the application:**

```bash
./mvnw spring-boot:run
```

or using Gradle:

```bash
./gradlew bootRun
```

---

## Database Setup

1. Create a MySQL database:

CREATE DATABASE hospital_db;

---

## Example JSON Requests

### Create Appointment

```json
{
    "doctorId": 1,
    "patientId": 1,
    "date": "1/9/25"
}
```

### Create Doctor

```json
{
    "name": "Dr. John Doe",
    "specialization": "Cardiology",
    "email": "john@example.com",
    "phone": "9876543210"
}
```

### Create Patient

```json
{
    "name": "Jane Smith",
    "age": 30,
    "gender": "Female",
    "email": "jane@example.com",
    "phone": "9876543210"
}
```

---

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add feature'`)
4. Push to the branch (`git push origin feature-name`)
5. Open a Pull Request

---

## Author

- Jai Anand
