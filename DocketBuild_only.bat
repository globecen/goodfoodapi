docker build -f src/main/docker/Dockerfile.native-distroless -t good-food/quarkus-api .
docker run -i --rm -p 8080:8080 good-food/quarkus-api



