# FMS
## Feedback Management Service

This repository contains demonstration project providing REST API for management of user's feedback typically given for example
on anonymous forums, company pages or product portals.

As described above this service only provides REST API, thus there is no user interface. UI module is supposed to be chosen and implemented by
FMS's final user.

FMS's API is very intuitive and easy to use. Feedback management works with anonymous user so there is no need of registration and
login. Whole concept of feedback in this service works mainly with username of it's author and message which is going do be sent.

### Technologies and Frameworks

Core technology of this project is [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html)
and it's associated frameworks. Whole application runs on [Spring Boot 1.5](https://projects.spring.io/spring-boot/) which is using
[Spring 4.3](https://spring.io/). Used application container is [Tomcat 8](https://tomcat.apache.org/tomcat-8.5-doc/index.html). 

Database management and initialization there is [Liquibase 3.5](http://www.liquibase.org/). As an build tool application uses
[Maven 3](https://maven.apache.org/index.html).
As this projects exists only for demonstration purposes DB layer is covered by in-memory DB, specifically
[H2 1.4](http://www.h2database.com/html/main.html). 

### Clone & Build
After cloning repository and choosing right branch first thing to do is to build the project through the common command:
```mvn install``` in home folder of cloned repo.
For the first time Maven will load all dependencies needed for FMS so it may take a while.

### Application startup
After build there is only one thing left and it's application startup with Spring Boot. You can do so one of 2 following ways.

#### Using IDE
By running main class named FMSApplication.

#### From the command line
In the home folder of cloned repository run:
```java -jar target/fms-1.0-SNAPSHOT.jar```

> There is system property for defining environment which application is running in. In default settings application will
start on "local" environment. If you want to change it e.g. to int you need to specify it in VM options like:
```-Denv=int```

### REST API
For information about API see [FMS's API page](https://github.com/m-mato/fms/wiki/FMS---API).
