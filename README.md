# Simple-Hibernate-project-Merchant-Product
# Merchant Product Management System

## Overview

The Merchant Product Management System is a Java-based console application that allows users to manage merchants and their associated products. This system provides functionality for creating, updating, verifying, and deleting merchants, as well as saving and updating products associated with merchants.

## Features

- **Merchant Management:**
  - Save a new merchant with name, password, phone number, email, and GST number.
  - Update existing merchant details.
  - Verify merchant using phone number and password or email and password.
  - Delete a merchant by ID.

- **Product Management:**
  - Save a new product associated with a merchant.
  - Update existing product details.
  - Find products by brand, category, or merchant ID.

## Technologies Used

- Java
- JPA (Java Persistence API)
- Hibernate (as the JPA provider)
- MySQL (or your preferred database)

## Project Structure

The project is structured into the following packages:

- `merchent_product_controller`: Contains the main controller for user interaction.
- `dao`: Includes data access objects for managing merchants and products.
- `dto`: Defines the data transfer objects (Merchant and Product classes).

## How to Run

1. Clone the repository: `git clone https://github.com/yourusername/merchant-product-management.git`
2. Open the project in your preferred Java IDE.
3. Configure the database connection in the `persistence.xml` file.
4. Run the `Merchant_Product_Controller` class.

## Dependencies

- Java SE Development Kit (JDK)
- JPA and Hibernate dependencies (included in the project)

## Contribution

Feel free to contribute to the project by creating issues or submitting pull requests. Follow the standard GitHub workflow for contributions
