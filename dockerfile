FROM eclipse-temurin:11-jre-alpine
RUN mkdir -p /app
WORKDIR /app
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
RUN chmod +x /wait
COPY ./target/*.jar /app/app.jar
CMD /wait && java -jar /app/app.jar
