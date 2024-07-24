<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 
 
?>


<div class="m-4">
	<a href="<?php echo PATHSERVER;?>BreedDog/search/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>BreedDog/search/z" class="btn btn-secondary">Z</a>
</div>



<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedDog/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedDog/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedDog/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedDog/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."BreedDog/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
    <ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>BreedDog/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search breed" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>


<table class="table">
  <thead>
    <tr>
      <th scope="col">Image<img src='<?php echo PATHSERVERSININDEX."media/icon_eye.png"; ?>' width=25px /></th>
      <th scope="col">Id <img src='<?php echo PATHSERVERSININDEX."media/icon_edit.png"; ?>' width=25px /></th>
      <th scope="col">breed_id</th>
      <th scope="col">Name</th>
      <th scope="col">Name_es</th>
      <th scope="col">description</th>
      <th scope="col">description_es</th>
      <th scope="col">origin</th>
      <th scope="col">origin_es</th>
      <th scope="col">morphology</th>
      <th scope="col">morphology_es</th>
      <th scope="col">temperament</th>
      <th scope="col">temperament_es</th>
      <th scope="col">wiki_url</th>
      <th scope="col">bred_for / Criado para </th>
      <th scope="col">bred_for_es</th>
      <th scope="col">breed_group</th>
      <th scope="col">breed_group_es</th>
      <th scope="col">life_span</th>
      <th scope="col">weight</th>
      <th scope="col">height</th>
      <th scope="col">date</th>
      <th scope="col">reference_image_id</th>
      <th scope="col">path_image</th>
      <th scope="col">creator_id</th>
  </thead>
	<?php
	$breedDog=null;
	if($this->breedDogs==NULL) {
		echo "breedDog es nulo";
		die();
	}
	else{
		
		foreach ($this->breedDogs as $posicion=>$breedDog){
			//if ($breedDog->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
            $photo=str_replace(" ","%20",$breedDog->get_path_image());
            echo "<td><a href='".PATHSERVER."BreedDog/show/".$breedDog->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='100px' /></a></td>";
            echo "<td><a href='".PATHSERVER."BreedDog/update/".$breedDog->get_id()."'>".$breedDog->get_id()."<a></td>";
            echo "<td><a href='https://api.thedogapi.com/v1/images/search?limit=1&breed_ids=".$breedDog->get_breed_id()."' target='_blanck'>".$breedDog->get_breed_id()."</a></td>";
            echo "<td>".$breedDog->get_name()."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_name_es(),50)."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_description(),50)."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_description_es(),50)."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_origin(),50)."</td>";
						echo "<td>".StringManager::cutString($breedDog->get_origin_es(),50)."</td>";
						echo "<td>".StringManager::cutString($breedDog->get_morphology(),50)."</td>";
						echo "<td>".StringManager::cutString($breedDog->get_morphology_es(),50)."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_temperament(),50)."</td>";
            echo "<td>".StringManager::cutString($breedDog->get_temperament_es(),50)."</td>";
            echo "<td><a href='".$breedDog->get_wiki_url()."'>".$breedDog->get_wiki_url()."</a></td>";
            echo "<td>".$breedDog->get_bred_for()."</td>";
            echo "<td>".$breedDog->get_bred_for_es()."</td>";
            echo "<td>".$breedDog->get_breed_group()."</td>";
            echo "<td>".$breedDog->get_breed_group_es()."</td>";
            echo "<td>".$breedDog->get_life_span()."</td>";
            echo "<td>".$breedDog->get_weight()."</td>";
						echo "<td>".$breedDog->get_height()."</td>";
						echo "<td>".$breedDog->get_date()."</td>";
            echo "<td><a href='https://api.thedogapi.com/v1/images/".$breedDog->get_reference_image_id()."'>".$breedDog->get_reference_image_id()."</a></td>";
						echo "<td>".$breedDog->get_path_image()."</td>";
						echo "<td>".$breedDog->get_creator_id()."</td>";
					echo "</tr>";
				echo "</tbody>";
			//}
		}	
	}
	?>
</table>

<?php include_once("./views/templates/document-end.php");?>

		

