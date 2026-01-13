# Technical Assessment – Spring Boot Application

## Project Requirements

- Language: Java 17
- Framework: Spring Boot
- Build Tool: Maven
- Containerization: Docker
- API Testing: Postman


## Running the Application Locally

### Prerequisites
- JDK 17 installed
- Maven installed
- Any IDE (IntelliJ IDEA / Eclipse / VS Code)

### Steps

1. Install JDK 17
   `java -version`

2. Open the project as a Maven project
    - Import the project into your IDE
    - Wait for dependencies to download

3. Build the project

   `mvn clean package`

4. Run the application
   `mvn spring-boot:run`

   OR

   `java -jar target/*.jar`

5. Application will start on
   http://localhost:8082


## Running the Application Using Docker

### Prerequisites
- Docker installed and running

### Steps

1. Open terminal inside the project root directory
   (where Dockerfile exists)

2. Build the Docker image
   
    `docker build -t technical-assessment:1.0 .`

3. Run the Docker container
   
    `docker run -d --name technical-assessment -p 8082:8082 technical-assessment:1.0`

4. Verify the application
   http://localhost:8082

5. View logs (optional)

   `docker logs -f technical-assessment`


## API Testing with Postman

1. Postman collection is available inside:
   technical-assessment-eskimi

2. Open Postman

3. Import the collection
    - Click Import
    - Select the collection file

4. Run each API and check the response


## Summary

- Java 17 and Spring Boot based application
- Can be run locally or via Docker
- Docker uses multi-stage build
- APIs can be tested using provided Postman collection
