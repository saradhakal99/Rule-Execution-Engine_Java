# Rule Execution Engine
## _Rule Execution Engine for Natural rule Execution and used for Recommendation_

Rule based engine is spring boot application, underline uses java 8 and build based on restful api.

Here for a example, took three params for the rules [city, age and language]. 
Using these oarams created different rules and when user pass the params the rules get executed based on these params.

For simplicity in response giving the rule id and rule definition which are successfully executed and returned true.

## Features

- Adding complex rules
- Adding rule in natural language
- Execution of rules based on passed user params
- Extendable solution for any kind of future changes
- Extendible for using in Rule Based recommendation engine

Rule Execution Engine is restfu api, and extendable solution for the any ind of defined rule and its execution.

## Tech
Rule Execution Engine uses a number of open source projects to work properly:

- [Java] - Java 1.8
- [Spring Boot] - Spring Boot 2.5.6
- [Maven] - Maven 3.9.x for Repo and build.
- [Eclipse] - Development Tool

## Installation

Spring boot provides the quick api development.
Eclipse can be used for development purpose and the code can be executed from run command for "run as a java application" for main class : "RuleExecutionEngineApplication". 

#### Building for source

Goto to source folder and using maven clean build:
-  mvn clean install

Goto target folder and there will be a jar file created "ruleengine-0.0.1-SNAPSHOT.jar".

this jar file can be deployed and run for production deployment.

> java -jar ruleengine-0.0.1-SNAPSHOT.jar

#### Rule Updates:

Use the file "RuleDefinition.java" to add further rules.


## APIs

- About API

> curl -X GET 'http://localhost:8082/ruleengine/about'


> Response
{
    "serviceName": "Rule Engine",
    "description": "Rule Execution Engine",
    "version": "1.0.0",
    "buildDate": "01-11-2021",
    "copyRight": "Copyright Info",
    "summary": "Rule Execution Engine App"
}

- Rule Execution API with Url Params

> curl -X GET 'http://localhost:8082/ruleengine/rule/v0/execute?city=phoenix&age=19&lang=english'

> Response

{
    "Status": "Success",
    "RuleId :california:18+:english": "Rule :exeEQ('california', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)",
    "Message": "Execution Results as below",
    "RuleId :nework:18+:english": "Rule :exeEQ('nework', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)",
    "RuleId :chicago:18+:english": "Rule :exeEQ('chicago', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)",
    "RuleId :dallas:18+:english": "Rule :exeEQ('dallas', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)",
    "RuleId :phoenix:18+:spanish|english|russian": "Rule :exeEQ('phoenix', #city) && exeGTE( #age, 18) && exeIN(#lang, 'english,spanish,russian')",
    "RuleId :phoenix:18+:english": "Rule :exeEQ('phoenix', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)"
}

- Rule Execution API with Path Variable

> curl -X GET 'http://localhost:8082/ruleengine/rule/v0/execute/dallas/19/spanish'

> response

{
    "Status": "Success",
    "Message": "Execution Results as below",
    "RuleId :dallas:18+:TAM": "Rule :exeEQ('dallas', #city) && exeGTE( #age, 18) && exeEQ('spanish' , #lang)",
    "RuleId :dallas:18+:english": "Rule :exeEQ('dallas', #city) && exeGTE( #age, 18) || exeEQ('english' , #lang)"
}

##Swagger

http://localhost:8082/ruleengine/swagger-ui.html


## License
---

