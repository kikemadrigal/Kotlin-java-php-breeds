<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 
if($this->specieFishs==NULL) {
	echo "specieFish es nulo";
	die();
}
else{
?>

<div class="m-4">
	<a href="<?php echo PATHSERVER;?>SpecieFish/number" class="btn btn-secondary">0-9</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/a" class="btn btn-secondary">A</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/b" class="btn btn-secondary">B</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/c" class="btn btn-secondary">C</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/d" class="btn btn-secondary">D</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/e" class="btn btn-secondary">E</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/f" class="btn btn-secondary">F</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/g" class="btn btn-secondary">G</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/h" class="btn btn-secondary">H</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/i" class="btn btn-secondary">I</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/j" class="btn btn-secondary">J</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/k" class="btn btn-secondary">K</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/l" class="btn btn-secondary">L</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/m" class="btn btn-secondary">M</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/n" class="btn btn-secondary">N</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/ñ" class="btn btn-secondary">Ñ</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/o" class="btn btn-secondary">O</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/p" class="btn btn-secondary">P</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/q" class="btn btn-secondary">Q</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/r" class="btn btn-secondary">R</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/s" class="btn btn-secondary">S</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/t" class="btn btn-secondary">T</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/u" class="btn btn-secondary">U</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/v" class="btn btn-secondary">V</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/w" class="btn btn-secondary">W</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/x" class="btn btn-secondary">X</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/y" class="btn btn-secondary">Y</a>
	<a href="<?php echo PATHSERVER;?>SpecieFish/search/z" class="btn btn-secondary">Z</a>
</div>


<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."SpecieFish/showAll/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."SpecieFish/showAll/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."SpecieFish/showAll/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."SpecieFish/showAll/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."SpecieFish/showAll/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>
	<form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>SpecieFish/showAll' >
        <input class="form-control" type="page" name="page" id="page" placeholder="<?php echo $pageReal;?>" value="<?php echo $pageReal;?>" aria-label="goto" >
        <button class="btn btn-outline-success" type="submit" name="submit">Go</button>
    </form>
	<ul class="navbar-nav >
      <li class="nav-item"><?PHP echo "Found: ".$rowCount;?></li>
    </ul>
	
    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>SpecieFish/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search specie name" aria-label="Search" >
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
		<th scope="col">description</th>
		<th scope="col">url_wiki</th>
		<th scope="col">url_image</th>
		<th scope="col">morphology</th>
		<th scope="col">habitat</th>
		<th scope="col">feeding</th>
		<th scope="col">phylum</th>
		<th scope="col">class</th>
		<th scope="col">orden</th>
		<th scope="col">family</th>
		<th scope="col">genus</th>
		<th scope="col">Path_image</th>
		<th scope="col">date</th>
		<th scope="col">Creator_id</th>
  </thead>
	<?php
	$errors=0;


		foreach ($this->specieFishs as $posicion=>$specieFish){
			//if ($specieFish->get_id()!=NULL){
				echo "<tbody>";
					echo "<tr>";
						if(!empty($specieFish->get_id())){
							$photo=str_replace(" ","%20",$specieFish->get_path_image());
							echo "<td><a href='".PATHSERVER."SpecieFish/show/".$specieFish->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='150px' /></a></td>";
							echo "<td><a href='".PATHSERVER."SpecieFish/update/".$specieFish->get_id()."'>".$specieFish->get_id()."</a></td>";
							echo "<td>".$specieFish->get_name()."</td>";
							echo "<td>".$specieFish->get_name_es()."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_description(),100)."</td>";
							echo "<td><a href='".$specieFish->get_url_wiki()."' target='_blanck'>".StringManager::cutString($specieFish->get_url_wiki(),10)."</a></td>";
							echo "<td>".StringManager::cutString($specieFish->get_url_image(),10)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_morphology(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_habitat(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_feeding(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_class(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_orden(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_family(),60)."</td>";
							echo "<td>".StringManager::cutString($specieFish->get_genus(),60)."</td>";
							echo "<td>".$specieFish->get_path_image()."</td>";
							echo "<td>".$specieFish->get_date()."</td>";
							echo "<td>".$specieFish->get_creator_id()."</td>";
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

		

