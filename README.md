# User Registration
Test task for cybercubbe Java Developer position. 

## Technical Stack
1. Java 11
2. Spring Boot 2.2.2
3. Maven
4. Apache Kafka
5. Redis

## Development description
This task has two applications: **producer** and **consumer**. The producer app has the API service endpoint for user registration and consumer app has a service that saves the user record to the database.

## Setup and installation
1. Download and install: Apache Kakfa and Redis
2. Run Zookeeper instance for Kafka and Kafka server on port: 9092
3. Start Redis server
4. Clone this project and run producer and consumer apps separately.
5. Make request to producer API.

### To register a user, the following APIs can be used:
In case of local run of application, **POST** request to
```sh
http://localhost:9000/api/user
```
The request has to be made same with following JSON stucture. Missing of elements or wrong values will lead to receive errors and exceptions. 
`{ "first_name": "Jack","last_name": "Sparrow"}`

## Result
When a request has been made to producer API as like above example, following result should appear in producer app console log:
`Message sent. Message: {"first_name":"Jack","last_name":"Sparrow","application_name":"User Registration"}`

and in consumer app console log:
`Consumed message of user: {"first_name":"Jack","last_name":"Sparrow","application_name":"User Registration"}`

Running Redis from command line should display the above created user.

**Application name can be changed in producer: src/main/resources/producer-app.properties/application.name**
