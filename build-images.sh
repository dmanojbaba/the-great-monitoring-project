docker build -t hello-backend:latest -f ./hello-backend/Dockerfile.local ./hello-backend/
docker build -t hello-frontend:latest -f ./hello-frontend/Dockerfile.local ./hello-frontend/
docker build -t hello-prometheus:latest ./hello-prometheus/
docker build -t hello-grafana:latest ./hello-grafana/
