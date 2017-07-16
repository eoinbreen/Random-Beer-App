"# Random Beer App" 

The Random Beer App is a Spring Boot application with a Rest API. The data layer is using spring data
repository and JPA with an in-memory HSQL database.
The front end is done with html5, bootstrap CSS for responsive mobile frendly design. 

* To build and start the app
mvn package
cd target
java -jar gs-spring-boot-0.1.0.jar

* api http://localhost:8080/api/getRandomBeer
* access the home page with http://localhost:8080/index.html

