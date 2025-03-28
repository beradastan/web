# 1️⃣ Maven ile projeyi build etme
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /sunum
COPY . .
RUN mvn clean package -DskipTests

# 2️⃣ Java ile JAR dosyasını çalıştırma
FROM eclipse-temurin:17-alpine
WORKDIR /sunum
COPY --from=build /sunum/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
