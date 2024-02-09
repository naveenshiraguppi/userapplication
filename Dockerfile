# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy
COPY build/libs/userapplication-1.0.0.jar userapplication-1.0.0.jar
ENTRYPOINT ["java", "-jar", "userapplication-1.0.0.jar"]
