FROM openjdk:17-jdk-slim
WORKDIR /app

COPY ./build/libs/DragonStatistics-0.0.1-SNAPSHOT.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080:8080