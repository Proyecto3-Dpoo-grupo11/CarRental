# Project 3 Documentation

## Invoice Issuance
This section provides a step-by-step guide to generating invoices using the application.

### Step 1:
Upon opening the application, the main screen appears. Select "Iniciar como Cliente" (Start as a Client).

### Step 2:
Enter the provided username (`jj.diazo1`) and password (`amoDpo`) in the respective fields, then click "Iniciar Sesión" (Log In).

### Step 3:
To initiate a reservation, click "Iniciar reserva" (Start Reservation).

### Step 4:
Choose one of the available locations: "sede 0" or "sede 1." For ease of testing, these simplified names were used. Note the date format is YY/MM/DD (e.g., 2022/01/01 for January 1, 2022). Once the information is filled in, click "Aceptar" (Accept).

### Step 5:
Select one of the two payment methods and enter your card number. The application has three bank accounts for testing:
- Account "10": Sufficient funds to complete the payment.
- Account "20": Insufficient funds, so the transaction is declined.
- Account "30": Account is blocked, payment cannot proceed.

### Step 6:
Once the payment is completed, the receipt will be saved as a PDF in the "data" folder with the information you entered.

## Vehicle Availability
This section provides instructions on how to check vehicle availability in the application.

### Step 1:
When opening the application, select "Iniciar como Cliente" (Start as a Client).

### Step 2:
Enter the provided username and password, then click "Iniciar Sesión" (Log In).

### Step 3:
To check vehicle availability, click "Ver Disponibilidad de Vehículos" (Check Vehicle Availability).

### Step 4:
Select one of the two available locations: "sede 0" or "sede 1." It is recommended to use "sede 1," which has a wider variety of vehicles. Note the date format (YY/MM/DD). 

### Step 5:
This window shows all available vehicles at the selected location for the specified dates. You can scroll through the list using the arrows. You can also start a reservation from this window, which grants a 10% discount.

### Step 6:
Once the reservation is completed, the rental price will reflect a 10% discount.

## Create New Client
This section outlines the steps to create a new client account in the application.

### Step 1:
Upon opening the application, select "Iniciar como Cliente" (Start as a Client).

### Step 2:
Click "Crear Usuario Nuevo" (Create New User).

### Step 3:
Enter the new client's information and click "Crear Cliente" (Create Client).

### Step 4:
Now you can log in with the newly created username and password.

### Step 5:
After logging in, you can access the client's menu.

## Dynamic Loading
This section explains the dynamic loading feature of the application.

### Step 1:
Read the "MetodosDePago" text file and add a button for each class listed in the file.

### Step 2:
Detect which button is clicked to initiate dynamic loading with the associated class.

### Step 3:
Find the class by name, enter the necessary parameters, and create an instance of the corresponding class.

## General Information

### Changes
- **Reservations and Vehicles**: Implemented new invoice and PDF functionalities. Introduced vehicle files to facilitate testing.
- **Menu Separation**: Added two new locations, named "sede 0" and "sede 1" for easier testing. "Sede 1" has more cars and employees.
- **New Classes in View**: Introduced 5 new classes: CargaDinamica, Banco, MetodosDePago, MPayU, and MPayPal. These are visual components or connect to external entities. 

### Structure
The project has 4 main packages: `logica`, `control`, `vista`, and `pruebas`. The focus was on optimizing the reservation system by separating the client and employee applications into distinct frames within the `vista` package.

### UML
A UML diagram was provided to illustrate the overall structure, focusing on class interactions and relationships.

### Tests
Encountered issues with reservation tests due to tight coupling. Dynamic loading tests had 86% coverage and worked well, excluding a specific catch block deemed unnecessary to test.

Thank you for using our application.
