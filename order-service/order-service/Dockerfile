FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /app
COPY pom.xml /app/
RUN mvn dependency:go-offline -Dmaven.test.skip=true
COPY src /app/src/
RUN mvn clean package spring-boot:repackage -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/order-service-0.0.1-SNAPSHOT.jar /app
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.10.0/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar
ADD https://github.com/grafana/pyroscope-java/releases/download/v2.1.2/pyroscope.jar /app/pyroscope.jar
CMD ["java", "-jar", "/app/order-service-0.0.1-SNAPSHOT.jar"]