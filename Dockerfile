FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Копируем файл WAR или JAR приложения в контейнер
# Замените "app.jar" или "app.war" на актуальное имя вашего файла
COPY /app/build/libs/acme-app.jar /app/acme-app.jar

# Expose порт, чтобы сделать службу доступной
# Измените порт (например 8080), если ваше приложение используется в другом порту
EXPOSE 8080

# Указываем команду для запуска приложения
CMD ["java", "-jar", "/app/acme-app.jar"]