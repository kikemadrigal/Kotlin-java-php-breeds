<?php
include_once("./views/templates/document-start.php"); 
$errors=0;
if($this->dogs==NULL) {
	echo "dog es nulo";
	die();
}
else{
?>
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
      <th scope="col">DogAPI</th>
  </thead>
	<?php
	echo "Found: ".$rowCount;
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
						//echo "<td><a href='".PATHSERVER."BreedDog/show/".$dog->get_breed_id()."'>".$dog->get_breed_id().": ".BreedDogRepository::getById($dog->get_breed_id())->get_name_es()."<a></td>";
						echo "<td><a href='".PATHSERVER."BreedDog/show/".$dog->get_breed_id()."'>".$dog->get_breed_id()."<a></td>";
							
						echo "<td>".$dog->get_family()."</td>";
						echo "<td>".$dog->get_description()."</td>";
						echo "<td>".$dog->get_year_of_birth()."</td>";
						echo "<td>".$dog->get_sex()."</td>";
						echo "<td>".$dog->get_address()."</td>";
						//echo "<td>".$dog->get_vaccines()."</td>";
						echo "<td>".$dog->get_path_image()."</td>";
						echo "<td>".$dog->get_date()."</td>";
						echo "<td>".$dog->get_path_image()."</td>";
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
<?php
include_once("./views/templates/document-end.php"); 
?>