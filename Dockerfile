FROM openjdk:18.0.2.1

COPY build/libs/SpringBootRestDemo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]