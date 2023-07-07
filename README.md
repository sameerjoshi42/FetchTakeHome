# FetchTakeHome
Take Home assessment for fetch 



Receipt Processor Application-

The Receipt Processor application is a Java Spring Boot application that allows users to process receipts and calculate reward points.

Prerequisites-

Before running the application, make sure you have the following software installed:

- Java Development Kit (JDK) 11 or higher
- Docker (if you want to run the Docker image)

Getting Started

To get started with the Receipt Processor application, follow these steps:

1. Clone the project repository:
     https://github.com/sameerjoshi42/FetchTakeHome.git
   

2. Open the project in your preferred IDE. I recommend using IntelliJ IDEA for the best experience.

3. Build the project using Maven. Open a terminal or command prompt, navigate to the project root directory, and run the following command:

   mvn clean install
  
 This command will compile the source code, run the tests, and package the application into a JAR file.

Running the Application Locally

To run the Receipt Processor application locally, follow these steps:

1. Make sure you have successfully built the project using Maven (see the previous step).

2. In your IDE, locate the `ReceiptProcessorApplication` class, which contains the main method.

3. Run the `main` method to start the Spring Boot application.

4. The application will start and listen for incoming requests on the default port `8080`.

Using Postman to Interact with the API

The Receipt Processor application provides a RESTful API that can be tested using Postman or any other API testing tool. Follow these steps to use Postman:

1. Install Postman: Download and install Postman from the official website: [https://www.postman.com/downloads/](https://www.postman.com/downloads/).

2. Launch Postman and create a new request.

3. Set the request URL to `http://localhost:8080/receipts/process` for processing a receipt.

4. Set the request method to `POST` and provide the necessary request body (JSON payload) for the receipt.

5. Click the "Send" button to send the request to the application.

6. You will receive a response with the receipt ID or any other relevant information.

Make sure the application is running locally before sending requests using Postman.

Running the Dockerized Application

The Receipt Processor application has been dockerized and can be run as a Docker container. Follow these steps to run the Docker image:

1. Make sure you have Docker installed on your machine.

2. Pull the Docker image from the Docker Hub repository using the following command:

   docker pull sameerjoshi42/takehome.jar
  
3. Once the image is pulled successfully, run the Docker container using the following command:

   docker run -p 8080:8080 sameerjoshi42/takehome.jar

   This command maps port `8080` of the container to the same port on the host machine.

4. The application will start inside the Docker container and listen for incoming requests on port `8080` of the host machine.

5. You can now use Postman or any other API testing tool to send requests to the running Docker container using the URL `http://localhost:8080/receipts/process`.






