# -- BUILD --
FROM golang:1.21.7-alpine3.19 AS build

WORKDIR /usr/src/app

COPY go.* go.* ./

RUN go mod download

COPY *.go ./

RUN go build -o ./hello-backend

# -- RELEASE --
FROM alpine:3.19

WORKDIR /app

COPY --from=build /usr/src/app/hello-backend hello-backend

ENTRYPOINT ["/app/hello-backend"]
