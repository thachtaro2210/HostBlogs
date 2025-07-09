# Use OpenJDK as base image
FROM eclipse-temurin:17-jdk

# Create app directory
WORKDIR /app

# Copy the jar file
COPY target/*.jar app.jar

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
