<?php include_once("./views/templates/document-start.php");?>
<h2>Ranking beauties</h2>
<h3>Cats</h3>
<p><a href='<?php echo PATHSERVER."Cat/showRanking";?>'>Mostrar ranking bellezas gatos</a>
<p><a href='<?php echo PATHSERVER."Cat/showRandom";?>'>Puntuar gatos</a>
<?php
foreach ($this->cats as $posicion=>$cat){
			$breedCat=BreedCatRepository::getByIdName($cat->get_breed_id());  
			echo "<div class='row'>";
			if($cat==NULL) echo "empty cat";
			else{
				if ($cat->get_path_image()!=NULL){
					echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
						echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$cat->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
					echo "</div>";
					echo "<div class='col-md-4 col-sm-12 '>";
						echo "<h4>Nombre: ".$cat->get_name_es()."</h4>";
						//echo "<p><b>Raza: ".$cat->get_breed_id()."</b></p>";
						if($breedCat!=null)
							echo "<p><b>Raza: <a href='".PATHSERVER."BreedCat/show/".$breedCat->get_id()."'>".$breedCat->get_name_es()."</b></a></p>";
						$sexo="";
						if($cat->get_sex()==0){
							$sexo="Femenino";
						}else{
							$sexo="Masculino";
						}
						echo "<p>Familia: ".$cat->get_family()."</p>";
						echo "<p>Descripción: ".$cat->get_description_es()."</p>";
						echo "<p>Año de nacimiento: ".$cat->get_year_of_birth()."</p>";
						echo "<p>Sexo: ".$sexo."</p>";
						echo "<p>Dirección: ".$cat->get_address()."</p>";
						// echo "<p>vaccines: ".$cat->get_description()."</p>";
						//echo "<p>Points: ".$cat->get_points()."</p>";
						echo "<p>Puntos: ".$cat->get_total_points()."</p>";    
					echo "</div>";
				}else{
					echo "Not data";
				}
			}	
			
		echo "</div>";
		}	
?>





<hr><hr>
<h3>Dogs</h3>
<p><a href='<?php echo PATHSERVER."Dog/showRanking"?>'>Mostrar ranking bellezas perros</a>
<p><a href='<?php echo PATHSERVER."Dog/showRandom";?>'>Puntuar perros</a>
<?php
foreach ($this->dogs as $posicion=>$dog){
			$breedDog=BreedDogRepository::getById($dog->get_breed_id());  
			echo "<div class='row'>";
			if($dog==NULL) echo "empty dog";
				else{
					if ($dog->get_path_image()!=NULL){
						echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
							echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$dog->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
						echo "</div>";
						echo "<div class='col-md-4 col-sm-12'>";
							//echo "<p>".$dog->get_name()."</p>";
							echo "<p><h4>Nombre: ".$dog->get_name_es()."</h4></p>";
							if($breedDog!=null)
								echo "<p><b>Raza: ".$breedDog->get_name_es()."</b></p>";
							echo "<p>Familia".$dog->get_family()."</p>";
							echo "<p>Descripción".$dog->get_description()."</p>";
							echo "<p>Año de nacimiento".$dog->get_year_of_birth()."</p>";
							echo "<p>Sexo".$dog->get_sex()."</p>";
							echo "<p>Dirección".$dog->get_address()."</p>";
							//echo "<p>vaccines".$dog->get_vaccines()."</p>";
							//echo "<p>Puntos".$dog->get_points()."</p>";
							echo "<p>Puntos: ".$dog->get_total_points()."</p>";				
						echo "</div>";
					}else{
						echo "Not data";
					}
				}	
		  echo "</div>";
		}	
?>












<hr><hr>
<h3>Fish</h3>
<p><a href='<?php echo PATHSERVER."Fish/showRanking"?>'>Mostrar ranking bellezas peces</a>
<p><a href='<?php echo PATHSERVER."Fish/showRandom";?>'>Puntuar peces</a>
<?php
foreach ($this->fishs as $posicion=>$fish){
        ?>
        <div class="row">
			<?php
			echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
            	$photo=str_replace(" ","%20",$fish->get_path_image());
				echo "<p class='mx-auto'><img src=".PATHSERVERSININDEX.$photo." class='img-fluid' style='max-height:500px'  /></p>";
			echo "</div>";
			echo "<div class='col-md-4 col-sm-12'>";
			?>
				<p>id: <?php echo $fish->get_id(); ?></p>
				<p>Name: <?php echo $fish->get_name(); ?></p>
				<p>Name_es: <?php echo $fish->get_name_es(); ?></p>
				<p>Specie_id: <?php echo $fish->get_specie_id(); ?></p>
			<?php
			echo "</div>";	
			?>
        </div>
        <?php	
    }	


include_once("./views/templates/document-end.php");?>
		






















			



