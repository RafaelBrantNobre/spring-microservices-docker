# Spring Boot Microservices with Docker

A microservices architecture built with Spring Boot, Spring Cloud Netflix Eureka, and API Gateway — fully containerized with Docker.

## Architecture

```
                        ┌─────────────────┐
                        │   API Gateway   │
                        │   port: 8080    │
                        └────────┬────────┘
                                 │ routes via Eureka
                ┌────────────────┴────────────────┐
                │                                 │
       ┌────────┴────────┐              ┌─────────┴───────┐
       │  School Service │              │ Student Service  │
       │   port: 8082    │              │   port: 8081    │
       └────────┬────────┘              └────────┬────────┘
                │                                │
           ┌────┴────┐                     ┌─────┴────┐
           │  MySQL  │                     │ MongoDB  │
           └─────────┘                     └──────────┘

                    ┌──────────────────────┐
                    │  Service Registry    │
                    │  (Eureka)  port:8761 │
                    └──────────────────────┘
```

## Services

| Service | Port | Description |
|---|---|---|
| `service-registry` | 8761 | Eureka Service Discovery |
| `school-service` | 8082 | CRUD for schools (MySQL) |
| `student-service` | 8081 | CRUD for students (MongoDB), calls school-service |
| `api-gateway` | 8080 | Single entry point, routes via Eureka load balancer |

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Cloud (Eureka, Gateway)
- MySQL 8
- MongoDB 7
- Docker / Docker Compose

## Running with Docker (recommended)

```bash
# Clone the repo
git clone https://github.com/RafaelBrantNobre/spring-microservices-docker.git
cd spring-microservices-docker

# Build and start all containers
docker compose up --build -d

# Check running containers
docker compose ps

# Stop everything
docker compose down
```

## Running locally (without Docker)

Make sure MySQL and MongoDB are running locally, then start each service in order:

```bash
# 1. Service Registry (Eureka)
cd service-registry && ./mvnw spring-boot:run

# 2. School Service
cd school.service && ./mvnw spring-boot:run

# 3. Student Service
cd student.service && ./mvnw spring-boot:run

# 4. API Gateway
cd api-gateway && ./mvnw spring-boot:run
```

## API Endpoints (via Gateway on port 8080)

### School
| Method | URL | Body |
|---|---|---|
| GET | `/school` | — |
| POST | `/school` | `{"schoolName":"...", "location":"...", "principalName":"..."}` |
| GET | `/school/{id}` | — |

### Student
| Method | URL | Body |
|---|---|---|
| GET | `/student` | — |
| POST | `/student` | `{"studentName":"...", "age":20, "schoolId":1}` |
| GET | `/student/{id}` | — |

The `GET /student/{id}` response includes the full school data joined from school-service.

## Eureka Dashboard

Access [http://localhost:8761](http://localhost:8761) to see all registered services.
