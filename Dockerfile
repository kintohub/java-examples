FROM maven:3-jdk-8-alpine AS build

WORKDIR /app

# Copy everything else and build
COPY . ./

RUN mvn clean compile assembly:single
RUN mkdir /app/out && mv ./target/start-jar-with-dependencies.jar /app/out/start-jar-with-dependencies.jar

# Runtime image
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/out .

EXPOSE 80

ENTRYPOINT ["java", "-jar", "start-jar-with-dependencies.jar"]
