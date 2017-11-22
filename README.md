
# Tasks To Do
 November 2017

##### Implements Mandatory Feature Set

1. Tasks: GET validateBrackets

2. Todo: POST todo

3. Todo: GET todo

4. Todo: PATCH todo (although maybe a PUT would be better?)


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

### Production

## Usage


### API Usage
	   
	   Content-Type: application/json

	   GET http://localhost:8081/tasks/validateBrackets?input=ldldld
	   
	   GET http://localhost:8081/todo/1
	   
	   POST http://localhost:8081/todo    body:  { "text": "Finish the API" }

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


## Notes

1. To build this project you need Maven. To run this project you need Java 8.













