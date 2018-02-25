start_postgress

# run with embeded tomcat

mvn clean package

java -jar ~/IdeaProjects/taxonomy-api/target/taxonomy-api-0.0.1-SNAPSHOT.jar


# server.port:
# ./target/classes/application.properties
# 
# run on external servlet container
# 
# https://www.evernote.com/shard/s271/nl/39813785/91139fdc-2916-49a3-942f-69208e29644b/

mvn compile war:war
docker cp ~/IdeaProjects/course-api-db/target/<arteefactid>.war tomcat:/usr/local/tomcat/webapps/

# configuration based on spring profiles:
# either use a vm option e.g -Dspring.profiles.active=dev
# or export spring_profiles_active=dev
# or ActiveProfile("dev)

# see param options
mvn spring-boot:help -Ddetail=true 

# see spring boot auto-config, e.g matched dependencies
mvn spring-boot:run -Drun.arguments=--debug

#       spring-boot-starter-web
# reload classes dynamically, automatic refresh of html content (via livereload - cmd F9 to see html changes)
# intellij build project automtatically, connect
