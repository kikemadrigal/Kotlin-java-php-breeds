<?php 
$breedDog=$this->breedDog;
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
                <a href="<?php echo PATHSERVER; ?>BreedDog/delete/<?php echo $breedDog->get_id(); ?>" class="btn btn-primary">   SI   </a>
            </div>
        </div>
    </div>
</div>


<h3>Update Breed cat </h3>

<!----------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------ FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->
<!-- Patrones: para campos con números: pattern='[0-9]{1,10000}'-->
<form method=post action='<?php echo PATHSERVER."BreedDog/update"?>' class='form-horizontal background-pink' enctype='multipart/form-data'>

    <div class='form-group m-4' >  
        <label for='breed_id' class='control-label '>breed_id:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='breed_id' id='breed_id' title='breed_id' value='<?php echo $breedDog->get_breed_id(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='name' class='control-label '>Name:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name' id='name' title='name' value='<?php echo $breedDog->get_name(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='name_es' class='control-label '>name_es:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name_es' id='name_es' title='name_es' value='<?php echo $breedDog->get_name_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='description' class='control-label '>description:</label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='description' id='description' title='description'  rows=5 cols=60 required> <?php echo $breedDog->get_description(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='description_es' class='control-label '>description_es:</label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='description_es' id='description_es' title='description_es' rows=5 cols=60 required> <?php echo $breedDog->get_description_es(); ?> </textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='origin' class='control-label '>origin: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='origin' id='origin' title='origin' rows=5 cols=60 required><?php echo $breedDog->get_origin(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='origin_es' class='control-label '>origin_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='origin_es' id='origin_es' title='origin_es' rows=5 cols=60 required><?php echo $breedDog->get_origin_es(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='morphology' class='control-label '>morphology: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='morphology' id='morphology' title='morphology' rows=5 cols=60 required><?php echo $breedDog->get_morphology(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='morphology_es' class='control-label '>morphology_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='morphology_es' id='morphology_es' title='morphology_es' rows=5 cols=60 required><?php echo $breedDog->get_morphology_es(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='temperament' class='control-label '>temperament: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='temperament' id='temperament' title='temperament' rows=5 cols=60 required><?php echo $breedDog->get_temperament(); ?> </textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='temperament_es' class='control-label '>temperament_es: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='temperament_es' id='temperament_es' title='temperament_es' rows=5 cols=60 required><?php echo $breedDog->get_temperament_es(); ?></textarea>
        </div>
    </div> 

    <div class='form-group m-4' >  
        <label for='weight' class='control-label '>weight / peso: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='weight' id='weight' title='weight' value='<?php echo $breedDog->get_weight(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='wiki_url' class='control-label '>wiki_url:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='wiki_url' id='wiki_url' title='wiki_url' value='<?php echo $breedDog->get_wiki_url(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='bred_for' class='control-label '>bred_for / criado para: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='bred_for' id='bred_for' title='bred_for' value='<?php echo $breedDog->get_bred_for(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='bred_for_es' class='control-label '>bred_for_es criado para_es: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='bred_for_es' id='bred_for_es' title='bred_for_es' value='<?php echo $breedDog->get_bred_for_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='breed_group' class='control-label '>breed_group / grupo de raza: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='breed_group' id='breed_group' title='breed_group' value='<?php echo $breedDog->get_breed_group(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='breed_group_es' class='control-label '>breed_group_es / grupo de raza_es: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='breed_group_es' id='breed_group_es' title='breed_group_es' value='<?php echo $breedDog->get_breed_group_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='life_span' class='control-label '>life_span / esperanza de vida: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='life_span' id='life_span' title='life_span' value='<?php echo $breedDog->get_life_span(); ?>' required />
        </div>
    </div> 
   
    <div class='form-group m-4' >  
        <label for='height' class='control-label '>height / altura: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='height' id='height' title='height' value='<?php echo $breedDog->get_height(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='date' class='control-label '>date: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='date' id='date' title='date' value='<?php echo $breedDog->get_date(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='reference_image_id' class='control-label '>reference_image_id: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='reference_image_id' id='reference_image_id' title='reference_image_id' value='<?php echo $breedDog->get_reference_image_id(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='path_image' class='control-label '>path_image: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='path_image' id='path_image' title='path_image' value='<?php echo $breedDog->get_path_image(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='creator_id' class='control-label '>creator_id:</label> 
        <div class='col'>
            <input type='number' class='form-control' name='creator_id' id='creator_id' title='creator_id' value='<?php echo $breedDog->get_creator_id(); ?>' />
        </div>
    </div> 
    


    <div class='form-group m-4' > 
        <div class='col col-md-offset-2' >
            <input type="hidden" name="id" id="id" value='<?php echo $breedDog->get_id() ?>' />
            <input type='submit' name="submit" id="submit" value='Update' class='btn btn-primary' ></input> 
            <!--<input type='button' name="remove" id="remove" value='Remove' class='btn btn-danger' data-toggle="modal" data-target="#deleteModal" ></input> -->
            <a href="<?php echo PATHSERVER; ?>BreedDog/delete/<?php echo $breedDog->get_id(); ?>" class="btn btn-danger">   Delete   </a>
        </div>
    </div> 
</form>
<!----------------------------------------------------------------------------------------------------------------------->
<!---------------------------------------FINAL DEL FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->











<?php include_once("./views/templates/document-end.php"); ?>