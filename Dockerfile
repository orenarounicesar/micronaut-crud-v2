# Etapa 1: Build
FROM gradle:8.7.0-jdk21 as builder

WORKDIR /app

ENV GRADLE_OPTS="-Dorg.gradle.vfs.watch=false -Dorg.gradle.daemon=false"

COPY build.gradle settings.gradle gradle.properties /app/
COPY gradle /app/gradle
COPY . /app

RUN gradle build --no-daemon

# Etapa 2: Runtime
FROM eclipse-temurin:21-jre-alpine

ENV DATASOURCE_URL=jdbc:mysql://localhost:3306/test \
    DATASOURCE_USERNAME=root \
    DATASOURCE_PASSWORD=secret

WORKDIR /app
COPY --from=builder /app/build/libs/*-all.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
