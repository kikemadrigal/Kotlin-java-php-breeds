<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 

if($this->dogs==NULL) {
	echo "dog es nulo";
	die();
}
else{
?>


<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showRanking/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showRanking/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showRanking/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showRanking/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showRanking/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>

    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Dog/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>

	<?php
	$errors=0;

		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->dogs as $posicion=>$dog){
			$breedDog=BreedDogRepository::getById($dog->get_breed_id());  
			echo "<div class='row'>";
			if($dog==NULL) echo "empty dog";
				else{
					if ($dog->get_path_image()!=NULL){
						echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
							echo "<p><img src='".PATHSERVERSININDEX.$dog->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
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
		  echo "</div>";
		}	
	}
	?>
</table>

<?php include_once("./views/templates/document-end.php");?>

		

