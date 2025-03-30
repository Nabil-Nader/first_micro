# Use OpenJDK base image for runtime stage
FROM openjdk:17-slim as runtime

# Set the working directory for the runtime environment
WORKDIR /app

# Copy the JAR file from your local machine into the Docker image
# Ensure you build the JAR first with 'mvn clean install' locally
COPY target/apigw.jar /app/app.jar

# Expose the port for the Spring Boot app
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/app.jar"]