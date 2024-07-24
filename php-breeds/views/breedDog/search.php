<?php
include_once("./views/templates/document-start.php"); 
$breedDog=null;
if($this->breedDogs==NULL) {
  echo "breedDog is empty";
  die();
}
else{
?>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Image<img src='<?php echo PATHSERVERSININDEX."media/icon_eye.png"; ?>' width=25px /></th>
        <th scope="col">Id <img src='<?php echo PATHSERVERSININDEX."media/icon_edit.png"; ?>' width=25px /></th>
        <th scope="col">breed_id</th>
        <th scope="col">Name</th>
        <th scope="col">Name_es</th>
        <th scope="col">bred_for / Criado para </th>
        <th scope="col">bred_for_es</th>
        <th scope="col">breed_group</th>
        <th scope="col">breed_group_es</th>
        <th scope="col">life_span</th>
        <th scope="col">temperament</th>
        <th scope="col">temperament_es</th>
        <th scope="col">origin</th>
        <th scope="col">weight</th>
        <th scope="col">height</th>
        <th scope="col">date</th>
        <th scope="col">reference_image_id</th>
        <th scope="col">path_image</th>
        <th scope="col">creator_id</th>
    </thead>
    <?php
    foreach ($this->breedDogs as $posicion=>$breedDog){
      echo "<tbody>";
        echo "<tr>";
          $photo=str_replace(" ","%20",$breedDog->get_path_image());
          echo "<td><a href='".PATHSERVER."BreedDog/show/".$breedDog->get_id()."'><img src='".PATHSERVERSININDEX.$photo."' width='100px' /></a></td>";
          echo "<td><a href='".PATHSERVER."BreedDog/update/".$breedDog->get_id()."'>".$breedDog->get_id()."<a></td>";
          echo "<td><a href='https://api.thedogapi.com/v1/images/search?limit=1&breed_ids=".$breedDog->get_breed_id()."' target='_blanck'>".$breedDog->get_breed_id()."</a></td>";
          echo "<td>".$breedDog->get_name()."</td>";
          echo "<td>".$breedDog->get_name_es()."</td>";
          echo "<td>".$breedDog->get_bred_for()."</td>";
          echo "<td>".$breedDog->get_bred_for_es()."</td>";
          echo "<td>".$breedDog->get_breed_group()."</td>";
          echo "<td>".$breedDog->get_breed_group_es()."</td>";
          echo "<td>".$breedDog->get_life_span()."</td>";
          echo "<td>".$breedDog->get_temperament()."</td>";
          echo "<td>".$breedDog->get_temperament_es()."</td>";
          echo "<td>".$breedDog->get_origin()."</td>";
          echo "<td>".$breedDog->get_weight()."</td>";
          echo "<td>".$breedDog->get_height()."</td>";
          echo "<td>".$breedDog->get_date()."</td>";
          echo "<td><a href='https://api.thedogapi.com/v1/images/".$breedDog->get_reference_image_id()."'>".$breedDog->get_reference_image_id()."</a></td>";
          echo "<td>".$breedDog->get_path_image()."</td>";
          echo "<td>".$breedDog->get_creator_id()."</td>";
        echo "</tr>";
      echo "</tbody>";
    }	
	}
	?>
</table>
<?php
include_once("./views/templates/document-end.php"); 
?>