# Start with a base image containing JDK 17
FROM openjdk:17-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ADD target/demo2711-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/app.jar"]