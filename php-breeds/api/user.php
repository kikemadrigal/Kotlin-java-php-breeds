<?php
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
Class UserApi {}
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
    $consulta=($name==null)?"Select * from users":"Select * from users WHERE name='$name' or email='$name'";
    $resultado=$basededatos->ejecutar_sql($consulta);

    if($resultado){
        $Users=array();
        while ($linea =$resultado->fetch_assoc()) 
        {
            $Users[]=$linea;
        }
    }
    $basededatos->desconectar();
    echo json_encode($Users);
}

/*
function insert($basededatos){
    $data=json_decode(file_get_contents("php://input"), true);
    $name=$data["name"];
    $password=$data["password"];
    $role=$data["role"];
    $email=$data["email"];
    $realName=$data["realName"];
    $surname=$data["surname"];
    $web=$data["web"];
    $validate=$data["validate"];
    $counter=$data["counter"];
    $date=$data["date"];
    $view=$data["view"];
    $token=$data["token"];
    $observations=$data["observations"];
    //print_r($data);
    $consulta ="INSERT INTO users values (null,'$name','$password','$role','$email','$realName','$surname','$web','$validate','$counter','$date',' $view','$token','$observations')";
    $resultado=$basededatos->ejecutar_sql($consulta);

    if($resultado){
        $dato['id']=$basededatos->getInsertId();
        echo json_encode($dato);
    }else{
        echo json_encode(array('error'=>'error creating user'));
    }
}


function update($basededatos,$id){
    $data=json_decode(file_get_contents("php://input"), true);
    $name=$data["name"];
    $password=$data["password"];
    $role=$data["role"];
    $email=$data["email"];
    $realName=$data["realName"];
    $surname=$data["surname"];
    $web=$data["web"];
    $validate=$data["validate"];
    $counter=$data["counter"];
    $date=$data["date"];
    $view=$data["view"];
    $token=$data["token"];
    $observations=$data["observations"];
    $consulta ="UPDATE users SET name='$name', password='$password', role='$role', email='$email', realName='$realName', surname='$surname',web='$web',validate='$validate',counter='$counter',date='$date',view='$view',token='$token',observations='$observations' WHERE id=$id";
    $resultado=$basededatos->ejecutar_sql($consulta);
    if($resultado){
        echo json_encode(array('Mmssage'=>'updated user'));
    }else{
        echo json_encode(array('error'=>'error updating user'));
    }
}
*/



/*
function delete($basededatos,$id){
    //echo "El id a borrar es ".$id;
    $consulta ="DELETE FROM users WHERE id=$id";
    $resultado=$basededatos->ejecutar_sql($consulta);
    if($resultado){
        echo json_encode(array('Mmssage'=>'deleted user'));
    }else{
        echo json_encode(array('error'=>'error deleting user'));
    }
}
*/





?>