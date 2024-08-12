<?php
header('Content-Type: application/json');
include_once("../app/database/MysqliClient.php");
require_once("../app/config/env.php");
require_once ("../libraries/PHPMailer/Exception.php");
require_once ("../libraries/PHPMailer/PHPMailer.php");
require_once ("../libraries/PHPMailer/SMTP.php");
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;
function sendEmail($name, $type, $idAnimal){
    $mail = new PHPMailer(true);
    try {
        $mail->SMTPDebug = 0;                      //Enable verbose debug output
        $mail->isSMTP();                                            //Send using SMTP
        $mail->Host       = EMAILHOST;                     //Set the SMTP server to send through
        $mail->SMTPAuth   = true;      //SMTP username
        $mail->Username   = EMAILSERVER;                     //SMTP username
        $mail->Password   = EMAILPASSWORD;                               //SMTP password
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
        $mail->SMTPSecure = 'ssl';
        $mail->Port       = 465;        
        $ip=$_SERVER['REMOTE_ADDR'];       
        //Desde donde se va a enviar
        $mail->setFrom("adm@tipolisto.es", "breeds.tipolisto.es");
        //a quien se le va a enviar
        $mail->addAddress("adm@tipolisto.es", $name);    
        $mail->isHTML(true);                                  //Set email format to HTML
        $mail->Subject =  "Nueva foto subida en breeds.tipolisto.es";
        $mail->Body    = "Usuario:".$name."<br>Type: ".$type."<br>idAnimal: ".$idAnimal;
        $mail->send();
    } catch (Exception $e) {
        
    }
}
$usuario=$_POST['nameUser'];
$idUsuario=0;
$name=$_POST['name'];
$type=$_POST['type'];
$breed=$_POST['breed'];
//$breed=0;
$family=$_POST['family'];
$description=$_POST['description'];
$year_of_birth=$_POST['year_of_birth'];
$sex=$_POST['sex'];
$address=$_POST['address'];
$image= $_POST['image'];
$ruta_imagen="media/imagesUsers/".$usuario."/".$name.".jpg";
$date = date('Y-m-d H:i:s');
//Creamos el directorio del usuario si no existe
if (!file_exists("../media/imagesUsers/".$usuario)) {
    mkdir("../media/imagesUsers/".$usuario, 0777, true);
}
//Ponemos que para guardar l aimagen suba un directorio y lo guarde en media/imagesUsers
$fueguardada=file_put_contents("../media/imagesUsers/".$usuario."/".$name.".jpg", base64_decode($image));

$basededatos= new MysqliClient();
$basededatos->conectar_mysql();

//1. Obtenemos el usuario por su nombre
$consulta  = "SELECT id FROM users WHERE name='".$usuario."' ";
$resultado=$basededatos->ejecutar_sql($consulta);
$total_registros = mysqli_num_rows ($resultado);
$sql="";
while ($linea = mysqli_fetch_array($resultado)) 
{
    $idUsuario=$linea['id'];
}

if($type=="Cat"){
    $sql="INSERT INTO cat VALUES ( '', '"
        .$name."', '"
        .$name."', '"
        .$breed."', '"
        .$family."', '"
        .$description."', '"
        .$description."', '"
        .$year_of_birth."', '"
        .$sex."', '"
        .$address."', '0', '0', '0', '"
        .$ruta_imagen."', '0', '"
        .$date."', '"
        .$idUsuario."') ";	
    
}else if($type=="Dog"){
    $sql="INSERT INTO dog VALUES ( '', '"
        .$name."', '"
        .$name."', '"
        .$breed."', '"
        .$family."', '"
        .$description."', '"
        .$description."', '"
        .$year_of_birth."', '"
        .$sex."', '"
        .$address."', '0', '0', '0', '"
        .$ruta_imagen."', '0', '"
        .$date."', '"
        .$idUsuario."') ";	
}else if($type=="Fish"){
    $sql="INSERT INTO fish VALUES ( '', '"
        .$name."', '"
        .$name."', '"
        .$breed."', '0', '0', '"
        .$ruta_imagen."', '0', '"
        .$date."', '"
        .$idUsuario."', '"
        ."') ";	
}

$success=$basededatos->ejecutar_sql($sql);
$idInsert=$basededatos->getInsertId();
sendEmail($name, $type, $idInsert);
$basededatos->desconectar();
echo json_encode($success);





    
?>