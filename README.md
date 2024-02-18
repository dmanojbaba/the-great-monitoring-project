This project is for monitoring [Spring Boot](http://spring.io) and [ReactJS](https://reactjs.org/) applications.

| Application       | URL                   |
| ----------------- | --------------------- |
| Frontend (React)  | http://localhost:9000 |
| BFF (Spring Boot) | http://localhost:9001 |
| Backend (Go)      | http://localhost:9002 |

## Prerequisites

- [docker](https://www.docker.com/)
- [go](https://go.dev/)
- [java](https://www.java.com/)
- [maven](https://maven.apache.org/)
- [npm](https://nodejs.org/)

## Install & Run (Mac)

```bash
$ curl -fsSL get.docker.com -o get-docker.sh
$ sudo sh get-docker.sh
$ sudo usermod -aG docker $USER

$ brew install go
$ brew install maven
$ brew install node

$ git clone https://github.com/dmanojbaba/the-great-monitoring-project.git
$ cd the-great-monitoring-project

$ ./install.sh

$ ./build.sh
```

### Startup (docker-compose up -d)

```
$ ./start.sh
```

### Shutdown (docker-compose down)

```
$ ./stop.sh
```
