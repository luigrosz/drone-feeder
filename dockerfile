FROM openjdk:11.0.15-jdk as build-image
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean package

FROM openjdk:11.0.15-jre
COPY --from=build-image /app/source/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
