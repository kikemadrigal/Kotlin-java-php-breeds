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


<div class="m-4">
	<a href="<?php echo PATHSERVER;?>Dog/search/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>Dog/search/z" class="btn btn-secondary">Z</a>
</div>

<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Dog/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
	<ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Dog/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Image</th>
      <th scope="col">Name</th>
      <th scope="col">Name_es</th>
      <th scope="col">breed id</th>
      <th scope="col">family</th>
      <th scope="col">description</th>
      <th scope="col">birth </th>
      <th scope="col">sex </th>
      <th scope="col">address </th>
      <!--<th scope="col">vaccines </th>-->
      <th scope="col">Path image</th>
      <th scope="col">Date</th>
      <th scope="col">Creator_id</th>
      <th scope="col">DogAPI</th>
  </thead>
	<?php
	$errors=0;

		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->dogs as $posicion=>$dog){
			//if ($dog->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
						if(!empty($dog->get_breed_id())){
							$photo=str_replace(" ","%20",$dog->get_path_image());
							echo "<td><a href='".PATHSERVER."Dog/show/".$dog->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='100px' /></a></td>";
							echo "<td>".$dog->get_name()."</td>";
							echo "<td>".$dog->get_name_es()."</td>";
							echo "<td><a href='".PATHSERVER."BreedDog/show/".$dog->get_breed_id()."'>".$dog->get_breed_id().": ".BreedDogRepository::getById($dog->get_breed_id())->get_name_es()."<a></td>";
							echo "<td>".$dog->get_family()."</td>";
							echo "<td>".$dog->get_description_es()."</td>";
							echo "<td>".$dog->get_year_of_birth()."</td>";
							echo "<td>".$dog->get_sex()."</td>";
							echo "<td>".$dog->get_address()."</td>";
							//echo "<td>".$dog->get_vaccines()."</td>";
							echo "<td>".$dog->get_path_image()."</td>";
							echo "<td>".$dog->get_date()."</td>";
							echo "<td>".$dog->get_creator_id()."</td>";
							echo "<td><a href='https://api.thedogapi.com/v1/images/".$dog->get_breed_id()."'>".$dog->get_breed_id()."</a></td>";
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

		

