# Library APIs

## 📖 Table of Contents

- [🚀 Overview](#-overview)
- [🛠 Technologies \& Tools Used](#-technologies--tools-used)
- [🏁 Getting Started](#-getting-started)
- [📚 API Documentation](#-api-documentation)
- [💾 Database Schema (ERD)](#-database-schema-erd)

## 🚀 Overview

- Simple app which contains only two entities: Author and Books and some CRUD operations on Books.

## 🛠 Technologies & Tools Used

- Java 21
- Spring Boot 3.3.1
- Spring Data JPA (Hibernate ORM)
- MySQL (9.0.1)
- Maven
- Jasper Reports
- Flyway for database migrations

## 🏁 Getting Started

1. Clone the repository
2. Navigate to the project directory via `cd ./ffs-task`
3. Make sure you have Docker installed.
4. Run `docker-compose up --build`.
5. Access the application at `http://localhost:8080`

## 📚 API Documentation

A Postman collection can be accessed from [here](./Library.postman_collection.json) here. All you need to do is to import the collection.

## 💾 Database Schema (ERD)

- It's a tiny ERD but I did it anyway.
  ![Alt text](./Library%20ERD.png)
