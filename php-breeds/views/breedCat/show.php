<?php
$breedCat=$this->breedCat;
if($breedCat==NULL) {
    echo "Not beedCat data";
    die();
}
include_once("./views/templates/document-start.php"); 

?>
<div class="container">
    <div class="row">
        <div class='col-md-12'>
            <p><img src='<?php echo PATHSERVERSININDEX.$breedCat->get_path_image();?>' class='img-fluid rounded mx-auto d-block' style='max-height: 500px' /></p>
        </div>
        <div class='col-md-12 col-sm-12'>
            <!--<p>id: <?php echo $breedCat->get_id(); ?></p>-->
            <!--<p>id_name: <?php echo $breedCat->get_id_name(); ?></p>-->
            <!--<p>name: <?php echo $breedCat->get_name(); ?></p>-->
            <p><b>name: </b><?php echo $breedCat->get_name_es(); ?></p>
            <!--<p>description: <?php echo nl2br($breedCat->get_description()); ?></p>-->
            <p><b>description: </b><?php echo nl2br($breedCat->get_description_es()); ?></p>
            <!--<p>origin: <?php echo nl2br($breedCat->get_origin()); ?></p>-->
            <p><b>origin:</b> <?php echo nl2br($breedCat->get_origin_es()); ?></p>
            <!--<p>morphology: <?php echo nl2br($breedCat->get_morphology()); ?></p>-->
            <p><b>characteristics</b>: <?php echo nl2br($breedCat->get_morphology_es()); ?></p>
            <p><b>wikipedia_url: </b><a href=""><?php echo $breedCat->get_wikipedia_url(); ?></a></p>
            <p><b>cfa_url:</b><a href=""> <?php echo $breedCat->get_cfa_url(); ?></a></p>
            <p><b>vetstreet_url: </b><a href=""><?php echo $breedCat->get_vetstreet_url(); ?></a></p>
            <p><b>vcahospitals_url</b><a href=""><?php echo $breedCat->get_vcahospitals_url(); ?></a></p>
            <!--<p>temperament: <?php echo nl2br($breedCat->get_temperament()); ?></p>-->
            <p><b>temperament:</b> <?php echo nl2br($breedCat->get_temperament_es()); ?></p>
            <!--<p>country_codes: <?php echo $breedCat->get_country_codes(); ?></p>-->
            <!--<p>country_code: <?php echo $breedCat->get_country_code(); ?></p>-->
            <p><b>lige span: </b><?php echo $breedCat->get_life_span(); ?></p>
            <p><b>indoor / interior: </b><?php echo $breedCat->get_indoor(); ?></p>
            <p><b>lap / regazo: </b><?php echo $breedCat->get_lap(); ?></p>
            <p><b>alt_names / nombres alternativos: </b><?php echo $breedCat->get_alt_names(); ?></p>
            <p><b>adaptability: </b><?php echo $breedCat->get_adaptability(); ?></p>
            <p><b>affection_level:</b> <?php echo $breedCat->get_affection_level(); ?></p>
            <p><b>child_friendly: </b><?php echo $breedCat->get_child_friendly(); ?></p>
            <p><b>cat_friendly:</b> <?php echo $breedCat->get_cat_friendly(); ?></p>
            <p><b>dog_friendly: </b><?php echo $breedCat->get_dog_friendly(); ?></p>
            <p><b>energy_level:</b><?php echo $breedCat->get_energy_level(); ?></p>
            <p><b>grooming / aseo: </b><?php echo $breedCat->get_grooming(); ?></p>
            <p><b>health_issues / problemas de salud:</b> <?php echo $breedCat->get_health_issues(); ?></p>
            <p><b>intelligence: </b><?php echo $breedCat->get_intelligence(); ?></p>
            <p><b>shedding_level / nivel de muda: </b><?php echo $breedCat->get_shedding_level(); ?></p>
            <p><b>social_needs / necesidades sociales: </b><?php echo $breedCat->get_social_needs(); ?></p>
            <p><b>stranger_friendly: </b><?php echo $breedCat->get_stranger_friendly(); ?></p>
            <p><b>vocalisation / vocalización: </b><?php echo $breedCat->get_vocalisation(); ?></p>
            <p><b>experimental: </b><?php echo $breedCat->get_experimental(); ?></p>
            <p><b>hairless / sin pelo: </b><?php echo $breedCat->get_hairless(); ?></p>
            <p><b>natural: </b><?php echo $breedCat->get_natural(); ?></p>
            <p><b>rare: </b><?php echo $breedCat->get_rare(); ?></p>
            <p><b>rex: </b><?php echo $breedCat->get_rex(); ?></p>
            <p><b>suppressed_tail / cola suprimida: </b><?php echo $breedCat->get_suppressed_tail(); ?></p>
            <p><b>short_legs / patas cortas: </b><?php echo $breedCat->get_short_legs(); ?></p>
            <p><b>hypoallergenic / hipoalergénico: </b><?php echo $breedCat->get_hypoallergenic(); ?></p>
            <p><b>weight / peso: </b><?php echo $breedCat->get_weight(); ?></p>
             <!--<p>Date: <?php echo $breedCat->get_date(); ?></p>-->
             <!--<p>reference_image_id: <?php echo $breedCat->get_reference_image_id(); ?></p>-->
            <!-- <p>path_image: <?php echo $breedCat->get_path_image(); ?></p>-->
            <!-- <p>Creator: <?php echo $breedCat->get_creator_id(); ?></p>-->
        </div>



    </div>
</div>





<?php include_once("./views/templates/document-end.php"); ?>