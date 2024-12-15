# Java MySQL Database Integration

## Overview
This project demonstrates how to integrate a MySQL database with a Java application. It includes a sample schema with users, posts, and comments tables.

## Features
- Users table with unique constraints on username and email.
- Posts and comments linked to users via foreign keys.
- Initial data to test functionality.

## Setup
1. Install MySQL.
2. Run the `db/init.sql` script to create the schema and populate initial data.
3. Update the database credentials in the `DatabaseIntegration.java` file.

## Dependencies
- MySQL Server
- MySQL JDBC Driver (`mysql-connector-java`)

## Run Instructions
1. Compile the Java program:
   ```bash
   javac -cp .:mysql-connector-java.jar your/package/DatabaseIntegration.java
