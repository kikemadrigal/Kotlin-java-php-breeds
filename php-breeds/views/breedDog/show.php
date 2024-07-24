<?php
$breedDog=$this->breedDog;
if($breedDog==NULL) {
    echo "Not beedCat data";
    die();
}
include_once("./views/templates/document-start.php"); 

?>
<div class="container">
    <div class="row">
        <div class='col-md-12'>
            <p><img src='<?php echo PATHSERVERSININDEX.$breedDog->get_path_image();?>' class='img-fluid rounded mx-auto d-block' style='max-height: 500px' /></p>
        </div>
        <div class='col-md-12 col-sm-12'>
            <!--<p>id: <?php echo $breedDog->get_id(); ?></p>-->
            <!--<p>name: <?php echo $breedDog->get_name(); ?></p>-->
            <p><b>Nombre: </b><?php echo $breedDog->get_name_es(); ?></p>
            <!--<p>description: <?php echo nl2br($breedDog->get_description(),50); ?></p>-->
            <p><b>Descripción: </b><?php echo nl2br($breedDog->get_description_es(),50); ?></p>
            <!--<p>origin: <?php echo nl2br($breedDog->get_origin(),50) ?></p>-->
            <p><b>Origen: </b><?php echo nl2br($breedDog->get_origin_es(),50) ?></p>
            <!--<p>morphology: <?php echo nl2br($breedDog->get_morphology(),50) ?></p>-->
            <p><b>Morfología: </b><?php echo nl2br($breedDog->get_morphology_es(),50) ?></p>
            <!--<p>temperament: <?php echo nl2br($breedDog->get_temperament(),50) ?></p>
            <p>temperament es: <?php echo nl2br($breedDog->get_temperament_es(),50) ?></p>-->
            <p><b>Wiki_url: </b><?php echo $breedDog->get_wiki_url(); ?></p>
            <!--<p>breed for / Criado para: <?php echo $breedDog->get_bred_for() ?></p>-->
            <p><b>Criado para: </b><?php echo $breedDog->get_bred_for_es() ?></p>
            <!--<p>breed group: <?php echo $breedDog->get_breed_group() ?></p>-->
            <p><b>Grupo raza: </b><?php echo $breedDog->get_breed_group_es() ?></p>
            <p><b>Esperanza de vida: </b><?php echo $breedDog->get_life_span() ?></p>           
            <p><b>Ancho:</b><?php echo $breedDog->get_weight() ?></p>
            <p><b>Alto: </b><?php echo $breedDog->get_height() ?></p>
           <!-- <p>Date: <?php echo $breedDog->get_date(); ?></p>-->
           <!-- <p>reference_image_id: <?php echo $breedDog->get_reference_image_id(); ?></p>-->
           <!-- <p>path_image: <?php echo $breedDog->get_path_image(); ?></p>-->
           <!-- <p>Creator id: <?php echo $breedDog->get_creator_id(); ?></p>-->
        </div>



    </div>
</div>





<?php include_once("./views/templates/document-end.php"); ?>