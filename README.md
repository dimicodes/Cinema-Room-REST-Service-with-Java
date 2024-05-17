# Cinema Booking System

## Overview
This Cinema Booking System is a simple RESTful service developed using Java with Spring Boot. It allows users to view available seats, purchase tickets, and return tickets. Additionally, it provides a secure endpoint for theater managers to view cinema statistics.

## Features
- **View Available Seats**: Get a list of all seats and their availability.
- **Purchase Tickets**: Allow users to purchase tickets for available seats.
- **Return Tickets**: Enable users to return purchased tickets.
- **View Cinema Statistics**: Secure endpoint for theater managers to view income, number of available and purchased tickets.

## Getting Started

### Prerequisites
- JDK 11 or later
- Maven
- Spring Boot

### Running the Application
1. Clone the repository:
   ```git clone https://github.com/dimicodes/Cinema-Room-REST-Service-with-Java.git```

2. Navigate to the project directory:
   ```cd Cinema-Room-REST-Service-with-Java```

3. Compile and run the application


## API Endpoints

### View Available Seats
Endpoint: GET /seats
Description: Returns a list of all seats in the cinema room.

### Purchase Ticket
Endpoint: POST /purchase
Body:
json
Copy code
{
  "row": 1,
  "column": 3
}
Description: Allows purchasing a ticket for a specified seat.

### Return Ticket
Endpoint: POST /return
Body:
json
Copy code
{
  "token": "ticket-token-here"
}
Description: Allows returning a purchased ticket using its token.

### View Cinema Statistics
Endpoint: GET /stats
Parameters: password=super_secret
Description: Returns statistics of the cinema's ticket sales. Access is restricted by a password.

## Security
The /stats endpoint is secured with a simple password mechanism. For production environments, it is recommended to enhance security measures.
