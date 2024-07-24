<?php
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class CatApi {}
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
    $consulta="SELECT * FROM cat ORDER BY RAND() LIMIT 1";
    $resultado=$basededatos->ejecutar_sql($consulta);
    if($resultado){
        $cat=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $cat[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($cat);
}


function insert($basededatos){
    $data=json_decode(file_get_contents("php://input"), true);
    $name=$data["name"];
    print_r($name);
}






?>