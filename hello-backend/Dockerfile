# -- BUILD --
FROM maven:3.9.6-eclipse-temurin as build

WORKDIR /usr/src/app

COPY . .

RUN mvn -f /usr/src/app/pom.xml clean package

# -- RELEASE --
FROM openjdk:23-jdk

WORKDIR /app

COPY --from=build /usr/src/app/target/hello-backend-*.jar hello-backend.jar
COPY entrypoint.sh entrypoint.sh

ENTRYPOINT [ "./entrypoint.sh", "hello-backend.jar" ]
