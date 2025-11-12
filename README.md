# Fullstack Authentication Application

A fullstack authentication system with React frontend and Spring Boot backend.

## 🌐 Live Demo

**Frontend:** https://Stark6612.github.io/JAVA

**Note:** Backend runs locally. Login/Register only works when backend is running on your machine.

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven
- Node.js & npm
- MySQL 8.0

### 1. Start MySQL Database

Ensure MySQL is running with:
- Database: `fullstack`
- Username: `root`
- Password: `NewRootPass!23`

### 2. Start Backend

```cmd
cd backend
mvn spring-boot:run
```

Backend runs on: http://localhost:8080

### 3. Start Frontend (Development)

```cmd
cd frontend
npm install
npm start
```

Frontend runs on: http://localhost:3000

## 📦 Deploy Frontend to GitHub Pages

```cmd
cd frontend
npm install --save-dev gh-pages
npm run deploy
```

Visit: https://Stark6612.github.io/JAVA

## 📁 Project Structure

```
fullstack-lab/
├── backend/                 # Spring Boot backend
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       └── resources/
│   └── pom.xml
├── frontend/                # React frontend
│   ├── src/
│   │   ├── App.js
│   │   ├── Login.js
│   │   └── Register.js
│   └── package.json
└── README.md
```

## 🔧 Configuration

### Database
- **Host:** localhost:3306
- **Database:** fullstack
- **Username:** root
- **Password:** NewRootPass!23

### Ports
- **Backend:** 8080
- **Frontend (dev):** 3000
- **Frontend (prod):** GitHub Pages

## 📚 Documentation

- **Setup Guide:** [SETUP.md](SETUP.md)
- **GitHub Pages Deployment:** [GITHUB_PAGES_DEPLOY.md](GITHUB_PAGES_DEPLOY.md)
- **Project Configuration:** [PROJECT_CONFIG.md](PROJECT_CONFIG.md)

## ✨ Features

- User registration with email validation
- User login with password verification
- Specific error messages:
  - "Welcome, [Username]!" on successful login
  - "Wrong password" for incorrect password
  - "User not registered" for unregistered email
- Password encryption with BCrypt
- CORS configured for GitHub Pages
- MySQL database integration

## 🛠️ Technologies

**Frontend:**
- React 19
- React Router DOM
- Fetch API

**Backend:**
- Spring Boot 3.1.4
- Spring Data JPA
- MySQL
- BCrypt Password Encoder

## 📝 API Endpoints

- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - Login user

## 🔒 Security

- Passwords encrypted with BCrypt
- CORS configured for localhost and GitHub Pages
- Input validation on both frontend and backend

## 🐛 Troubleshooting

### Backend won't start
- Check if MySQL is running
- Verify database credentials in `application.properties`
- Ensure port 8080 is available

### Frontend can't connect
- Verify backend is running on port 8080
- Check browser console for errors
- Ensure CORS is configured

### Database errors
- Verify MySQL is running
- Check if database `fullstack` exists
- Verify credentials are correct

## 📄 License

This project is for educational purposes.

## 👤 Author

**Stark6612**
- GitHub: [@Stark6612](https://github.com/Stark6612)
- Repository: [JAVA](https://github.com/Stark6612/JAVA)
