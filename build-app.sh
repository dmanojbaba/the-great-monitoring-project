go build -C ./hello-backend -o ./build/hello-backend
mvn clean package -f ./hello-bff
npm run build --prefix ./hello-frontend
