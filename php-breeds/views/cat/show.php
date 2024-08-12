<?php
include_once("./views/templates/document-start.php"); 
?>
<div class="container">
    <div class="row">
        <?php
        $cat=$this->cat;
        $breedCatName=$this->breedCatName;
        //echo "en show el breed cat es ".$breedCatName;
        if($cat==NULL) echo "empty cat";
        else{
            if ($cat->get_path_image()!=NULL){
                echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
                    echo "<p><img src='".PATHSERVERSININDEX.$cat->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
                echo "</div>";
                echo "<div class='col-md-4 col-sm-12'>";
                    //echo "<p>".$cat->get_name()."</p>";
                    echo "<h4>Name: ".$cat->get_name_es()."</h4>";
                    if ($breedCatName==NULL)
                        echo "Breed empty";
                    else
                        echo "<p><b>Breed: ".$breedCatName."</b></p>";
                    
                    if($cat->get_family()!=null)
                        echo "<p>Family: ".$cat->get_family()."</p>";
                    if($cat->get_description()!=null)
                        echo "<p>Description: ".$cat->get_description()."</p>";
                    if($cat->get_description_es()!=null)
                        echo "<p>Description_es: ".$cat->get_description_es()."</p>";
                    if($cat->get_year_of_birth()!=null)
                        echo "<p>year of birth: ".$cat->get_year_of_birth()."</p>";
                    $sexo="";
                    if($cat->get_sex()!=null){
                        if($cat->get_sex()==0){
                            $sexo="Femenino";
                        }else{
                            $sexo="Masculino";
                        }
                        echo "<p>sex: ".$sexo."</p>";
                    }
                    if($cat->get_address()!=null)
                        echo "<p>address: ".$cat->get_address()."</p>";

                    echo "<p>Points: ".$cat->get_points()."</p>";
                    echo "<p>Total points: ".$cat->get_total_points()."</p>";    
                    echo "<p><a href='".PATHSERVER."Cat/showRanking'>Mostrar ranking bellezas</a>";
                echo "</div>";
            }else{
                echo "Not data";
            }
        }	
        ?>
    </div>
</div>





<?php include_once("./views/templates/document-end.php"); ?>