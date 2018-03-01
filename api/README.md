
run embedded tomcat

$ start_postgres
$ mvn clean package

$ java -jar -Dspring.profiles.active=prod  ~/IdeaProjects/taxonomy-api/target/taxonomy-api-0.0.1-SNAPSHOT.jar

$ mvn spring-boot:run  -Drun.jvmArguments="-Dspring.profiles.active=prod"

 server.port:
 ./target/classes/application.properties
 
run on external servlet container
 
c.f https://www.evernote.com/shard/s271/nl/39813785/91139fdc-2916-49a3-942f-69208e29644b/

$ mvn compile war:war
$ docker cp ~/IdeaProjects/course-api-db/target/<arteefactid>.war tomcat:/usr/local/tomcat/webapps/

see param options
$ mvn spring-boot:help -Ddetail=true 

$ see spring boot auto-config, e.g matched dependencies
mvn spring-boot:run -Drun.arguments=--debug
