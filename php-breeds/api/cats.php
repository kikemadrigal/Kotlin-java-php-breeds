<?php
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class BreedCatApi {}
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
    $consulta="Select * from cat where creator_id=1";
    $resultado=$basededatos->ejecutar_sql($consulta);

    if($resultado){
        $Cats=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $Cats[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($Cats);
}


function insert($basededatos){
    $data=json_decode(file_get_contents("php://input"), true);
    $name=$data["name"];
    print_r($name);
}






?>