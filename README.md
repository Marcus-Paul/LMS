# 📘 Library Management System  
A Java-based Library Management System built with JDBC and MySQL, designed to handle operations like managing books, members, reservations, transactions, and late fees. The project uses DAO and Factory design patterns for modular and maintainable architecture.

---

## 🚀 Features  
- 📚 Manage Books, Authors, and Categories  
- 👤 Member Registration & Membership Expiry  
- 🔄 Issue & Return Books with Due Date Logic  
- 🕒 Scheduled Events: Auto-expiry, Late Fee Calculation  
- 📦 SQL Triggers for Stock Updates and Reservation Rules  
- 🔐 Basic Role-Based Authentication with Login System  

---

## 🧱 Tech Stack  
- Java 8+  
- JDBC  
- MySQL 8.x  
- Hibernate ORM (migration in progress)  
- SQL Triggers, Events  
- DAO Pattern, MVC-style layering  

---

## 🗃️ Database Design  
The system uses a normalized relational schema with:

- Foreign key constraints for referential integrity  
- Triggers for reservation, return, and late fee automation  
- Events for daily membership status updates  

---

## 🔐 Authentication  
- Basic email-password login system using plain text credentials  
- Role-Based Access Control (RBAC) with `ADMIN` and `MEMBER` roles  
- Admins have full access to CRUD operations  
- Members have limited access: view, search, and reserve books  
- ⚠️ Passwords are not hashed (planned improvement)  

---

## 🔄 Ongoing Improvements  
- 🔄 Migrating JDBC DAO layer to Hibernate with JPA annotations  
- 🔧 Rewriting manual queries with HQL and Criteria API  
- 🧪 Planning Spring Boot REST API integration  
- 🧠 Moving business logic for books, authors, and members into dedicated service classes  

---

## ⚙️ Setup Instructions  
1. Clone the repository  
2. Import SQL files from `sql/` into MySQL  
3. Update DB credentials in `DBConnection.java` or `hibernate.cfg.xml`  
4. Run `Main.java`  

---

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


---

## 📌 Planned Features  

### Admin-only Book Management  
- The system will implement **basic role-based access control (RBAC)** with `ADMIN` and `MEMBER` roles.  
- Only admins will be able to add new books; members will have view-only access.  
- Since this is a **console-based project**, user roles and permissions will be managed through simple login checks and menu options.  

---

## 🧑‍💻 Developer Note  
This is one of my first major projects, and I’m focusing on building strong core functionality while learning Java, JDBC, and backend architecture step-by-step.




## 👨💻 Author

**Marcus Paul V**  
[LinkedIn](www.linkedin.com/in/marcus-paul-v-165b31219)  
[GitHub](https://github.com/Marcus-Paul)


