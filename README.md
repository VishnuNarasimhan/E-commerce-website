# 🛒 E-Commerce Microservices Platform

This is a production-grade, scalable, and cloud-deployable **E-Commerce Platform** developed using Spring Boot Microservices architecture. It mimics real-world systems like Amazon and Flipkart, offering functionalities such as product browsing, user authentication, order placement, and simulated payment integration.

---

## 🚀 Tech Stack

| Layer               | Technologies Used                                           |
|---------------------|-------------------------------------------------------------|
| **Backend**         | Java, Spring Boot, Spring Data JPA, Spring Security         |
| **Microservices**   | Product Catalog, User Management, Order, Payment, API Gateway |
| **Service Registry**| Eureka (Netflix OSS)                                        |
| **Database**        | MySQL (RDS)                                                 |
| **Caching**         | Redis (Elasticache)                                         |
| **Security**        | JWT Token Authentication                                    |
| **Deployment**      | Docker, AWS EC2, RDS, Elasticache, VPC, Security Groups     |

---

## 🧩 Microservices Overview

### 1. **User Management Service**
Handles user registration, login, role-based access, and JWT-based authentication.

- `User`: username, email, password (hashed), createdAt
- `Role`: USER / ADMIN
- JWT token generation & validation
- Endpoints:
  - `POST /register`
  - `POST /login`
  - `GET /user/me`

---

### 2. **Product Catalog Service**
Provides CRUD operations for products and category-based filtering.

- `Product`: productId, name, price, description, category
- `Category`: categoryId, name
- Redis Caching for product search
- Endpoints:
  - `GET /products`
  - `POST /products`
  - `GET /products/category/{id}`

---

### 3. **Order Service**
Handles cart management, order creation, and order status tracking.

- `Order`: user, orderItems, totalAmount, createdAt
- `OrderItem`: product, quantity, price
- Endpoints:
  - `POST /orders`
  - `GET /orders/user/{id}`

---

### 4. **Payment Service**
Mocks a simple payment process tied to order placement.

- `Payment`: orderId, amount, status
- Endpoints:
  - `POST /payments`

---

### 5. **API Gateway**
Unified entry point for all services. Routes external traffic to appropriate microservices using **Spring Cloud Gateway**.

---

### 6. **Service Discovery**
Uses **Eureka Server** for registering and discovering microservices dynamically.

---

## 🧠 Redis Caching Strategy

- Used for product search and category listing
- Redis key format: `search::<query>`
- Time-to-live (TTL): 5 minutes
- Improves performance by reducing DB hits
- Cache is updated if DB is hit on cache-miss

---

## 🗃️ Database Schema (MySQL)

- `users`, `roles`, `products`, `categories`, `orders`, `order_items`, `payments`
- Many-to-one: Product → Category, Order → User
- One-to-many: Order → OrderItem, User → Token
- Tokens used for tracking sessions

---

## 🌐 Deployment (AWS)

- Services are containerized using Docker
- Hosted on EC2 instances behind a Load Balancer
- Redis on AWS Elasticache
- Database on AWS RDS (MySQL)
- Secured using Security Groups and VPC
- Environment variables managed via `application.yml`

---

## ⚙️ Running Locally

### Prerequisites
- Java 17+
- Maven or Gradle
- Docker
- Redis
- MySQL
- Eureka server running

### Steps

```bash
# Start Eureka Server
cd eureka-server
./mvnw spring-boot:run

# Start API Gateway
cd api-gateway
./mvnw spring-boot:run

# Start User Service
cd user-service
./mvnw spring-boot:run

# Start Product Service
cd product-service
./mvnw spring-boot:run

# Start Order Service
cd order-service
./mvnw spring-boot:run

# Start Payment Service
cd payment-service
./mvnw spring-boot:run
