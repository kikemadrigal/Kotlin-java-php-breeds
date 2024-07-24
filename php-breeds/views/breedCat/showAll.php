<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 

if($this->breedCats==NULL) {
	echo "Empty.";
	die();
}
else{
?>

<div class="m-4">
	<a href="<?php echo PATHSERVER;?>BreedCat/search/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>BreedCat/search/z" class="btn btn-secondary">Z</a>
</div>






<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedCat/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedCat/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedCat/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedCat/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedCat/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
	<ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>BreedCat/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search breed name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>

<table class="table">
  	<thead>
		<tr>
			<th scope="col">Image<img src='<?php echo PATHSERVERSININDEX."media/icon_eye.png"; ?>' width=25px /></th>
			<th scope="col">Id <img src='<?php echo PATHSERVERSININDEX."media/icon_edit.png"; ?>' width=25px /></th>
			<th scope="col">Id_name</th>
			<th scope="col">Name</th>
			<th scope="col">Name_es</th>
			<th scope="col">description</th>
			<th scope="col">description_es</th>
			<th scope="col">origin</th>
			<th scope="col">origin_es</th>
			<th scope="col">morphology</th>
			<th scope="col">morphology_es</th>
			<th scope="col">wikipedia_url</th>
			<th scope="col">cfa_url</th>
			<th scope="col">vetstreet_url</th>
			<th scope="col">vcahospitals_url</th>
			<th scope="col">temperament</th>
			<th scope="col">temperament_es</th>
			<th scope="col">country_codes</th>
			<th scope="col">country_code</th>
			<th scope="col">life_span</th>
			<th scope="col">hypoallergenic</th>
			<th scope="col">weight</th>
			<th scope="col">date</th>
			<th scope="col">reference_id</th>
			<th scope="col">Path_image</th>
			<th scope="col">Creator_id</th>
		</tr>	
  	</thead>
	<?php

		//echo "<p>Found: ".$rowCount."</p>";
		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->breedCats as $posicion=>$breedCat){
			//if ($breedCat->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
						if(!empty($breedCat->get_reference_image_id())){
							$photo=str_replace(" ","%20",$breedCat->get_path_image());
							echo "<td><a href='".PATHSERVER."BreedCat/show/".$breedCat->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='100px' /></a></td>";
							echo "<td><a href='".PATHSERVER."BreedCat/update/".$breedCat->get_id()."'>".$breedCat->get_id()."<a></td>";
							echo "<td><a href=' https://api.thecatapi.com/v1/images/search?limit=1&breed_ids=".$breedCat->get_id_name()."&api_key=".THECATAPI_APIKEY."' target='_blanck'=''>".$breedCat->get_id_name()."</a></td>";
							echo "<td>".StringManager::cutString($breedCat->get_name(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_name_es(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_description(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_description_es(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_origin(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_origin_es(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_morphology(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_morphology_es(),50)."</td>";
							echo "<td><a href='".$breedCat->get_wikipedia_url()."' target='_banck'>".StringManager::cutString($breedCat->get_wikipedia_url(),10)."</a></td>";
							echo "<td><a href='".$breedCat->get_cfa_url()."' target='_banck'>".StringManager::cutString($breedCat->get_cfa_url(),10)."</a></td>";
							echo "<td><a href='".$breedCat->get_vetstreet_url()."' target='_banck'>".StringManager::cutString($breedCat->get_vetstreet_url(),10)."</a></td>";
							echo "<td><a href='".$breedCat->get_vcahospitals_url()."' target='_banck'>".StringManager::cutString($breedCat->get_vcahospitals_url(),10)."</a></td>";
							echo "<td>".StringManager::cutString($breedCat->get_temperament(),50)."</td>";
							echo "<td>".StringManager::cutString($breedCat->get_temperament_es(),50)."</td>";
							echo "<td>".$breedCat->get_country_codes()."</td>";
							echo "<td>".$breedCat->get_country_code  ()."</td>";
							echo "<td>".$breedCat->get_life_span()."</td>";
							echo "<td>".$breedCat->get_hypoallergenic()."</td>";
							echo "<td>".$breedCat->get_weight()."</td>";
							echo "<td>".$breedCat->get_date()."</td>";
							echo "<td><a href='https://api.thecatapi.com/v1/images/".$breedCat->get_reference_image_id()."'>".$breedCat->get_reference_image_id()."</a></td>";
							echo "<td>".$breedCat->get_path_image()."</td>";
							echo "<td>".$breedCat->get_creator_id()."</td>";
						}else{
							$errors++;
						}
						
					echo "</tr>";
				echo "</tbody>";
			//}
		}	
	}
	?>
</table>
<?php include_once("./views/templates/document-end.php");?>

		

