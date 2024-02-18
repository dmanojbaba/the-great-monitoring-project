# -- BUILD --
FROM maven:3.9.6-eclipse-temurin as build

WORKDIR /usr/src/app

COPY . .

RUN mvn -f /usr/src/app/pom.xml clean package

## -- JRE --
FROM amazoncorretto:21-alpine3.19 as corretto-jdk

RUN apk add --no-cache binutils

RUN jlink \
         --add-modules ALL-MODULE-PATH \
         --strip-debug \
         --no-man-pages \
         --no-header-files \
         --compress=2 \
         --output /jre

# -- RELEASE --
FROM alpine:3.19

ENV JAVA_HOME=/jre
ENV PATH="${JAVA_HOME}/bin:${PATH}"
COPY --from=corretto-jdk /jre $JAVA_HOME

WORKDIR /app

COPY --from=build /usr/src/app/target/hello-bff-*.jar hello-bff.jar
COPY entrypoint.sh entrypoint.sh

ENTRYPOINT [ "./entrypoint.sh", "hello-bff.jar" ]
