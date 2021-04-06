#Call for service

## Architecture
![Screenshot](Architecture.png)

#API  Documentation
Swagger use to help user can execute the rest API with documentation
Link: <http://localhost:8080/swagger-ui.html>
![Screenshot](swagger.png)

# Entity table
![Screenshot](Architecture.png)

# Fix data
### Agency <br/>
![Screenshot](fix_data_agency.png)
### Responder <br/>
![Screenshot](fix_data_responder.png)
* Responder OFFICER_001 belong to agency 1
* Responder OFFICER_002 belong to agency 2
### User <br/>
![Screenshot](fix_data_user.png)
* user1 belong to agency 1
* user2 belong to agency 2
### Cfs Event <br/>
![Screenshot](fix_data_cfs_event.png)

## Library
- Lombok

# Search


#H2
* Console link: http://localhost:8080/h2-console
* Database name:jdbc:h2:mem:testdb
* User: sa
* Pass:

#CURL
## Create a cfs event:
## Search cfs: 
curl -X GET "http://localhost:8080/rest/api/v1/cfs/2/detail" -H  "accept: */*"
