FROM openjdk:8-jdk-alpine

RUN mkdir -p ~/app

WORKDIR app

COPY entrypoint.sh entrypoint.sh
COPY build/libs/hello-backend-*.jar hello-backend.jar

EXPOSE 9000 9001

ENTRYPOINT [ "./entrypoint.sh", "hello-backend.jar" ]
