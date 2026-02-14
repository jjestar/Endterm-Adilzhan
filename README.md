**I rewrote classes for additional tasks and yet still used port 8082 since 8081 and 8080 both are already taken by other configurations. All the screenshots are in src/docs and named as "Attention Task", I did soft delete for models and worked with postman. I also used single table(class ierarchy) and demonstrated all them in the given screenshots** 

----------------------------------------------------

Car Rental Management System (Spring Boot API)
Project Overview
This is a RESTful API for a Car Rental System developed as an Endterm project. The application allows managing a vehicle fleet (Standard and Luxury cars) and processing customer reservations with dynamic price calculation.

Features
Vehicle Management: Add, list, and delete vehicles.

Polymorphic Logic: Supports Luxury (with chauffeur options) and Standard (fuel-efficient) vehicles.

Reservation System: Book vehicles for specific dates with optional services (WiFi, Insurance, Child Seat).

Dynamic Pricing: Automatically calculates the total price based on vehicle type and extras.

Database: Uses H2 In-memory database for easy testing.

Technologies Used
Java 25 (OpenJDK)

Spring Boot 4.0.2

Spring Data JPA (Hibernate)

H2 Database

Lombok

Maven

Getting Started
Prerequisites
JDK 25 or higher

Maven 3.9+

IntelliJ IDEA

Installation & Run
Clone the repository:

Open the project in IntelliJ IDEA.

Wait for Maven to download dependencies.

Run the RentalApplication.java file.

The server will start on: http://localhost:8082

API Endpoints
Vehicles
Reservations
Database Console
You can access the H2 database console to view tables:

URL: http://localhost:8082/h2-console

JDBC URL: jdbc:h2:mem:rentaldb

User: POSTGRES

Password: postgres
