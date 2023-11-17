# Use the official Kotlin image as the base image
FROM kotlin:latest

# Set the working directory inside the container
WORKDIR /app

# Copy the contents of the local src directory to the container
COPY . /app

# Build the application
RUN kotlinc /app -include-runtime -d app.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "app.jar"]
