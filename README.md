# Spring Boot 3 Security Demo

This project is a demo application showcasing the integration of Spring Boot 3 with Spring Security, JWT authentication, and MySQL database.

## Features

- User and Admin roles with different access levels
- JWT-based authentication and authorization
- Secure REST API endpoints
- User registration and login
- Password encryption using BCrypt
- Integration with MySQL database

## Technologies Used

- Spring Boot 3
- Spring Security
- JSON Web Token (JWT)
- MySQL
- JPA/Hibernate
- Lombok
- Maven

# Demo

## User
### Create new user with POST /auth/user
![create_user.png](src/main/resources/IMG/create_user.png)
### Generate user's token POST /auth/token/
![get_user_token.png](src/main/resources/IMG/get_user_token.png)
### Get users' profile through token with GET /auth/user/profile
![get_user_profile.png](src/main/resources/IMG/get_user_profile.png)
### GET api
![user_GET](src/main/resources/IMG/user_GET.png)
### Other
![user_POST](src/main/resources/IMG/user_POST.png)
## Admin
### Create new admin with POST /auth/user
![create_user.png](src/main/resources/IMG/create_admin.png)
### Generate admin's token POST /auth/token/
![get_user_token.png](src/main/resources/IMG/get_admin_token.png)
### Get admin's profile through token with GET /auth/admin/profile
![get_user_profilse.png](src/main/resources/IMG/get_admin_profile.png)
### GET api
![admin_GET](src/main/resources/IMG/admin_GET.png)
### POST api
![admin_POST](src/main/resources/IMG/admin_POST.png)
### PUT api
![admin_PUT](src/main/resources/IMG/admin_PUT.png)
### DEL api
![admin_DEL](src/main/resources/IMG/admin_DEL.png)
## Database
![db.png](src/main/resources/IMG/db.png)

