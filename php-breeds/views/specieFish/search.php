<?php include_once("./views/templates/document-start.php"); 
if($this->specieFishs==NULL) {
	echo "specieFish es nulo";
	die();
}
else{
?>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Image</th>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Name_es</th>
      <th scope="col">description</th>
      <th scope="col">url_wiki</th>
      <th scope="col">url_image</th>
      <th scope="col">Path_image</th>
      <th scope="col">date</th>
      <th scope="col">Creator_id</th>
  </thead>
	<?php
		foreach ($this->specieFishs as $posicion=>$specieFish){
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
						echo "<td>".$specieFish->get_path_image()."</td>";
						echo "<td>".$specieFish->get_date()."</td>";
						echo "<td>".$specieFish->get_creator_id()."</td>";
						$errors++;
					}
					
				echo "</tr>";
			echo "</tbody>";
		}	
	}
	?>
</table>

<?php include_once("./views/templates/document-end.php");?>
