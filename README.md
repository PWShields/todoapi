
# Tasks To Do
 November 2017

##### Implements Mandatory Feature Set

1. Tasks: GET validateBrackets

2. Todo: POST todo

3. Todo: GET todo

4. Todo: PATCH todo (although maybe a PUT would be better, if we are being extremely pedantic the difference between the two is that PATCH only replaces the values specified while a PUT might replace the entire object thereby potentially loosing existing values, however it really depends on matching the business use-case with the implementation?)


##### Implements Optional Feature Set

1. Clean code
2. Unit tests
3. Documentation (this file)

##Technologies

- Java
- Spring MVC,Boot
- Spock
- Maven

## URLS

### Local

http://localhost:8081

### Dev

https://powerful-basin-57715.herokuapp.com/

NB This is a Free Heroku dyno which means it goes to sleep during periods of activity
so you may need to wake it up with an initial request sometimes

## Usage

Note we are using an in memory database so you will have to add a record with a POST
before you can GET or PATCH it. If the service is restarted any in memory data will
be gone.

### API Usage
	   
	   Content-Type: application/json

	   GET http://localhost:8081/tasks/validateBrackets?input=ldldld
	   
	   GET http://localhost:8081/todo/1
	   
	   POST http://localhost:8081/todo    body:  { "text": "Finish the API" }
	   
	   PATCH http://localhost:8081/todo/1   body: { "text: "Finished the API" }


### Running Locally

From an IDE run the TasktodoApplication class 

Note that we are using Spring Profiles for configuration, this means
you will need to make sure "application.properties" is pointing at
"application-local.properties" when running locally.


### Run from command line

java -jar tasktodo-1.0.jar

This project uses Maven as its build tool.

## Tests

### Command line

mvn test 

or run the individual test file
e.g. ValidationServiceSpec


## Notes

1. To build this project you need Maven. To run this project you need Java 8.













