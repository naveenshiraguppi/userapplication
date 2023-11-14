FROM openjdk:17-jdk-alpine
COPY build/libs/userapplication-1.0.0.jar userapplication-1.0.0.jar
ENTRYPOINT ["java", "-jar", "userapplication-1.0.0.jar"]