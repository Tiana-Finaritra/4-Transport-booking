# Transport Reservation Management Application
![MadaTrans](0-public/MadaTrans.gif)

This application is designed to manage transport reservations for trips. 
It allows customers to make reservations for various trips.

## Technologies Used

- Back-End: Spring Boot, Java
- Database: PostgreSQL
- Front-End: [...]
- Testing: JUnit5

## Installation

1. Clone this repository to your machine.

```sh
git clone https://github.com/YourName/your-project.git
cd your-project
```

## Prerequisites

- Java 17
- Maven [OPTIONAL - Depending on the build tool you're using]
- PostgreSQL
- JDBC DRIVER

## Above all:
- Customize connection information in "2-back-end/src/main/ressources/application.properties".
- Run the rundb.sql file in the 1-database folder to implement the database schema 
and generate dummy data in your local host.
- If you're on vsCode like me: you'll find the manual launch point 
in "2-back-end/src/main/java/MadatransApplication.java".