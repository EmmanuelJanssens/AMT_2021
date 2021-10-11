#!/bin/bash


#create network if not exist
docker network create --driver bridge amt-aws || true

#run mysql docker
docker run -d -p 3306:3306 --name mygarden-mysql --network=amt-aws -e MYSQL_ROOT_PASSWORD=password mysql;

read -p "Wait at least 10 seconds and Then press enter to continue"

#run tomcat docker 
docker run -itd -p 8080:8080 --name mygarden --network=amt-aws amt/mygarden;


#Command to run container in debug mode
#docker run -it --rm -e JPDA_ADDRESS=*:8000 -e JPDA_TRANSPORT=dt_socket -p 8080:8080 -p 9000:8000 --network=amt-aws --name mygardenn amt/mygarden /usr/local/tomcat/bin/catalina.sh jpda run