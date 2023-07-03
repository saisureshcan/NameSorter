# Name Sorter Application

Given a set of names, order that set first by last name, then by any given names the person may have. A name must have at least 1 given name
and may have up to 3 given names. 

## Pre-requisites 

These pieces of software are required for the successful setup and execution of this project

1. Java 11 or Higher 
2. GIT
3. Maven

## Setup

This is a Spring Boot Application

Clone the repository from github to your workspace or through terminal.

GitHub Repo URL: <code> git clone https://github.com/saisureshcan/NameSorter.git </code>

Navigate to the project folder and run <code>mvn clean install</code>

JUnit Tests implemented for the application will execute when you build the application and this is to ensure that the application is running as expected.

## Run

This Sprint Boot Application takes a file name as an argument to start up. If no input argument is provided the application will not work as expected.

The file that needs to be sorted should be in the application directory and should be passed as an argument to the application.

Build the application using <code>mvn build</code> or <code>mvn clean install</code>

To start the application run command <code>mvn spring-boot:run -Dspring-boot.run.arguments=unsorted-names-list.txt</code>

You can replace the filename above with the desired file name that need to be sorted.

If you are executing the application from an IDE make sure to add the input parameter in the <code>Run Configurations</code>

## Notes

1. The input file is expected to contain Names with at least one given name and one last name.
2. The application will discard any names that do not match the above criteria 
3. The application will run only once and stops execution once the name sorting is finished.
4. The application will overwrite the file with sorted names list everytime the application is executed.
5. The application is developed using TDD approach in which the test cases are implemented first and the code was then written to satisfy the tests.
6. This is a very basic application just set out to execute a simple task.
7. If necessary this application can be enhanced to implement more requirements with significant ease.




