FROM openjdk:17-jdk-alpine
COPY target/springaed 0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","springaed 0.0.1-SNAPSHOT.jar"]