FROM eclipse-temurin:17-jre

ARG SERVICE_PATH
WORKDIR /app

COPY ${SERVICE_PATH}/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
