# Fullstack Application Setup Guide

## Prerequisites

### 1. Install MySQL
Download and install MySQL from: https://dev.mysql.com/downloads/installer/

**During installation:**
- Set root password to `root` (or update `backend/src/main/resources/application.properties` with your password)
- Make sure MySQL Server is running on port 3306

### 2. Create Database
After MySQL is installed, open MySQL Command Line or MySQL Workbench and run:

```sql
CREATE DATABASE fullstack;
```

Or use command line:
```cmd
mysql -u root -p
```
Then enter password and run:
```sql
CREATE DATABASE fullstack;
EXIT;
```

## Running the Application

### 1. Start Backend (Spring Boot)
```cmd
cd backend
mvnw spring-boot:run
```
Backend will run on: http://localhost:8080

### 2. Start Frontend (React)
Open a new terminal:
```cmd
cd frontend
npm install
npm start
```
Frontend will run on: http://localhost:3000

## Testing

1. Open browser to http://localhost:3000
2. Click "Register" and create an account
3. Click "Login" and sign in with your credentials

## Current Configuration

- **Database**: MySQL on localhost:3306
- **Database Name**: fullstack
- **Username**: root
- **Password**: root
- **Backend Port**: 8080
- **Frontend Port**: 3000

## Troubleshooting

### MySQL Connection Error
- Verify MySQL is running: Check Services (Windows) or Task Manager
- Verify database exists: `SHOW DATABASES;` in MySQL
- Check credentials in `backend/src/main/resources/application.properties`

### Backend Won't Start
- Make sure MySQL is running
- Make sure database `fullstack` exists
- Check if port 8080 is available

### Frontend Won't Start
- Run `npm install` in frontend directory
- Check if port 3000 is available
