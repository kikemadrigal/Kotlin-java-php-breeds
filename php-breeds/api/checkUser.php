<?php
    header('Content-Type: application/json');
    include_once("../app/database/MysqliClient.php");
    require_once("../app/config/env.php");
    $usuario=$_POST['name'];
    $clave=$_POST['password'];

    $basededatos= new MysqliClient();
    $basededatos->conectar_mysql();
    //1. Obtenemos el usuario por su nombre
    $consulta  = "SELECT * FROM users WHERE name='".$usuario."' ";
    $resultado=$basededatos->ejecutar_sql($consulta);
    $total_registros = mysqli_num_rows ($resultado);
    if($total_registros==false){
        //El nombre de usuario no existe.
        $mensaje= "0";
    }else{
        while ($linea = mysqli_fetch_array($resultado )) 
        {
            if($linea['name']==$usuario){
                //2.Comprobamos su contraseña
                if($linea['password']==sha1($clave)){
                    //Si el usurio no está validado...
                    if( $linea['validate'] == '0'){
                        //El usuario necesita ser validado para continuar, vaya a:PATHSERVER."auth/mailValidation/".$linea['name']."/".$linea['password'];
                        $mensaje="3";
                    //Si el usurio si está validado...
                    }else{
                        $fecha = new DateTime();
                        $bd= new MysqliClient();
                        $bd->conectar_mysql();
                        //Usuario validado devuelve 10  
                        $mensaje="10";                 

                    }
                }else{
                    //"La clave del usuario ".$usuario." es incorrecta.<br>";
                    $mensaje="2";
                }
            }
        }
    }
    $basededatos->desconectar();
    $data= json_encode($mensaje);  
    echo $data."\n";

?>