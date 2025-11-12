-- Quick database check queries
-- Run these in MySQL Workbench or command line

-- Show all databases
SHOW DATABASES;

-- Use fullstack database
USE fullstack;

-- Show all tables
SHOW TABLES;

-- Show table structure
DESCRIBE users;

-- Show all users (without passwords)
SELECT id, name, email FROM users;

-- Count total users
SELECT COUNT(*) as total_users FROM users;
