FROM openjdk:8
ADD target/alemTest.jar alemTest.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "alemTest.jar"]