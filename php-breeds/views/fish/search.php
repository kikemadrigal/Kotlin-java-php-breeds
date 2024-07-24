<?php
include_once("./views/templates/document-start.php"); 
?>
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
	if ($errors>0) echo "Errors: ".$errors;
	foreach ($this->fishes as $posicion=>$fish){
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

	?>
</table>

<?php include_once("./views/templates/document-end.php");?>