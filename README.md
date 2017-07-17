# Random Beer App 

The Random Beer App is a Spring Boot application with a Rest API. The data layer is using spring data
repository and JPA with an in-memory HSQL database.

The front end is done with html5, bootstrap CSS for responsive mobile frendly design. 

To build and start the app, open a command window in the root directory and run the following commands:

- mvn package

- cd target

- java -jar Random-Beer-App-0.1.0.jar


**api:** http://localhost:8080/api/getRandomBeer

**home page:**  http://localhost:8080/index.html


## How I could make this app better in the future

- I could add a MySQL database to replace the in memory HSQL database. The HSQL database only takes at max 100 characters into a field, which limits the amount of data you can put into it.

- I could add images to make it look better.

- I could add more to the database as it is very small now. 
