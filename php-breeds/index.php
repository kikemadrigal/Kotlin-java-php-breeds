<?php
//VERSION DEVELOPMENT
/**
 * Para la producción: 
 * 1.Cambia el archivo index.php por la versión producción o desarrollo
 * 2.Cambia la variable de entorno PRODUCTION que está en .env
 * 
 */
/*para trabajr con rutas:
1.Modicamos el archivo de host de windows(abrelo como admimistrador) que están en C:\Windows\System32\drivers\etc\hosts:
#---------------------
#   virtual hosts
#--------------------
127.0.0.1	miweb.es

2.Modificamos los host virtuales de apache que están en C:\xampp\apache\conf\extra\httpd-vhosts.conf
<VirtualHost *:80>
    DocumentRoot "C:/xampp/htdocs/miweub"
    ServerName miweub.es
</VirtualHost>
*/
//El index hace de enrutador
session_start();
/*
Mostrar errores
Desde el archivo php.ini

error_reporting = E_ALL & ~E_DEPRECATED & ~E_STRICT
display_errors = On
En este caso, indicamos que nos
 */
/* 
https://www.php.net/manual/en/function.error-reporting.php
variables or catch variable name misspellings ...)
error_reporting(E_ERROR | E_WARNING | E_PARSE | E_NOTICE);
Report all PHP errors
error_reporting(E_ALL);
*/
error_reporting(E_ALL);
//error_reporting(E_ALL);
ini_set('display_errors', '1');

require_once("./app/config/env.php");
require_once("./app/Routes.php");
require_once("./app/controllers/BaseController.php");
require_once("app/controllers/ErrorController.php");
require_once("app/controllers/ScoreController.php");
//Los controladores que están asociados a vistas se requieren atumáticamente
require_once("./views/View.php");

require_once('./app/util/Util.php');
require_once('./app/util/StringManager.php');
//require_once('./app/util/FilesManager.php');
//include_once("./app/util/RegisterValidator.php");

include_once("./app/models/BreedCat.php");
include_once("./app/models/BreedDog.php");
include_once("./app/models/SpecieFish.php");
include_once("./app/models/Cat.php");
include_once("./app/models/Dog.php");
include_once("./app/models/Fish.php");
include_once("./app/models/Score.php");
//include_once("./app/models/FileGame.php");
//include_once("./app/models/ScreenShotGame.php");
//include_once("./app/models/VideoGame.php");
//include_once("./app/models/WebGame.php");
include_once("./app/models/User.php");
include_once("./app/models/Multimedia.php");

//include_once("./app/data/FileGameRepository.php");
//include_once("./app/data/ScreenShotGameRepository.php");
//include_once("./app/data/VideoGameRepository.php");
//include_once("./app/data/WebGameRepository.php");
require_once("./app/data/UserRepository.php");
require_once("./app/data/ScoreRepositoty.php");
//include_once("./app/data/ViewsUsersRepository.php");
require_once('./app/data/BreedCatRepository.php');
require_once('./app/data/BreedDogRepository.php');
require_once('./app/data/SpecieFishRepository.php');
require_once('./app/data/CatRepository.php');
require_once('./app/data/DogRepository.php');
require_once('./app/data/FishRepository.php');
include_once("./app/data/MultimediaRepository.php");

include_once("./app/database/MysqliClient.php");
//include_once("./app/database/SQLiteClient.php");
//include_once("./app/database/PdoSQLiteClient.php");
//include_once("./app/database/PdoMySQLClient.php");


$routes=new Routes();









?>


		

