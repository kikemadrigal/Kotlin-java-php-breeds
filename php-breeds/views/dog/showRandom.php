<?php
include_once("./views/templates/document-start.php"); 
?>
<div class="container">
  <div class="row">
    <?php
	$dog=$this->dog;
	$breedDog=$this->breedDog;
	if($dog==NULL) echo "empty dog";
		else{
			if ($dog->get_path_image()!=NULL){
				echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
					echo "<p><img src='../../".$dog->get_path_image()."' class='img-fluid'/></p>";
				echo "</div>";
				echo "<div class='col-md-4 col-sm-12'>";
					//echo "<p>".$dog->get_name()."</p>";
					echo "<p><b>Nombre: </b>".$dog->get_name_es()."</p>";
					echo "<p><b>Raza: </b><a href='".PATHSERVER."BreedDog/show/".$breedDog->get_id()."'>".$breedDog->get_name()."</a></p>";
					echo "<p><b>Familia: </b>".$dog->get_family()."</p>";
					echo "<p><b>Descripción: </b>".$dog->get_description_es()."</p>";
					echo "<p><b>Año de nacimiento: </b>".$dog->get_year_of_birth()."</p>";
					if($dog->get_sex()==0)
						$sexo="Hembra";
					else
						$sexo="Macho";
					echo "<p><b>Sexo: </b>".$sexo."</p>";
					echo "<p><b>Dirección: </b>".$dog->get_address()."</p>";
					//echo "<p>vaccines".$dog->get_vaccines()."</p>";
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