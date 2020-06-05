FROM openjdk:8
ADD target/laborstat.jar laborstat.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "laborstat.jar"]