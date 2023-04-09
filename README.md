[![Java CI with Maven](https://github.com/crisywini/employee-management/actions/workflows/maven.yml/badge.svg?branch=develop)](https://github.com/crisywini/employee-management/actions/workflows/maven.yml)

# Employee Management

This project allows you to manage information about employees. Here are some functionalities:
- Save information about employees
- Update the employee information
- Find by personal ID
- Get all employees
- Get the age of a specific employee
- Get the seniority of an employee
- Get an employee's benefits

## Usage

Installed Maven and Java 17.

Download the repo and run the next command in the root folder: 

    mvn spring-boot:run 


Then you can use the localhost:8080/ the exposed services at this moment are:

| Service | Method | Description |
|--|--|--|
| */employees* | POST | Saves the employee's information |
| */employees* | PUT | Updates the employee's information |
| */employees/{id}* | GET | Find a specific employee by its id |
| */employees/age/{id}* | GET | Gets the age of an employee by its id |
| */seniority/{id}* | GET | Gets the seniority of an employee by its id |
| */benefits/{id}* | GET | Gets the benefits of an employee by its id |
| */employees* | GET | Gets all the employees |

