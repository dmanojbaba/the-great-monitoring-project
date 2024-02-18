docker build -t hello-bff:latest -f ./hello-bff/Dockerfile.local ./hello-bff/
docker build -t hello-frontend:latest -f ./hello-frontend/Dockerfile.local ./hello-frontend/
docker build -t hello-prometheus:latest ./hello-prometheus/
docker build -t hello-grafana:latest ./hello-grafana/
