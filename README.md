# Description
This project implements a RESTful chat server with support for creating, editing, deleting, and searching a basic profile for users. 

## To Compile and Run
1. Clone this repository. 
1. From inside the top-level directory of the repository, build and run with Maven: `mvn clean install spring-boot:run`. 

## To Test 
1. Open Postman (see https://www.getpostman.com/ to download and install) and import the Collection at `src/main/resources/...`. 
1. Send the `Register User` request in Postman. Verify that a user with userName `RickDeckard` is returned (the only field is `userName`).
1. Send the `Get User` request in Postman. Verify that user with userName `Sophia` is returned. 
1. Send the `Get All Users` request in Postman. Verify that a list of  

## Associated Documentation 
1. Included in this repo, you will find... 
1. For documentation of endpoints, with the application running, open a browser and navigate to `http://localhost:8080/swagger-ui.html#/` for Swagger documentation. 