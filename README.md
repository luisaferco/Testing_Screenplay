
# Introduction
Testing project using Screenplay pattern is executing using WebDriver Chrome, IE explorer, and it has also some api and desktop test 


# Requerements
+ Java JDK 1.8 y Gradle using version 4.7.

It will be specifying the requirements for each testing types:

## Web
The pages that are using there are Linio Shopping Online and Smart Academy. The drivers they are set on path 
´resources/webdriver´
The feature files was creating they have test scenarios.
Linio are executing using Chrome Driver. Setting by default from serenit.properties file
Smart are executing using IE Explorer, Setting throw @driver tag to run it with IExplorer driver

## Rest
The rest Services Users and Countries are exposed to <https://jsonplaceholder.typicode.com/users > and <https://restcountries.eu/rest/v2/name/united>

## Desktop
Calculator App using WinAppDriver that must have run it from local computer

# Run
To compile
```
gradle clean build -x test
```

# Contribute
TODO: Luisa Fernanda Colorado
