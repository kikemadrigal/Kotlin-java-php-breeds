<?php
//Este archivo nos devilverá una especie o todas las especies
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class SpecieFishApi {}
$basededatos= new MysqliClient();
$basededatos->conectar_mysql();
$metodo=$_SERVER['REQUEST_METHOD'];
//http://localhost/api/User.php
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





function select($basededatos, $name){
    //$consulta=($name==null)?"Select * from specie_fish":"Select * from specie_fish WHERE name='$name'";
    $consulta="Select * from specie_fish";
    $resultado=$basededatos->ejecutar_sql($consulta);

    if($resultado){
        $speciesFiesh=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $speciesFiesh[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($speciesFiesh);
}
/*function select($basededatos){
    $consulta="Select * from specie_fish";
    $resultado=$basededatos->ejecutar_sql($consulta);
    
   
        $speciesFish=array();
        while ($linea = mysqli_fetch_array($resultado)) 
        {
            $specieFish=new SpecieFishApi();
            $specieFish->id=$linea['id'];
            $specieFish->name=$linea['name'];
            $specieFish->description=$linea['description'];
            $specieFish->url_wiki=$linea['url_wiki'];
            $speciesFish[]=$specieFish;
        }
        $basededatos->desconectar();
        echo  json_encode($speciesFish, JSON_UNESCAPED_UNICODE);
}*/


?>
