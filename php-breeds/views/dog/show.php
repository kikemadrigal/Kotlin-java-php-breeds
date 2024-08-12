<?php
include_once("./views/templates/document-start.php"); 

<div class="container">
  <div class="row">
    <?php
	$dog=$this->dog;
	$breedDog=$this->breedDog;
	if($dog==NULL) echo "empty dog";
		else{
			if ($dog->get_path_image()!=NULL){
				echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
					echo "<p><img src='".PATHSERVERSININDEX.$dog->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
				echo "</div>";
				echo "<div class='col-md-4 col-sm-12'>";
					//echo "<p>".$dog->get_name()."</p>";
					echo "<p><h4>Nombre: ".$dog->get_name_es()."</h4></p>";
					echo "<p><b>Raza: ".$breedDog->get_name()."</b></p>";
					echo "<p>Familia".$dog->get_family()."</p>";
					echo "<p>Descripción".$dog->get_description()."</p>";
					echo "<p>Año de nacimiento".$dog->get_year_of_birth()."</p>";
					echo "<p>Sexo".$dog->get_sex()."</p>";
					echo "<p>Dirección".$dog->get_address()."</p>";
					//echo "<p>vaccines".$dog->get_vaccines()."</p>";
					echo "<p>Puntos".$dog->get_points()."</p>";
					echo "<p>Puntos totales".$dog->get_total_points()."</p>";
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




