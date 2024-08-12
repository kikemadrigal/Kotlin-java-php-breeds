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

?>




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
		<th scope="col">Points</th>
		<th scope="col">Total points</th>
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
							echo "<td>".$cat->get_points()."</td>";
							echo "<td>".$cat->get_total_points()."</td>";
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

		

