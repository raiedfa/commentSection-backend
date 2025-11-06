# Use an official Java 21 image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml first for caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Download dependencies (cache this layer)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the project
COPY src ./src

# Build the project (skip tests for faster build)
RUN ./mvnw package -DskipTests -B

# Expose the port your Spring Boot app runs on
EXPOSE 9000

# Run the application
CMD ["java", "-jar", "target/commentSection-0.0.1-SNAPSHOT.jar"]



