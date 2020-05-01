FROM openjdk:8-jdk-alpine
COPY /target/horizonbackend-0.0.1-SNAPSHOT.jar horizon.jar
ENTRYPOINT ["java","-jar","horizon.jar"]
EXPOSE 8080
