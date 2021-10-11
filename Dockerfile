FROM tomcat:9

COPY ./target/mygarden-1.0-SNAPSHOT.war /usr/local/tomcat/webapps

ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

ENTRYPOINT ["catalina.sh", "jpda", "run"]