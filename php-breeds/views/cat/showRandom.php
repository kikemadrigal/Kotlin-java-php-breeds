<?php
include_once("./views/templates/document-start.php"); 

$cat=$this->cat;
$breedCat=$this->breedCat;
?>
<div class="container">
  <div class="row">
	<?php
	if($cat==NULL) echo "empty cat";
		else{
			if ($cat->get_path_image()!=NULL){
				if($cat->get_sex()==0){
					$sexo="Femenino";
				}else{
					$sexo="masculino";
				}
				echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
					echo "<p><img src='../../".$cat->get_path_image()."' class='img-fluid'/></p>";
				echo "</div>";
				echo "<div class='col-md-4 col-sm-12'>";
					//echo "<p>".$cat->get_name()."</p>";
					echo "<p><h4>Nombre: ".$cat->get_name_es()."</h4></p>";
					if($breedCat==NULL) 
						echo "Without breed";
					else
						echo "<p><b>Raza: </b><a href='".PATHSERVER."BreedCat/show/".$breedCat->get_id()."'>".$breedCat->get_name()."</a></p>";
					//<a href='".PATHSERVER."BreedCat/show/".$cat->get_breed_id().">"
					echo "<p><b>Familia: </b>".$cat->get_family()."</p>";
					// echo "<p>Description: ".$cat->get_description()."</p>";
					echo "<p><b>Descripción:: </b>".$cat->get_description_es()."</p>";
					echo "<p><b>Año de nacimineto: </b>".$cat->get_year_of_birth()."</p>";
					echo "<p><b>Sexo: </b>".$sexo."</p>";
					echo "<p><b>Dirección: </b>".$cat->get_address()."</p>";
					//echo "<p>".$cat->get_vaccines()."</p>";
				echo "</div>";
			}else{
				echo "Not data";
			}
		}	
	?>
  </div>
</div>
<?php
include_once("./views/templates/document-end.php"); 
?>