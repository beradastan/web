# 1️⃣ Maven ile projeyi build etme
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app

# pom.xml dosyanın olduğu dizini belirt
COPY sunum/sunum/pom.xml .  

# Önceden bağımlılıkları indir
RUN mvn dependency:go-offline  

# Proje kaynak kodlarını kopyala
COPY sunum/sunum/src ./src  

# Maven ile projeyi build et
RUN mvn clean package -DskipTests

# 2️⃣ Java ile JAR dosyasını çalıştırma
FROM eclipse-temurin:17-alpine
WORKDIR /app

# Oluşan JAR dosyasını al ve çalıştır
COPY --from=build /app/target/SUNUM-0.0.1-SNAPSHOT.jar sunum.jar
CMD ["java", "-jar", "sunum.jar"]
