<h1 align="center"> Java Spring Boot - JWT Authentication </h1>
<p align="center">
  This project is a Spring Boot application that implements JWT (JSON Web Token) authentication. 
  It includes endpoints for registering users, logging in, accessing protected resources, updating user data, and pagination.
</p>

<br>

<p align="center">
  <a href="#project-notes"><strong>Project Notes</strong></a> •
  <a href="#getting-started"><strong>Getting Started</strong></a> •
  <a href="#using-the-application"><strong>Using the Application</strong></a> •
</p>

<br>

## **Project Notes**
- To run the project:
  - Install all dependencies listed in the `pom.xml` file.
  - Configure the `application.properties` file (_/jwtAuth/src/main/resources/application.properties_). An example file (_application.example.properties_) is provided in the same directory. 
  - The project uses the _/jwtAuth/src/main/resources/db_ directory for database migrations. The `V2__populate_table.sql` file contains entries to populate the database and test pagination.

## **Getting Started**
Clone the repository and run it.

~~~bash
# Clone the repository 
$ git clone git@github.com:Vediniz/JavaSpringBoot---JwtAuthentiction.git
~~~

## **Using the Application**
Use the following `curl` commands to test the application's main endpoints.

Use the default administrator user to access the protected endpoints such as creating users. Then you will be able to create your own users.

### **User Login**
This endpoint allows users to log in and receive a JWT token.

~~~bash
curl -X POST http://localhost:8080/api/login -H "Content-Type: application/json" -d '{
"username": "admin",
"password": "admin"
}'
~~~

#### **Security & Authentication**
The application uses JWT (JSON Web Token) to secure endpoints. When a user logs in successfully, a token is generated and returned. This token should be included in the `Authorization` header as a Bearer token for subsequent requests to protected endpoints.

Example:

~~~bash
Authorization: Bearer your_jwt_token
~~~


### **Get Current User**
This endpoint retrieves the current authenticated user's details.

~~~bash
curl -X GET http://localhost:8080/api/me -H "Authorization: Bearer your_jwt_token"
~~~

### **Protected Endpoint Access (Admin Role)**
This endpoint retrieves a paginated list of all users. Accessible only by users with the `ADMIN` role.


### **User Registration**
This endpoint allows creating a new user.

~~~bash
curl -X POST http://localhost:8080/api/users -H "Content-Type: application/json" -d '{
"username": "admin",
"password": "userpassword",
"role": "USER"
}'
~~~

~~~bash
curl -X GET http://localhost:8080/api/users/all?page=0&limit=10&sortBy=id&sortDir=asc -H "Authorization: Bearer your_jwt_token"
~~~

### **User Update**
This endpoint updates a user's data. Accessible only by users with the `ADMIN` role.

~~~bash
curl -X PUT http://localhost:8080/api/users/1 -H "Authorization: Bearer your_jwt_token" -H "Content-Type: application/json" -d '{
  "username": "updateduser",
  "password": "newpassword",
  "role": "USER"
}'
~~~

### **Partial User Update**
This endpoint allows partial updates to a user's data. Accessible only by users with the `ADMIN` role.

~~~bash
curl -X PATCH http://localhost:8080/api/users/1 -H "Authorization: Bearer your_jwt_token" -H "Content-Type: application/json" -d '{
  "username": "updateduser"
}'
~~~

### **User Deletion**
This endpoint deletes a user by their ID. Accessible only by users with the `ADMIN` role.

~~~bash
curl -X DELETE http://localhost:8080/api/users/1 -H "Authorization: Bearer your_jwt_token"
~~~

### **Hello Endpoint**
This simple endpoint returns a greeting message.

~~~bash
curl -X GET http://localhost:8080/api/hello
~~~

### **Hello with Name Endpoint**
This endpoint returns a personalized greeting message.

~~~bash
curl -X GET http://localhost:8080/api/hello/{name}
~~~
