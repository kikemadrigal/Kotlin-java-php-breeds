<?php include_once("./views/templates/document-start.php");
if(!empty($this->message)) echo $this->message;
else{
    echo "<h2>Cats</h2>";
    if(empty($this->cats)){
        echo "<p>Tu lista de gatos está vacía</p>";
    }else{
        foreach ($this->cats as $posicion=>$cat){
            echo "<div class='row'>";
                echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
                    echo "<p class='mx-auto'><a href='".PATHSERVER."Cat/show/".$cat->get_id()."'><img src='".PATHSERVERSININDEX.$cat->get_path_image()."' class='img-fluid' style='max-height:500px' /></a></p>";
                echo "</div>";
                echo "<div class='col-md-4 col-sm-12 '>";
                    echo "<h4>Nombre: ".$cat->get_name_es()."</h4>";
                    echo "<a href='".PATHSERVER."Cat/update/".$cat->get_id()."'><img src='".PATHSERVERSININDEX."media/icon_edit.png' width=25px /></a>";
                echo "</div>";
            echo "</div>";
        }
    }
    echo "<h2>Dogs</h2>";
    if(empty($this->dogs)){
        echo "<p>Tu lista de perros está vacía</p>";
    }else{
        foreach ($this->dogs as $posicion=>$dog){
            echo "<div class='row'>";
                echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
                    echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$dog->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
                echo "</div>";
                echo "<div class='col-md-4 col-sm-12 '>";
                    echo "<h4>Nombre: ".$dog->get_name_es()."</h4>";
                    echo "<a href='".PATHSERVER."Dog/update/".$dog->get_id()."'><img src='".PATHSERVERSININDEX."media/icon_edit.png' width=25px /></a>";   
                echo "</div>";
            echo "</div>";
        }
    }
    echo "<h2>fish</h2>";
    if(empty($this->fishs)){
        echo "<p>Tu lista de peces está vacía</p>";
    }else{
        foreach ($this->fishs as $posicion=>$fish){
            echo "<div class='row'>";
                echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
                    echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$fish->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
                echo "</div>";
                echo "<a href='".PATHSERVER."Fish/update/".$fish->get_id()."'><img src='".PATHSERVERSININDEX."media/icon_edit.png' width=25px /></a>";   
                echo "<div class='col-md-4 col-sm-12 '>";
                    echo "<h4>Nombre: ".$fish->get_name_es()."</h4>";
    
                echo "</div>";
            echo "</div>";
        }
    }
}

include_once("./views/templates/document-end.php");?>