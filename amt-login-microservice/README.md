# Login api
This app is a Login api that gives a jwt token if given credentials are correct.

## Available routes
# First run
Before executing the docker file for the first time you must run the following command from amt-login-microservice root directory: `docker run --rm -u "$(id -u):$(id -g)" -v $(pwd):/var/www/html -w /var/www/html laravelsail/php81-composer:latest composer install --ignore-platform-reqs`  
That command is going to create a vendor directory containing all necessary files to run the docker environment.

Once first step done we need to install and configure all dependencies
* Run docker-compose from `My_garden` root directory
* copy the file .env.example into .env in that .env file you can set all environment variables related to the application if needed.
* install dependencies `docker exec -u sail my_garden_login-microservice_1 composer install`
* generate app secret `docker exec -u sail my_garden_login-microservice_1 php artisan key:generate`
* generate jwt secret `docker exec -u sail my_garden_login-microservice_1 php artisan jwt:secret`
* run migrations `docker exec -u sail my_garden_login-microservice_1 php artisan migrate --seed`  
  This will create all tables in the database and populate them with default values.  

After all those steps completed your app should be running on http://localhost

# Next runs
Next time you start your container everything should work fine.

If some changes have been made to the microservice you may have to execute the following commands in order to update your app.
* update dependencies `docker exec -u sail my_garden_login-microservice_1 composer install`
* run migrations `docker exec -u sail my_garden_login-microservice_1 php artisan migrate`
* add new seeds `docker exec -u sail my_garden_login-microservice_1 php artisan db:seed`

# Troubleshoot
If you have any problem related to Laravel configuration please refer to [laravel documentation](https://laravel.com/docs/8.x)
