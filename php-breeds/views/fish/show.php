<?php
$fish=$this->fish;
include_once("./views/templates/document-start.php"); 
?>






<div>
    <?php $photo=str_replace(" ","%20",$fish->get_path_image());?>
    <?php echo "<p><img src=".PATHSERVERSININDEX.$photo." height='500px' /></p>";?>

    <p>id: <?php echo $fish->get_id(); ?></p>
    <p>Name: <?php echo $fish->get_name(); ?></p>
    <p>Name_es: <?php echo $fish->get_name_es(); ?></p>
    <p>Specie_id: <?php echo $fish->get_specie_id(); ?></p>
    <p>path_image: <?php echo $fish->get_path_image(); ?></p>
    <p>date: <?php echo $fish->get_date(); ?></p>
    <p>creator_id: <?php echo $fish->get_creator_id(); ?></p>
</div>
  






<?php include_once("./views/templates/document-end.php"); ?>