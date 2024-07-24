<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 

if($this->cats==NULL) {
	echo "Empty.";
	die();
}
else{
//echo "page= ".$page;
?>



<div class="m-4">
	<a href="<?php echo PATHSERVER;?>Cat/search/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>Cat/search/z" class="btn btn-secondary">Z</a>
</div>





<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Cat/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
	<ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Cat/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search cat name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>

<table class="table">
  <thead>
    <tr>
		<th scope="col">Image<img src='<?php echo PATHSERVERSININDEX."media/icon_eye.png"; ?>' width=25px /></th>
		<th scope="col">Id <img src='<?php echo PATHSERVERSININDEX."media/icon_edit.png"; ?>' width=25px /></th>
		<th scope="col">Name</th>
		<th scope="col">Name_es</th>
		<th scope="col">Breed_id</th>
		<th scope="col">family</th>
		<th scope="col">description</th>
		<th scope="col">description_es</th>
		<th scope="col">birth</th>
		<th scope="col">sex</th>
		<th scope="col">address</th>
		<th scope="col">vaccines</th>
		<th scope="col">Path_image</th>
		<th scope="col">Date</th>
		<th scope="col">Creator_id</th>
		<th scope="col">CatAPI</th>
  </thead>
	<?php


		echo "Found: ".$rowCount;
		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->cats as $posicion=>$cat){
			//if ($cat->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
						if(!empty($cat->get_breed_id())){
							$photo=str_replace(" ","%20",$cat->get_path_image());
							$sexo="";
							if($cat->get_sex()==0){
								$sexo="Femenino";
							}else{
								$sexo="masculino";
							}
							echo "<td><a href='".PATHSERVER."Cat/show/".$cat->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='100px' /></a></td>";
							echo "<td><a href='".PATHSERVER."Cat/update/".$cat->get_id()."'>".$cat->get_id()."</a></td>";
							echo "<td><a href='".PATHSERVER."Cat/show/".$cat->get_id()."'>".$cat->get_name()."</a></td>";
							echo "<td>".$cat->get_name_es()."</td>";
							echo "<td><a href='".PATHSERVER."BreedCat/showByBreedId/".$cat->get_breed_id()."'>".$cat->get_breed_id()."</a></td>";
							echo "<td>".$cat->get_family()."</td>";
							echo "<td>".$cat->get_description()."</td>";
							echo "<td>".$cat->get_description_es()."</td>";
							echo "<td>".$cat->get_year_of_birth()."</td>";
							echo "<td>".$sexo."</td>";
							echo "<td>".$cat->get_address()."</td>";
							echo "<td>".$cat->get_vaccines()."</td>";
							echo "<td>".$cat->get_path_image()."</td>";
							echo "<td>".$cat->get_date()."</td>";
							echo "<td>".$cat->get_creator_id()."</td>";
							echo "<td><a href='https://api.thecatapi.com/v1/images/".$cat->get_breed_id()."'>".$cat->get_breed_id()."</a></td>";
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

		

