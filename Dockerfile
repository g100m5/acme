FROM amazoncorretto:17-alpine

WORKDIR /app

COPY . /app

RUN ./gradlew assemble

EXPOSE 8080

CMD ./gradlew lqbUpdate && java -jar ./app/build/libs/acme-app.jar