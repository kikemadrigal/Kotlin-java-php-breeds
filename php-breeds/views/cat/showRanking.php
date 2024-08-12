<?php include_once("./views/templates/document-start.php"); 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;


if($this->cats==NULL) {
	echo "Empty.";
	die();
}
else{
//echo "page= ".$page;
?>

<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showRanking/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showRanking/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showRanking/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showRanking/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showRanking/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>

    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Cat/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search cat name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>
	<?php

		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->cats as $posicion=>$cat){
			$breedCat=BreedCatRepository::getByIdName($cat->get_breed_id());  
			echo "<div class='row'>";
			if($cat==NULL) echo "empty cat";
			else{
				if ($cat->get_path_image()!=NULL){
					echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
						echo "<p><img src='".PATHSERVERSININDEX.$cat->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
					echo "</div>";
					echo "<div class='col-md-4 col-sm-12'>";
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
						echo "<p>Puntuar: ";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/1'> 1 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/2'> 2 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/3'> 3 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/4'> 4 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/5'> 5 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/6'> 6 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/7'> 7 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/8'> 8 </a>";
							echo "<a href='".PATHSERVER."Cat/updateBeauty/".$cat->get_id()."/9'> 9 </a>";
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

		

