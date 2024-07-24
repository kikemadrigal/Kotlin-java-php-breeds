<?php
$specieFish=$this->specieFish;
include_once("./views/templates/document-start.php"); 
?>



<div class="container">
    <div class="row">
        <div class='col-md-12'>
            <?php $photo=str_replace(" ","%20",$specieFish->get_path_image());?>
            <p><img src='<?php echo PATHSERVERSININDEX.$photo;?>' class='img-fluid rounded mx-auto d-block' style='max-height: 500px'   /></a></p>
        </div>
        <div class='col-md-12 col-sm-12'>					
            <p>id: <?php echo $specieFish->get_id(); ?></p>
            <p>Name: <?php echo $specieFish->get_name(); ?></p>
            <p>Name_es: <?php echo $specieFish->get_name_es(); ?></p>
            <p>description: <?php echo $specieFish->get_description(); ?></p>
            <p>url_wiki: <?php echo $specieFish->get_url_wiki(); ?></p>
            <p>url_image: <?php echo $specieFish->get_url_image(); ?></p>
            <p>morphology: <?php echo $specieFish->get_morphology(); ?></p>
            <p>habitat: <?php echo $specieFish->get_habitat(); ?></p>
            <p>feeding: <?php echo $specieFish->get_feeding(); ?></p>
            <p>path_image: <?php echo $specieFish->get_path_image(); ?></p>
            <p>date: <?php echo $specieFish->get_date(); ?></p>
            <p>creator_id: <?php echo $specieFish->get_creator_id(); ?></p>
        </div>
    </div>
</div>






<?php include_once("./views/templates/document-end.php"); ?>