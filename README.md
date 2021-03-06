This project is for monitoring [Spring Boot](http://spring.io) and [ReactJS](https://reactjs.org/) applications using [Prometheus](https://prometheus.io/) and [Grafana](https://grafana.com/).

| Application | URL |
|-------------|------|
|Frontend (React) | http://localhost:9000 |
|Backend (Spring Boot) | http://localhost:9100 |
|Prometheus | http://localhost:9090 |
|Grafana | http://localhost:3000 |

## Prerequisites
* [docker](https://www.docker.com/)
* [npm](https://nodejs.org/)
* [gradle](https://gradle.org/)
* [java](https://www.java.com/)

## Install & Run (Mac)
```bash
$ curl -fsSL get.docker.com -o get-docker.sh
$ sudo sh get-docker.sh
$ sudo usermod -aG docker ubuntu

$ brew install node

$ brew install gradle

$ git clone https://github.com/dmanojbaba/the-great-monitoring-project.git
$ cd the-great-monitoring-project

$ ./install.sh

$ ./build.sh
```
### Startup (docker-compose up -d)
```
$ ./startup.sh
```
### Shutdown (docker-compose down)
```
$ ./shutdown.sh
```
