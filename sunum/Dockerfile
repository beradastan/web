# 1. Maven ile derleme yapacak build aşaması
FROM maven:3-eclipse-temurin-17 AS build

# 2. Proje dosyalarını konteynere kopyala
COPY . /app

# 3. Çalışma dizinini POM.xml'in olduğu klasör olarak belirle
WORKDIR /app/sunum

# 4. Maven ile projeyi derle (testleri atlayarak)
RUN mvn clean package -DskipTests

# 5. Hafif bir Java runtime ortamına geç
FROM eclipse-temurin:17-alpine

# 6. Derlenen JAR dosyasını al
COPY --from=build /app/sunum/target/*.jar /app/app.jar

# 7. Çalışma dizinini belirle
WORKDIR /app

# 8. Uygulamayı başlat
CMD ["java", "-jar", "app.jar"]
