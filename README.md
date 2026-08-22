# 🛒 Stationery Automation System

A **Java and MySQL-based desktop application** developed to manage the day-to-day operations of a stationery store, including **product management, inventory tracking, user operations, and sales transactions**.

The project combines a graphical desktop interface with a relational database, allowing store-related data to be managed through a structured and user-friendly system.

## 📌 About the Project

The Stationery Automation System was designed to bring common stationery store operations into a single application.

Instead of managing product, stock, and sales information separately, the system connects these operations through a **Java desktop interface backed by a MySQL database**.

Users can interact with the system through different application screens, while database operations are handled through a dedicated connection layer.

## ✨ Features

* 🔐 User registration and management
* 🛍️ Product management
* 🗂️ Category and brand management
* 📦 Inventory and stock tracking
* ➕ Adding new products
* ✏️ Updating product information
* 🗑️ Removing records
* 💰 Sales transaction management
* 🔍 Viewing stored product information
* 🗄️ Persistent data storage with MySQL
* 🖥️ Graphical desktop interface

## 🖥️ User Interface

The application uses a **Java Swing-based graphical interface**, providing separate screens for different operations.

The interface allows users to work with the system without interacting directly with the database.

Application screens include functionality related to:

* 🏠 Main application page
* 👤 User and registration operations
* 🛍️ Product operations
* 🗂️ Category and brand management
* 📦 Stock and inventory operations
* 💰 Sales processes

## 🗄️ Database Integration

The application communicates with a **MySQL relational database** to store and retrieve application data.

Database connectivity is handled through a dedicated helper structure, keeping database-related operations separate from the user interface and other application logic.

This structure allows changes made through the application to be reflected in the stored data.

## ⚙️ Application Flow

```text
┌─────────────────────┐
│        User         │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Java Swing GUI    │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Application Logic   │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│ Database Connection │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│        MySQL        │
└─────────────────────┘
```

## 🛠️ Technologies & Tools

* ☕ **Java**
* 🖥️ **Java Swing**
* 🗄️ **MySQL**
* 🔗 **JDBC**
* 💻 **NetBeans**
* 🧱 **Object-Oriented Programming (OOP)**
* 🔧 **Git & GitHub**

## 📂 Project Structure

The project is divided into different Java classes and GUI forms responsible for specific parts of the application.

For example:

```text
STATIONERY-AUTOMATION-SYSTEM/
│
├── DbHelper.java
├── Kullanici.java
├── User.java
├── anaSayfa.java
├── anaSayfa.form
├── kategoriVeMarka.java
├── kategoriVeMarka.form
├── kayitOl.java
├── kayitOl.form
└── ...
```

This structure keeps different responsibilities of the application separated and makes the project easier to manage.

## 🚀 Running the Project

1. Clone the repository.
2. Open the project in **NetBeans** or another compatible Java IDE.
3. Create the required **MySQL database**.
4. Configure the database connection information.
5. Make sure the **MySQL JDBC driver** is available.
6. Build and run the application.

## 💡 About This Project

This project was a practical exercise in building a **database-backed desktop application** rather than working with Java and SQL independently.

Developing different screens for users, products, categories, brands, stock, and sales required organizing both the application logic and database operations. It also provided hands-on experience with **Java GUI development, relational databases, JDBC, CRUD operations, and object-oriented application design**.




