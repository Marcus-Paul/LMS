# 📘 Library Management System

A Java-based Library Management System built with JDBC and MySQL, designed to handle operations like managing books, members, reservations, transactions, and late fees. The project uses DAO and Factory design patterns for modular and maintainable architecture.

## 🚀 Features

- 📚 Manage Books, Authors, and Categories
- 👤 Member Registration & Membership Expiry
- 🔄 Issue & Return Books with Due Date Logic
- 🕒 Scheduled Events: Auto-expiry, Late Fee Calculation
- 📦 SQL Triggers for Stock Updates and Reservation Rules

## 🧱 Tech Stack

- Java 8+
- JDBC
- MySQL 8.x
- Hibernate ORM (migration in progress)
- SQL Triggers, Events
- DAO Pattern, MVC-style layering

## 🗃️ Database Design

The system uses a normalized relational schema with:

- Foreign key constraints for referential integrity
- Triggers for reservation, return, and late fee automation
- Events for daily membership status updates

## 🔄 Ongoing Improvements

- 🔄 Migrating JDBC DAO layer to Hibernate with JPA annotations
- 🔧 Rewriting manual queries with HQL and Criteria API
- 🧪 Planning Spring Boot REST API integration


## ⚙️ Setup Instructions

1. Clone the repository
2. Import SQL files from `sql/` into MySQL
3. Update DB credentials in `DBConnection.java` or `hibernate.cfg.xml`
4. Run `Main.java`

## 📂 Folder Structure

LMS/
├── src/
│ ├── com/lms/DAO
│ ├── com/lms/DAOImpli
│ ├── com/lms/TableClassess
├── sql/
│ ├── Library management tables.sql
│ ├── Library Management Triggers.sql
│ ├── library management events.sql


## 👨💻 Author

**Marcus Paul V**  
[LinkedIn](www.linkedin.com/in/marcus-paul-v-165b31219)  
[GitHub](https://github.com/Marcus-Paul)


