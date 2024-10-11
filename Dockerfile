FROM maven:3.9.9-eclipse-temurin-17-alpine as build

WORKDIR app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests && ls target/
ARG JAR_FILE=target/*.jar

FROM openjdk:17-jdk-alpine
WORKDIR app
COPY --from=build app/target/*.jar app.jar
#ENTRYPOINT ["echo", "${JAR_FILE}"]
ENTRYPOINT ["java","-jar", "app.jar"]
