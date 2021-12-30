# How to run
First time you execute the docker file you must run the following command from amt-login-microservice root 
`docker run --rm -u "$(id -u):$(id -g)" -v $(pwd):/var/www/html -w /var/www/html laravelsail/php81-composer:latest composer install --ignore-platform-reqs`
 otherwise you'll get some errors

* copy the file .env.example into .env
* update/install dependencies `docker exec my_garden_login-microservice_1 composer install`
* generate app secret `docker exec my_garden_login-microservice_1 php artisan key:generate`
* generate jwt secret `docker exec my_garden_login-microservice_1 php artisan jwt:secret`
* update migrations `docker exec my_garden_login-microservice_1 php artisan migrate:fresh --seed`

Now you should be able to reach the app through http://localhost
