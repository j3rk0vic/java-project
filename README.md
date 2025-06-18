# Java Project: Movie Management Application

This application was developed as a final project for the **Java Programming** course. The goal is to demonstrate advanced object-oriented programming principles through the development of a Swing-based application that integrates with Microsoft SQL Server, uses stored procedures, processes XML RSS feeds, and applies modern software architecture concepts.

## Features

- User login and registration system (roles: Administrator and User)
- Admin panel for:
    - Database initialization and cleanup
    - Importing data via RSS feed parser
- Full CRUD support for entities:
    - Movie
    - Actor
    - Director
    - Genre
- Entity relationships (e.g., a movie can have multiple actors and directors)
- User-friendly Swing-based GUI with:
    - JTabbedPane
    - JTable
    - JMenu for navigation
- Drag & Drop support (e.g., assigning an actor to a movie)
- Image download and local storage with relative paths saved to the database
- Multithreaded RSS data parsing to keep the GUI responsive

# Technologies Used

- Java (Swing, JDBC, JAXB)
- Microsoft SQL Server
- Maven
- RSS/HTTP handling
- FlatLaf
- MVC architecture

## Getting started

1. Run the SQL initialization script (`ijerkovic_sql_script.sql`) on Microsoft SQL Server, along with all related stored procedure scripts (`actor_procs.sql`, `director_procs_sql`, etc.)
2. Compile and run the application using your IDE (e.g., IntelliJ IDEA, Netbeans, Eclipse).
3. Log in as the admin credentials:
    - **Username:** `admin`
    - **Password:** `page`
4. Use a built-in RSS parser to import movie data.
5. Interact with the app as either an Administrator or a standard User.