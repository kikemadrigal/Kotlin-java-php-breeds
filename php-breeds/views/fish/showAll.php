<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 
if($this->fishs==NULL) {
	echo "fish es nulo";
	die();
}
else{
?>

<div class="m-4">
	<a href="<?php echo PATHSERVER;?>Fish/search/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>Fish/search/z" class="btn btn-secondary">Z</a>
</div>






<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
	<ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Fish/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search fish name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>







<table class="table">
  <thead>
    <tr>
      <th scope="col">Image</th>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Name_es</th>
      <th scope="col">Specie_id</th>
      <th scope="col">Path_image</th>
      <th scope="col">date</th>
	  <th scope="col">creator_id</th>
	  <!--<th scope="col">RapidAPI</th>-->
  </thead>
	<?php
	$errors=0;

		echo "Found: ".count($this->fishs);
		if ($errors>0) echo "Errors: ".$errors;
		foreach ($this->fishs as $posicion=>$fish){
			//if ($fish->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
						if(!empty($fish->get_specie_id())){
							$photo=str_replace(" ","%20",$fish->get_path_image());
							echo "<td><a href='".PATHSERVER."Fish/show/".$fish->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='150px' /></a></td>";
							echo "<td>".$fish->get_id()."</td>";
							echo "<td>".$fish->get_name()."</td>";
							echo "<td>".$fish->get_name_es()."</td>";
							echo "<td><a href='".PATHSERVER."SpecieFish/show/".$fish->get_specie_id()."'>".$fish->get_specie_id()."</a></td>";
							echo "<td>".$fish->get_path_image()."</td>";
							echo "<td>".$fish->get_date()."</td>";
							echo "<td>".$fish->get_creator_id()."</td>";
							
							//echo "<td><a href='https://api.thecatapi.com/v1/images/".$fish->get_specie_id()."'>".$fish->get_specie_id()."</a></td>";
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

		

