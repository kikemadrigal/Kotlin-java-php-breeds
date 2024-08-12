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
					echo "<a class='btn-success' href='".PATHSERVER."Dog/showRandom'>Puntuar otro</a>";
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
					echo "<p><a href='".PATHSERVER."Dog/showRanking'>Mostrar ranking bellezas</a>";

					echo "<p>Puntos: ".$dog->get_total_points()."</p>";
					echo "<p>Puntuar: ";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/1'> 1 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/2'> 2 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/3'> 3 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/4'> 4 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/5'> 5 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/6'> 6 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/7'> 7 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/8'> 8 </a>";
						echo "<a href='".PATHSERVER."Dog/updateBeauty/".$dog->get_id()."/9'> 9 </a>";
					echo "</p>";
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