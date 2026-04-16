# 🧩 Microservices Architecture — Spring Boot

> Built by **Karthik** | Java Backend Developer

This project demonstrates a production-grade
microservices architecture using Spring Boot
and Spring Cloud.

## 🧩 Services

| Service | Port | Description |
|---------|------|-------------|
| Eureka Server | 8761 | Service Discovery |
| API Gateway | 8080 | Single entry point |
| User Service | 8081 | User management |
| Product Service | 8082 | Product catalog |
| Order Service | 8083 | Order processing |

## ⚙️ Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Cloud (Eureka, Gateway, Feign)
- MySQL (separate DB per service)
- Docker & Docker Compose
- Lombok

## 🚀 Features
- ✅ Microservices architecture
- ✅ Service discovery using Eureka
- ✅ API Gateway routing
- ✅ Inter-service communication (Feign)
- ✅ Independent databases per service
- ✅ Docker containerized

## 🏃 Run the Project

### Option 1: Docker (Recommended)
\`\`\`bash
docker-compose up --build
\`\`\`

### Option 2: Manual
\`\`\`bash
# Start in this order:
1. cd eureka-server && mvn spring-boot:run
2. cd api-gateway && mvn spring-boot:run
3. cd user-service && mvn spring-boot:run
4. cd product-service && mvn spring-boot:run
5. cd order-service && mvn spring-boot:run
\`\`\`

## 📡 API Endpoints

### Users (via Gateway)
\`\`\`
GET    http://localhost:8080/api/users
POST   http://localhost:8080/api/users
GET    http://localhost:8080/api/users/{id}
PUT    http://localhost:8080/api/users/{id}
DELETE http://localhost:8080/api/users/{id}
\`\`\`

### Products (via Gateway)
\`\`\`
GET    http://localhost:8080/api/products
POST   http://localhost:8080/api/products
GET    http://localhost:8080/api/products/{id}
PUT    http://localhost:8080/api/products/{id}
DELETE http://localhost:8080/api/products/{id}
\`\`\`

### Orders (via Gateway)
\`\`\`
POST   http://localhost:8080/api/orders/place
GET    http://localhost:8080/api/orders
GET    http://localhost:8080/api/orders/{id}
GET    http://localhost:8080/api/orders/user/{userId}
PUT    http://localhost:8080/api/orders/{id}/status
\`\`\`

## 👨‍💻 Author
**Karthik** — Java Backend Developer
- 6 years Java & Spring Boot experience
- Specializing in Microservices & REST APIs
- Available for freelance projects

📧 Deepkaras2009@gmail.com
