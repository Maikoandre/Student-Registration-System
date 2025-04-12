# Student Registration System

![Java](https://img.shields.io/badge/Java-21-blue)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)
![JDBC](https://img.shields.io/badge/JDBC-4.2-green)

A Java application for managing student records with MySQL database integration.

## Features

- 🎓 **CRUD Operations**:
  - Create, Read, Update, and Delete student records
- 🔗 **Database Integration**:
  - MySQL backend with JDBC connectivity
  - Connection pooling via `ConnectionFactory`
- 🏗 **MVC Architecture**:
  - Clear separation between:
    - Model (`Student` class)
    - DAO (`StudentDAO` class)
    - Application logic (`Main` class)

## Project Structure
StudentRegistrationSystem/<br>
├── bin/ # Compiled .class files<br>
├── resouces/ # Resource files<br>
│ ├── mysql-connector-j-9.2.0.jar<br>
│ └── script.sql # Database schema<br>
└── src/ # Java source code<br>
└── br/com/school/<br>
├── aplication/<br>
│ └── Main.java # Entry point<br>
├── dao/<br>
│ └── StudentDAO.java # Data access<br>
├── factory/<br>
│ └── ConnectionFactory.java<br>
└── model/<br>
└── Student.java # Data model<br>


## Technical Specifications

- **Java Version**: 21 (OpenJDK)
- **Database**: MySQL
- **Dependencies**:
  - MySQL Connector/J 9.2.0
- **Design Patterns**:
  - DAO (Data Access Object)
  - Factory Method (Connection creation)
