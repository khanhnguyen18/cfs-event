#cfs

## Architecture
![Screenshot](Architecture.png)

#API  Documentation
Swagger use to help user can execute the rest API with documentation
Link: <http://localhost:8080/swagger-ui.html>
![Screenshot](./swagger.png)

# Entity table
![Screenshot](Architecture.png)

## Library
- Lombok

# Search


#H2
* Console link: http://localhost:8080/h2-console
* Database name:jdbc:h2:mem:testdb
* User: sa
* Pass:

#CURL
## Search cfs detail: 
curl -X GET "http://localhost:8080/rest/api/v1/cfs/2/detail" -H  "accept: */*"
