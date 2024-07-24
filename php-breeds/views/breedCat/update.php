<?php 
$breedCat=$this->breedCat;
include_once("./views/templates/document-start.php"); 
?>
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>¿Estas seguro que quieres borrar ? / Are you sure you want to delete?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a href="<?php echo PATHSERVER; ?>BreedCat/delete/<?php echo $breedCat->get_id(); ?>" class="btn btn-primary">   SI   </a>
            </div>
        </div>
    </div>
</div>


<h3>Update Breed cat </h3>

<!----------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------ FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->
<!-- Patrones: para campos con números: pattern='[0-9]{1,10000}'-->
<form method=post action='<?php echo PATHSERVER."BreedCat/update"?>' class='form-horizontal background-pink' enctype='multipart/form-data'>

    <div class='form-group m-4' >  
        <label for='id_name' class='control-label '>id_name:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='id_name' id='id_name' title='id_name' value='<?php echo $breedCat->get_id_name(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='name' class='control-label '>Name:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name' id='name' title='name' value='<?php echo $breedCat->get_name(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='name_es' class='control-label '>name_es:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name_es' id='name_es' title='name_es' value='<?php echo $breedCat->get_name_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='description' class='control-label '>description: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='description' id='description' title='description' rows=5 cols=60 title='description' required><?php echo $breedCat->get_description(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='description_es' class='control-label '>description_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='description_es' id='description_es' title='description_es' rows=5 cols=60 title='description_es' required><?php echo $breedCat->get_description_es(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='origin' class='control-label '>origin: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='origin' id='origin' title='origin'  rows=5 cols=60 required><?php echo $breedCat->get_origin(); ?> </textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='origin_es' class='control-label '>origin_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='origin_es' id='origin_es' title='origin_es' rows=5 cols=60  required ><?php echo $breedCat->get_origin_es(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='morphology' class='control-label '>morphology: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='morphology' id='morphology' title='morphology'  rows=5 cols=60 required><?php echo $breedCat->get_morphology(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='morphology_es' class='control-label '>morphology_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='morphology_es' id='morphology_es' title='morphology_es' rows=5 cols=60 required> <?php echo $breedCat->get_morphology_es(); ?> </textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='cfa_url' class='control-label '>cfa_url: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='cfa_url' id='cfa_url' title='cfa_url' value='<?php echo $breedCat->get_cfa_url(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='vetstreet_url' class='control-label '>vetstreet_url: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='vetstreet_url' id='vetstreet_url' title='vetstreet_url' value='<?php echo $breedCat->get_vetstreet_url(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='vcahospitals_url' class='control-label '>vcahospitals_url: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='vcahospitals_url' id='vcahospitals_url' title='vcahospitals_url' value='<?php echo $breedCat->get_vcahospitals_url(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='temperament' class='control-label '>temperament: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='temperament' id='temperament' title='temperament' rows=5 cols=60 required ><?php echo $breedCat->get_temperament(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='temperament_es' class='control-label '>temperament_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='temperament_es' id='temperament_es' title='temperament_es' rows=5 cols=60 required ><?php echo $breedCat->get_temperament_es(); ?></textarea>
        </div>
    </div> 

    <div class='form-group m-4' >  
        <label for='country_codes' class='control-label '>country_codes: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='country_codes' id='country_codes' title='country_codes' value='<?php echo $breedCat->get_country_codes(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='country_code' class='control-label '>country_code: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='country_code' id='country_code' title='country_code' value='<?php echo $breedCat->get_country_code(); ?>' required />
        </div>
    </div> 

    <div class='form-group m-4' >  
        <label for='life_span' class='control-label '>life_span: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='life_span' id='life_span' title='life_span' value='<?php echo $breedCat->get_life_span(); ?>' required />
        </div>
    </div> 
    
    <div class='form-group m-4' >  
        <label for='indoor' class='control-label '>indoor / interior: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='indoor' id='indoor' title='indoor' value='<?php echo $breedCat->get_indoor(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='lap' class='control-label '>lap / regazo: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='lap' id='lap' title='lap' value='<?php echo $breedCat->get_lap(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='alt_names' class='control-label '>alt_names / nombres alternativos: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='alt_names' id='alt_names' title='alt_names' value='<?php echo $breedCat->get_alt_names(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='adaptability' class='control-label '>adaptability: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='adaptability' id='adaptability' title='adaptability' value='<?php echo $breedCat->get_adaptability(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='affection_level' class='control-label '>affection_level: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='affection_level' id='affection_level' title='affection_level' value='<?php echo $breedCat->get_affection_level(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='child_friendly' class='control-label '>child_friendly: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='child_friendly' id='child_friendly' title='child_friendly' value='<?php echo $breedCat->get_child_friendly(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='cat_friendly' class='control-label '>cat_friendly: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='cat_friendly' id='cat_friendly' title='cat_friendly' value='<?php echo $breedCat->get_cat_friendly(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='dog_friendly' class='control-label '>dog_friendly: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='dog_friendly' id='dog_friendly' title='dog_friendly' value='<?php echo $breedCat->get_dog_friendly(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='energy_level' class='control-label '>energy_level: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='energy_level' id='energy_level' title='energy_level' value='<?php echo $breedCat->get_energy_level(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='grooming' class='control-label '>grooming / aseo: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='grooming' id='grooming' title='grooming' value='<?php echo $breedCat->get_grooming(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='health_issues' class='control-label '>health_issues / problemas de salud: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='health_issues' id='health_issues' title='health_issues' value='<?php echo $breedCat->get_health_issues(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='intelligence' class='control-label '>intelligence: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='intelligence' id='intelligence' title='intelligence' value='<?php echo $breedCat->get_intelligence(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='shedding_level' class='control-label '>shedding_level / nivel de muda: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='shedding_level' id='shedding_level' title='shedding_level' value='<?php echo $breedCat->get_shedding_level(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='social_needs' class='control-label '>social_needs / necesidades sociales: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='social_needs' id='social_needs' title='social_needs' value='<?php echo $breedCat->get_social_needs(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='stranger_friendly' class='control-label '>stranger_friendly: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='stranger_friendly' id='stranger_friendly' title='stranger_friendly' value='<?php echo $breedCat->get_stranger_friendly(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='vocalisation' class='control-label '>vocalisation: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='vocalisation' id='vocalisation' title='vocalisation' value='<?php echo $breedCat->get_vocalisation(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='experimental' class='control-label '>experimental: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='experimental' id='experimental' title='experimental' value='<?php echo $breedCat->get_experimental(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='hairless' class='control-label '>hairless / sin pelo: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='hairless' id='hairless' title='hairless' value='<?php echo $breedCat->get_hairless(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='natural' class='control-label '>natural: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='natural' id='natural' title='natural' value='<?php echo $breedCat->get_natural(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='rare' class='control-label '>rare: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='rare' id='rare' title='rare' value='<?php echo $breedCat->get_rare(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='rex' class='control-label '>rex : </label> 
        <div class='col'>
            <input type='number' class='form-control' name='rex' id='rex' title='rex' value='<?php echo $breedCat->get_rex(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='suppressed_tail' class='control-label '>suppressed_tail / cola suprimida: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='suppressed_tail' id='suppressed_tail' title='suppressed_tail' value='<?php echo $breedCat->get_suppressed_tail(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='short_legs' class='control-label '>short_legs / piernas cortas: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='short_legs' id='short_legs' title='short_legs' value='<?php echo $breedCat->get_short_legs(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='wikipedia_url' class='control-label '>wikipedia_url: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='wikipedia_url' id='wikipedia_url' title='wikipedia_url' value='<?php echo $breedCat->get_wikipedia_url(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='hypoallergenic' class='control-label '>hypoallergenic: </label> 
        <div class='col'>
            <input type='number' class='form-control' name='hypoallergenic' id='hypoallergenic' title='hypoallergenic' value='<?php echo $breedCat->get_hypoallergenic(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='weight' class='control-label '>weight: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='weight' id='weight' title='weight' value='<?php echo $breedCat->get_weight(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='date' class='control-label '>date: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='date' id='date' title='date' value='<?php echo $breedCat->get_date(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='reference_image_id' class='control-label '>reference_image_id: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='reference_image_id' id='reference_image_id' title='reference_image_id' value='<?php echo $breedCat->get_reference_image_id(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='path_image' class='control-label '>path_image: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='path_image' id='path_image' title='path_image' value='<?php echo $breedCat->get_path_image(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='creator_id' class='control-label '>creator_id:</label> 
        <div class='col'>
            <input type='number' class='form-control' name='creator_id' id='creator_id' title='creator_id' value='<?php echo $breedCat->get_creator_id(); ?>' />
        </div>
    </div> 
    


    <div class='form-group m-4' > 
        <div class='col col-md-offset-2' >
            <input type="hidden" name="id" id="id" value='<?php echo $breedCat->get_id() ?>' />
            <input type='submit' name="submit" id="submit" value='Update' class='btn btn-primary' ></input> 
            <!--<input type='button' name="remove" id="remove" value='Remove' class='btn btn-danger' data-toggle="modal" data-target="#deleteModal" ></input> -->
            <a href="<?php echo PATHSERVER; ?>BreedCat/delete/<?php echo $breedCat->get_id(); ?>" class="btn btn-danger">   Delete   </a>
        </div>
    </div> 
</form>
<!----------------------------------------------------------------------------------------------------------------------->
<!---------------------------------------FINAL DEL FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->











<?php include_once("./views/templates/document-end.php"); ?>