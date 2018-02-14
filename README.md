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
