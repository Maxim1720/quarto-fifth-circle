FROM openjdk:18-alpine3.15
WORKDIR app
ENV APP_NAME="app.jar"
COPY /target/qfc.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]