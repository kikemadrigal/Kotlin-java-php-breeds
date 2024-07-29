<?php
//Este archivo nos devilverá una raza o todas las razas
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class BreedDogApi {}
$basededatos= new MysqliClient();
$basededatos->conectar_mysql();
$metodo=$_SERVER['REQUEST_METHOD'];
//http://localhost/api/breedDogs.php
$path=isset($_SERVER['PATH_INFO'])?$_SERVER['PATH_INFO']:"/";
$buscarName=explode("/",$path);
$name=($path!=="/")?end($buscarName):null;

switch($metodo){
    case "GET":
        select($basededatos,$name);
        break;
    /*case "POST":
        insert($basededatos);
        break;
    case "PUT":
        update($basededatos, $id);
        break;
    case "DELETE":
        delete($basededatos, $id);
        break;*/
}





function select($basededatos){
    $consulta="Select * from dog";
    $resultado=$basededatos->ejecutar_sql($consulta);

    if($resultado){
        $dogs=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $dogs[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($dogs);
}

