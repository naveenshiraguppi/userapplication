USER Application (Spring boot microservice)

1. Dockerized User application
2. Postgres docker image used
3. REST APIs displaying CRUD

How to run
1. Check out project
2. Open terminal
3. docker-compose build
4. docker-compose up -d (detached mode)
5. docker logs nishantdocker21.userapplication should show micro service logs

How to test
1. Open postman
2. POST message
curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Nishant",
"email": "nn@aa.com"
}'
3. GET All users
   curl --location 'http://localhost:8080/api/users'
4. GET User by id
   curl --location 'http://localhost:8080/api/users/1'
5. DELETE user by id
   curl --location --request DELETE 'http://localhost:8080/api/users/1'