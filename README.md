
#  **Airport Reservation System** 

## Overview
The **Airport Reservation System** is a Java-based application that simulates the process of passengers reserving flights. It handles passenger information, flight reservations, and checks for various constraints like correct email, phone number formats, sufficient balance, available seat capacity, and timing conflicts between flights. 

## Features
- ** Passenger Information**: Allows creation and management of passenger details including name, phone number, email, and balance.
- ** Flight Management**: Handles flight details such as date, time, origin, destination, capacity, and cost. Supports flight reservations and seat availability checks.
- ** Error Handling**: Includes custom exceptions for various error conditions, such as invalid email formats, incorrect phone numbers, insufficient balance, and timing conflicts.

## Classes
### `Passenger` 
- Represents a passenger with details like name, phone number, email, balance, and a list of flights they have reserved.
- **Methods**:
  - `checkEmail`: Validates the passenger's email. 
  - `checkPhone`: Validates the passenger's phone number. 
  - `checkInitialBalance`: Checks if the initial balance is valid (non-negative). 
  - `reserveFlight`: Reserves a flight for the passenger, with checks for capacity, timing conflicts, and balance. 
  - `toString`: Returns a string representation of the passenger's details. 

### `Flight` 
- Represents a flight with details such as date, time, origin, destination, cost, capacity, etc.
- **Methods**:
  - `toString`: Returns a string representation of the flight details. 

### `Main` 
- Contains the main logic for creating passengers, flights, and managing reservations.
- **Methods**:
  - `flightDetails`: Prints detailed information about a flight and its passengers. 
  - `management`: Manages the process of reserving a flight for a passenger. 
  - `manageBalance`: Manages the passenger's balance. 
  - `manageEmail`: Manages the passenger's email. 
  - `managePhone`: Manages the passenger's phone number. 

## Custom Exceptions 
The following custom exceptions are used to handle specific errors:
- `WrongEmail`: Thrown when the email format is invalid. 
- `WrongPhoneNumber`: Thrown when the phone number format is invalid. 
- `WrongBalance`: Thrown when the balance is negative. 
- `FailedReserve`: Thrown when a flight reservation fails. 
- `SameOrginAndDestination`: Thrown when the flight's origin and destination are the same. 
- `SameTime`: Thrown when two flights have overlapping times. 
- `NoBalance`: Thrown when the passenger does not have enough balance for a flight reservation. 
