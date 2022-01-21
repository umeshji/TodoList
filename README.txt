The project is split into UI (Angular) and Backend (Spring Boot) componet

Steps to build the project

Starting Angular App
git clone https://github.com/umeshji/TodoList.git
   cd TodoList (code for both project resides here)
   cd todo-angular-app/todo (angular project folder)
    npm install		     (install dependencies)
    ng serve   		     (will start angular app at port4200)
    
Login to angular app (http://localhost:4200/login)
enter evaluation  as both user name password

Starting SpringBoot App		
    cd todo-rest-services	(spring boot project folder where code is cloned)
    mvn clean install		(build the project)
    mvn spring-boot:run		(run the project)
    Access/Test endpoints via postman (E.g localhost:8080/jpa/users/evaluation/todos)

We can package both the project as FAT war and deploy on tomcat or have docker image for each of them.	
 
