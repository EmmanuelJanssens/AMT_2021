FROM tomcat:9

COPY ./target/mygarden-1.0-SNAPSHOT.war /usr/local/tomcat/webapps


ENTRYPOINT ["/usr/local/tomcat/bin/catalina.sh", "jpda", "run"]