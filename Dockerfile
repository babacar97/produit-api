FROM eclipse-temurin:17-jdk-alpine

LABEL authors="andreas"

WORKDIR /app

COPY target/produit.jar ./produit.jar

EXPOSE 8082

CMD ["java", "-jar", "produit.jar"]