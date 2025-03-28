# 1️⃣ Maven ile projeyi build etme
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /sunum

# pom.xml ve kaynak kodları doğru dizinden al
COPY sunum/pom.xml .  
COPY sunum/src ./src  

# Önceden bağımlılıkları indir
RUN mvn dependency:go-offline  

# Maven ile projeyi build et
RUN mvn clean package -DskipTests

# 2️⃣ Java ile JAR dosyasını çalıştırma
FROM eclipse-temurin:17-alpine
WORKDIR /sunum

# Oluşan JAR dosyasını al ve çalıştır
COPY --from=build /sunum/target/sunum-0.0.1-SNAPSHOT.jar sunum.jar
CMD ["java", "-jar", "sunum.jar"]
