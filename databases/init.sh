
mysql -e "CREATE DATABASE IF NOT EXISTS \`${MYGARDEN_DB}\`;" -u root --password=${MYSQL_ROOT_PASSWORD}
mysql -e "GRANT ALL PRIVILEGES ON  \`${MYGARDEN_DB}\`.* TO '${MYSQL_USER}'@'%';" -u root --password=${MYSQL_ROOT_PASSWORD}

mysql -e "CREATE DATABASE IF NOT EXISTS \`${LOGIN_DB}\`;" -u root --password=${MYSQL_ROOT_PASSWORD}
mysql -e "GRANT ALL PRIVILEGES ON \`${LOGIN_DB}\`.* TO '${MYSQL_USER}'@'%';" -u root --password=${MYSQL_ROOT_PASSWORD}

