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
					echo "<p><h4>Name / nombre: ".$dog->get_name_es()."</h4></p>";
					echo "<p><b>Breed / Raza: ".$breedDog->get_name()."</b></p>";
					echo "<p>family".$dog->get_family()."</p>";
					echo "<p>description".$dog->get_description()."</p>";
					echo "<p>year of birth".$dog->get_year_of_birth()."</p>";
					echo "<p>sex".$dog->get_sex()."</p>";
					echo "<p>address".$dog->get_address()."</p>";
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




