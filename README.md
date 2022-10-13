## Overview

This is a Rewards Program application that demonstrates technical features of Spring Framework that includes Spring Boot, Spring MVC and Spring Data JPA. It was developed thinking on PubSub design pattern. Mainly, the application works as a subscriber that monitors transactions or events in the database for purchase transactions and calculates reward points of Customers if new events are detected.
This application was developed from scratch and used the coding problem as a guideline in the development. 

## Technology Stack


- H2 Database - in-memory database used to store customer information, purchase transactions and rewards points. Schema and Table data can be viewed on this URL: http://localhost:8080/h2-console/
- SQL Scripting - during application startup, it initializes the database by populating customer information, purchase transactions and calculate reward points using
	scripts stored in schema.sql and data.sql found in the /resource folder.
- Poller - this feature continuously monitor changes in the transaction table to check if there are purchases. The check interval is 5 seconds. Purchases that are not yet processed are extracted from the table, calculated and creates calculation of reward points.
- PubSub design pattern
- Java Features - Core Java, Generics
- Spring Boot 2.7.4
- Spring Data JPA
- Hibernate (ORM)
- JSON Mapping
- Exception Handler
- Log4j - Logs activities in logs/app.log file.

## API Access

GET /localhost:8080/customer/{customerId}

H2 Database URL: http://localhost:8080/h2-console/
