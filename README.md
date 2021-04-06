#Call for service

## Architecture
![Screenshot](Architecture.png)

# Entity table
![Screenshot](Domain.png)

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

#How to run application
    Just run CfsApplication.java
#Login step
* Call this CURL to receive the token
    
    


#Solution for 
##  User should be able to create a CFS with the following information: event number, event type (with type code), event time, dispatch time, responder:
*

## Search cfs: 
curl -X GET "http://localhost:8080/rest/api/v1/cfs/2/detail" -H  "accept: */*"

#Technical stack

#API  Documentation
Swagger use to help user can execute the rest API with documentation
Link: <http://localhost:8080/swagger-ui.html>
![Screenshot](swagger.png)

#H2
* Console link: http://localhost:8080/h2-console
* Database name:jdbc:h2:mem:testdb
* User: sa
* Pass: