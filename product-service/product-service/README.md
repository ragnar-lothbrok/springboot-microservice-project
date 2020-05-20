docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 postgres

mvn clean install

mvn spring-boot:run

http://localhost:8091/swagger-ui.html