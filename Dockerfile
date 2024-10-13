# Use the official Maven image with version 3.9.6 and OpenJDK 21 to compile and package the application
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use an official Eclipse Temurin OpenJDK 21 runtime image
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/ffs-task-1.0.0.jar /app/app.jar

# Expose the port your Spring Boot app will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
