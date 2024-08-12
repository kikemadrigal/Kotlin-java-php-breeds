<?php
    header('Content-Type: application/json');
    include_once("../app/database/MysqliClient.php");
    require_once("../app/config/env.php");
    $usuario=$_POST['name'];
    $clave=$_POST['password'];
    $maxScore=$_POST['score'];
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
                        $mensaje="2000";
                        
                        $fecha = new DateTime();
                        //$bd= new MysqliClient();
                        //$bd->conectar_mysql();
                        //Comprobamos que ya tiene puntuaciones más altas
                        $sqlMaxPointsUser="SELECT score from scores WHERE name='".$usuario."'";
                        $resultadoMaxPointsUser=$basededatos->ejecutar_sql($sqlMaxPointsUser);
                        
                        $encontradaPuntacionMaximaGuardada=false;
                        if(!empty($resultadoMaxPointsUser) && $resultadoMaxPointsUser!=null){
                            while ($lineaMaxPoint = mysqli_fetch_array($resultadoMaxPointsUser)) 
                            {
                                if($maxScore<=$lineaMaxPoint['score']){
                                    $mensaje="5";  
                                    $encontradaPuntacionMaximaGuardada=true;
                                    break;
                                } 
                                
                            }  
                        }else{
                            //El usuario no tiene puntuaciones guardades
                            $mensaje="7";
                        }
                        
                        
                        if(!$encontradaPuntacionMaximaGuardada){
                            $sql="INSERT INTO scores (name, score) VALUES ('".$usuario."', '".$maxScore."')";
                            $success=$basededatos->ejecutar_sql($sql);
                            if($success){
                                $mensaje="1"; 
                            }else{
                                $mensaje="4"; 
                            }    
                        }else{
                            //Encontrada otra puntuación más alta del mismo usuario
                            $mensaje="8";
                        }         
                        
                    }
                    
                }else{
                    //"La clave del usuario ".$usuario." es incorrecta.<br>";
                    $mensaje="2";
                }
            }else{
                //usuario no encontrado
                $mensaje="6";
            }
                
        }
    }

    $basededatos->desconectar();
    $data= json_encode($mensaje);  
    echo $data;
    //echo json_encode($maxScore);
?>