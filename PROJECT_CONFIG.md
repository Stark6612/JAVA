# Project Configuration Details

## Database Configuration

### MySQL Connection
- **Host:** localhost
- **Port:** 3306
- **Database Name:** fullstack
- **Username:** root
- **Password:** NewRootPass!23

### JDBC URL
```
jdbc:mysql://localhost:3306/fullstack?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
```

### Environment Variables (for deployment)
```bash
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/fullstack?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=NewRootPass!23
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SERVER_PORT=8080
```

## Backend Configuration

### Spring Boot Application
- **Port:** 8080
- **Base URL:** http://localhost:8080
- **API Endpoints:**
  - POST `/api/auth/register` - User registration
  - POST `/api/auth/login` - User login

### application.properties
```properties
# MySQL datasource
spring.datasource.url=jdbc:mysql://localhost:3306/fullstack?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=NewRootPass!23
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Server settings
server.port=8080

# Disable H2 console
spring.h2.console.enabled=false
```

### Start Backend
```cmd
cd backend
mvn spring-boot:run
```

## Frontend Configuration

### React Application
- **Port:** 3000
- **Base URL:** http://localhost:3000
- **API Base URL:** http://localhost:8080

### Environment Variables (.env.local)
```bash
REACT_APP_API_URL=http://localhost:8080
```

### Start Frontend
```cmd
cd frontend
npm install
npm start
```

## Database Schema

### Users Table
```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
```

## MySQL Commands

### Check Database
```sql
USE fullstack;
SHOW TABLES;
DESCRIBE users;
SELECT id, name, email FROM users;
```

### Command Line Access
```cmd
mysql -u root -pNewRootPass!23
```

## Project Structure

```
fullstack-lab/
├── backend/
│   ├── src/main/
│   │   ├── java/com/example/auth/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── entity/
│   │   │   ├── dto/
│   │   │   └── config/
│   │   └── resources/
│   │       └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── App.js
│   │   ├── Login.js
│   │   ├── Register.js
│   │   └── index.js
│   ├── package.json
│   └── .env.local
└── README.md
```

## Security

### Password Encryption
- **Algorithm:** BCrypt
- **Strength:** Default (10 rounds)

### CORS Configuration
- **Allowed Origins:** http://localhost:3000
- **Allowed Methods:** GET, POST, PUT, DELETE, OPTIONS
- **Allowed Headers:** *
- **Credentials:** true

## Login Response Messages

### Success
- **Status:** 200 OK
- **Message:** "Welcome, [Username]!"

### User Not Found
- **Status:** 404 NOT FOUND
- **Message:** "User not registered. Please sign up first."

### Wrong Password
- **Status:** 401 UNAUTHORIZED
- **Message:** "Wrong password. Please try again."

## Quick Start Guide

1. **Start MySQL Server**
   - Ensure MySQL is running on port 3306

2. **Start Backend**
   ```cmd
   cd backend
   mvn spring-boot:run
   ```

3. **Start Frontend**
   ```cmd
   cd frontend
   npm start
   ```

4. **Access Application**
   - Open browser: http://localhost:3000
   - Register: http://localhost:3000/register
   - Login: http://localhost:3000/login

## Troubleshooting

### Backend won't start
- Check if MySQL is running
- Verify database credentials
- Ensure port 8080 is available

### Frontend can't connect
- Verify backend is running on port 8080
- Check CORS configuration
- Verify API URL in .env.local

### Database connection error
- Verify MySQL credentials
- Check if database 'fullstack' exists
- Ensure MySQL is running on port 3306
