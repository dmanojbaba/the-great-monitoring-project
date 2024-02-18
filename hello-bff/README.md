This project was forked from [Spring Boot Building a RESTful Web Service with CORS](https://github.com/spring-guides/gs-rest-service-cors).

## What you’ll build
You’ll build a service that will accept HTTP GET requests at:
```
http://localhost:9000/hello
```
and respond with a JSON representation:
```
{"id":1,"time":1546300800000,"content":"Hello, World!"}
```
### Build an executable JAR
If you are using Gradle, you can run the application using `./gradlew bootRun`. 
Or you can build the JAR file using `./gradlew build`. 
Then you can run the JAR file:
```bash
$ ./gradlew build
```
### Run
```bash
$ java -jar build/libs/hello-bff-0.1.0.jar
```
