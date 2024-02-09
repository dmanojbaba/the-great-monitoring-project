# -- BUILD --
FROM gradle:8.6-jdk21-alpine as build

WORKDIR /usr/src/app

COPY . .

RUN gradle init
RUN gradle build

# -- RELEASE --
FROM openjdk:23-jdk

WORKDIR /app

COPY --from=build /usr/src/app/entrypoint.sh entrypoint.sh
COPY --from=build /usr/src/app/build/libs/hello-backend-*.jar hello-backend.jar

EXPOSE 9000 9001

ENTRYPOINT [ "./entrypoint.sh", "hello-backend.jar" ]
