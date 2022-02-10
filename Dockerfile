FROM openjdk:11
ADD target/spring-boot22-with-docker.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080