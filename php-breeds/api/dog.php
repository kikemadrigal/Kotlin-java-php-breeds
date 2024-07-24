<?php
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class DogApi {}
$basededatos= new MysqliClient();
$metodo=$_SERVER['REQUEST_METHOD'];
switch($metodo){
    case "GET":
        consultaSelect($basededatos);
        break;
    case "POST":
        insert($basededatos);
        break;
    case "PUT":
        //update($basededatos);
        break;
    case "DELETE":
        //delete($basededatos);
        break;
}





function consultaSelect($basededatos){
    $basededatos->conectar_mysql();
    $consulta="SELECT * FROM dog ORDER BY RAND() LIMIT 1";
    $resultado=$basededatos->ejecutar_sql($consulta);
    if($resultado){
        $dog=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $dog[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($dog);
}


function insert($basededatos){
    $data=json_decode(file_get_contents("php://input"), true);
    $name=$data["name"];
    print_r($name);
}






?>