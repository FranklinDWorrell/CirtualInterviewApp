## Description
This project implements a RESTful chat server with additional support for creating, editing, deleting, and searching a basic profile for users. 

## To Compile and Run
1. Clone this repository. 
1. From inside the top-level directory of the repository, build and run with Maven: `mvn clean install spring-boot:run`. 

## To Test 
1. Open Postman (see https://www.getpostman.com/ to download and install) and import the Collection at `src/test/resources/ChatServer.postman_collection.json`. 
1. Send the `Register User` request in Postman. Verify that a user with userName `RickDeckard` is returned (the only field is `userName`).
1. Send the `Get User` request. Verify that user with userName `Sophia` is returned. 
1. Send the `Get All Users` request. Verify that a list of 7 users is returned. 
1. Send the `Get Messages` request. Verify that a list of 2 messages is returned. 
1. Send the `Send Message` request. Verify that a message is returned. Resend the `Get Messages` request. It should now return 3 messages, including the one just sent. 
1. Send the `Get User Profile` request. Verify that a profile with quote `"Reach for the Sky(lar)!"` belonging to user `"IAmTheWalrus"` is returned. 
1. Send the `Update User Profile` request. Verify that the city, state, and quote fields have changed in the profile. Resend the `Get User Profile` request for additional verification. 
1. Send the `Delete User Profile` request. Verify that the previously modified profile is returned. Resend the `Get User Profile` request and verify that it returns nothing without error. 
1. Send the `Create User Profile` request. Verify that a profile is returned. Resend the `Get User Profile` request and verify that the profile's quote is now `"This profile has been recreated!"`.       

## Associated Documentation 
1. See `src/main/resources/db.migration` for the scripts that populate the in-memory MySQL database.  
1. For documentation of endpoints, with the application running, open a browser and navigate to `http://localhost:8080/swagger-ui.html#/` for Swagger documentation. 
1. A dump of the in-memory MySQL database AFTER the above testing steps were completed is included in the top-level directory of the repository as `mySQLDump.txt`.  