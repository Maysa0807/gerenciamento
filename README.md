# Eventos
Projeto API Rest usando Java Spring integrado ao microservice Date 

## Usage
1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints
The API provides the following endpoints:

```markdown
GET /product - Retrieve a list of all data.

POST /product - Register a new data.

PUT /product - Alter data.

DELETE /product/{id} - Inactivate data.
```

## Database
PostgresSQL as the database. The necessary database migrations are managed using Flyway.

