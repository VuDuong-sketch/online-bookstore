# Online Bookstore

A full-stack web application for browsing and purchasing books.

The project is built with a separate frontend, backend, and database structure, providing a foundation for an online bookstore system.

## 📌 Overview

**Online Bookstore** is a web-based application that allows users to browse books and interact with the bookstore system through a modern frontend and RESTful backend.

The project is developed using a **Frontend – Backend – Database** architecture.

```text
┌─────────────────┐
│    Frontend     │
│     React       │
└────────┬────────┘
         │ HTTP / REST API
         ▼
┌─────────────────┐
│     Backend     │
│  Java / Spring  │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│    Database     │
│      MySQL      │
└─────────────────┘
```

## ✨ Features

### User

* User registration and login
* Browse available books
* View book details
* Manage shopping cart
* Place book orders
* View order information

### Book Management

* View book list
* View book details
* Add new books
* Update book information
* Delete books

> The available features may change as the project continues to be developed.

## 🛠️ Technologies

### Frontend

* React
* React Router
* HTML
* CSS
* Tailwind CSS

### Backend

* Java
* Spring Boot
* REST API
* JWT

### Database

* MySQL

### Development Tools

* Git
* GitHub
* Postman
* IntelliJ IDEA
* Visual Studio Code

## 📂 Project Structure

```text
online-bookstore/
│
├── backend/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── ...
│
├── database/
│   ├── ...
│   └── ...
│
└── README.md
```

### `backend/`

Contains the Spring Boot application, including:

* REST API
* Business logic
* Authentication and authorization
* Database access
* Security configuration

### `frontend/`

Contains the React application, including:

* User interface
* Page components
* Routing
* API integration
* Client-side state management

### `database/`

Contains database-related files such as:

* Database schema
* SQL scripts
* Sample data

## 🗄️ Database

The application uses **MySQL** as its relational database.

Main entities include:

```text
User
  │
  │
  └────── Order
            │
            │
            └──── OrderItem ───── Book
```

The database is designed to manage users, books, orders, and order items.

## ⚙️ Installation

### 1. Clone the repository

```bash
git clone https://github.com/VuDuong-sketch/online-bookstore

cd online-bookstore
```

### 2. Set up the database

Create a MySQL database and execute the SQL scripts located in the `database/` directory.

For example:

```sql
CREATE DATABASE online_bookstore;
```

Then configure the database connection in the backend configuration file.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/online_bookstore
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the Backend

Navigate to the backend directory:

```bash
cd backend
```

Run the Spring Boot application:

```bash
./mvnw spring-boot:run
```

Or run the main Spring Boot application directly from IntelliJ IDEA.

The backend will run on:

```text
http://localhost:8080
```

### 4. Run the Frontend

Open another terminal:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The frontend will normally be available at:

```text
http://localhost:5173
```

## 🔐 Authentication

The backend uses **JWT (JSON Web Token)** for authentication and authorization.

The general authentication flow is:

```text
User
  │
  ▼
Login
  │
  ▼
POST /auth/login
  │
  ▼
Backend verifies credentials
  │
  ▼
JWT Token
  │
  ▼
Frontend stores token
  │
  ▼
Token included in API requests
  │
  ▼
Token validated
```

## 📡 REST API

The backend provides RESTful APIs for communication between the frontend and backend.

Example API structure:

### Authentication

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| POST   | `/auth/register` | Register a new user |
| POST   | `/auth/login`    | User login          |

### Books

| Method | Endpoint      | Description    |
| ------ | ------------- | -------------- |
| GET    | `/books`      | Get all books  |
| GET    | `/books/{id}` | Get book by ID |
| POST   | `/books`      | Create a book  |
| PUT    | `/books/{id}` | Update a book  |
| DELETE | `/books/{id}` | Delete a book  |

### Orders

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| GET    | `/orders`      | Get orders        |
| GET    | `/orders/{id}` | Get order details |
| POST   | `/orders`      | Create an order   |

> Update the endpoints above to match the actual APIs implemented in the project.

## 🧪 API Testing

The REST APIs can be tested using **Postman**.

Example request:

```http
POST /auth/login
Content-Type: application/json
```

```json
{
  "username": "user",
  "password": "password"
}
```

Protected APIs require a valid JWT token:

```http
Authorization: Bearer <JWT_TOKEN>
```

## 📸 Screenshots

Screenshots of the application can be added here.

### Home Page

### Book Details

### Shopping Cart

### Login

> Create a `screenshots/` directory in the project root and place the corresponding images inside it.

## 🚧 Future Improvements

* Improve search and filtering
* Add pagination for book lists
* Improve order management
* Add automated testing
* Improve application security
* Add Docker support
* Deploy the application to a cloud environment

## 👨‍💻 Author

**Vu Duong**

GitHub: https://github.com/VuDuong-sketch
