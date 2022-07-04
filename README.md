# spring-security

## Setup Keycloak
```shell
docker run --name keycloak_dev -p 8180:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev
```

## Setup Postgres
```shell
docker run --name postgres_dev -p 5442:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```