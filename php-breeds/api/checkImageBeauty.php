<?php
header('Content-Type: application/json');
$usuario=$_POST['nameUser'];
$name=$_POST['name'];
$ruta_imagen="../media/imagesUsers/".$usuario."/".$name.".jpg";
$message="0";
//Creamos el directorio del usuario si no existe
if (file_exists($ruta_imagen)) {
    $message="1";
}
echo json_encode($message);
?>