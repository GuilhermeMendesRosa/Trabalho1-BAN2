# Use the official Maven image to build the application
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory
WORKDIR .

# Copy the project files and download dependencies
COPY pom.xml .
COPY src ./src

# Build the WAR file
RUN mvn clean package -DskipTests

# Use the official OpenJDK base image for Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the WAR file from the builder stage
COPY --from=builder /target/SchoolManagerAPI-0.0.1-SNAPSHOT.war /app/SchoolManagerAPI-0.0.1-SNAPSHOT.war

# Expose the default Spring Boot port
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "/app/SchoolManagerAPI-0.0.1-SNAPSHOT.war"]
