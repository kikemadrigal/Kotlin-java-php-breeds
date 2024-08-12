<?php 
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;




function sendMenssageAdmin($name,$type,$idAnimal){
    require "./libraries/PHPMailer/Exception.php";
    require "./libraries/PHPMailer/PHPMailer.php";
    require "./libraries/PHPMailer/SMTP.php";
    $mail = new PHPMailer(true);
    try {
        $mail->SMTPDebug = 0;                      //Enable verbose debug output
        $mail->isSMTP();                                            //Send using SMTP
        $mail->Host       = "smtp.ionos.es";                     //Set the SMTP server to send through
        $mail->SMTPAuth   = true;                                   //Enable SMTP authentication
        $mail->Username   = "adm@tipolisto.es";                     //SMTP username
        $mail->Password   = "113por147";                               //SMTP password
        $mail->SMTPSecure = PHPMailer::ENCRYPTION_SMTPS;            //Enable implicit TLS encryption
        $mail->SMTPSecure = 'ssl';
        $mail->Port       = 465;        
        $ip=$_SERVER['REMOTE_ADDR'];       
        //Desde donde se va a enviar
        $mail->setFrom("adm@tipolisto.es", "tipolisto");
        //a quien se le va a enviar
        $mail->addAddress("adm@tipolisto.es", $name);    
        $mail->isHTML(true);                                  //Set email format to HTML
        $mail->Subject =  "Nueva foto subida en breeds.tipolisto.es";
        $mail->Body    = "Usuario:".$name."<br>Type: ".$type."<br>idAnimal: ".$idAnimal;
        $mail->send();
    } catch (Exception $e) {
       
    }
}

?>


