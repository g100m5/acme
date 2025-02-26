FROM amazoncorretto:17-alpine

WORKDIR /app

COPY /app/build/libs/acme-app.jar /app/acme-app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/acme-app.jar"]