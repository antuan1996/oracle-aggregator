# Oracle Database Aggregator

Aggregates data from multiple databases and sync all in Oracle database.

## Build & Run locally

Download [oJDBC (ojdbc7.jar)](https://www.oracle.com/technetwork/database/features/jdbc/jdbc-drivers-12c-download-1958347.html) and put it in */driver* folder.
Rename it to *ojdbc7-12.1.0.2.jar*

Then run:
```bash
./gradlew bootJar
```

Execute (Located in /build/libs):
```bash
java -jar oracle-aggregator-1.0.0.jar
```

## Build & Run with Docker

Order of execution: *Build -> Up -> Stop*

Build
```bash
docker-compose build
```

Run (add *-d* to use detached mode or it will be interactive)
```bash
docker-compose up
```

Stop
```bash
docker-compose stop
```

### Endpoints

All server ednpoints at - *localhost:8080/swagger-ui.html*

Learn more about [swagger ui](https://swagger.io/tools/swagger-ui/)

There are specific *load* & *load test* endpoints for each database with specific name for such database.

### Oracle Common Schema
Some tables changed, check DB for correct schema.

![](doc/schema_common.png)