# Car Insurance Company System

A Java-based Object-Oriented Programming project that simulates a real-world car insurance management system.  
This application allows administrators and users to manage insurance policies, customers, vehicles, reports, and file operations through a console-based menu system.

---

## Features

### User Management
- Create new users
- Remove users
- Update user addresses
- Display user information
- Password-protected authentication system

### Insurance Policy Management
- Create Third Party Policies
- Create Comprehensive Policies
- Remove policies
- Filter policies by:
  - Car model
  - Expiry date

### Reports & Analytics
- Total premium payments by city
- Premium reports by car model
- User policy statistics
- Policy count per city
- Policy count per car model
- Average premium calculations

### Data Persistence
- Binary file save/load
- Text file save/load

### Object-Oriented Concepts Used
- Inheritance
- Polymorphism
- Encapsulation
- Abstraction
- Exception Handling
- Deep Copying / Cloning
- Collections Framework (`ArrayList`, `HashMap`)
- Custom Exceptions

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- File I/O
- Exception Handling

---

## Project Structure

```bash
src/
│
├── InsuranceCompany.java
├── User.java
├── InsurancePolicy.java
├── ThirdPartyPolicy.java
├── ComprehensivePolicy.java
├── Car.java
├── Address.java
├── MyDate.java
├── CarType.java
├── PolicyException.java
├── PolicyHolderNameException.java
└── Main.java
