<?php 
$cat=$this->cat;
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
                <a href="<?php echo PATHSERVER; ?>Cat/delete/<?php echo $cat->get_id(); ?>" class="btn btn-primary">   SI   </a>
            </div>
        </div>
    </div>
</div>


<h3>Update Cat </h3>

<!----------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------ FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->
<!-- Patrones: para campos con números: pattern='[0-9]{1,10000}'-->
<form method=post action='<?php echo PATHSERVER."Cat/update"?>' class='form-horizontal background-pink' enctype='multipart/form-data'>

    <div class='form-group m-4' >  
        <label for='name' class='control-label '>Name:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name' id='name' title='name' value='<?php echo $cat->get_name(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='name_es' class='control-label '>Name_es:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name_es' id='name_es' title='name_es' value='<?php echo $cat->get_name_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='breed_id' class='control-label '>breed_id:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='breed_id' id='breed_id' title='breed_id' value='<?php echo $cat->get_breed_id(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='family' class='control-label '>family: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='family' id='family' title='family' value='<?php echo $cat->get_family(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='description' class='control-label '>description: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='description' id='description' title='description' value='<?php echo $cat->get_description(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='description_es' class='control-label '>description_es: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='description_es' id='description_es' title='description_es' value='<?php echo $cat->get_description_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='year_of_birth' class='control-label '>year_of_birth: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='year_of_birth' id='year_of_birth' title='year_of_birth' value='<?php echo $cat->get_year_of_birth(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='sex' class='control-label '>sex: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='sex' id='sex' title='sex' value='<?php echo $cat->get_sex(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='address' class='control-label '>address: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='address' id='address' title='address' value='<?php echo $cat->get_address(); ?>' required />
        </div>
    </div> 
    <!--<div class='form-group m-4' >  
        <label for='vaccines' class='control-label '>vaccines: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='vaccines' id='vaccines' title='vaccines' value='<?php echo $cat->get_vaccines(); ?>' required />
        </div>
    </div> -->
    <div class='form-group m-4' >  
        <label for='path_image' class='control-label '>path_image: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='path_image' id='path_image' title='path_image' value='<?php echo $cat->get_path_image(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='validate' class='control-label '>validate: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='validate' id='validate' title='validate' value='<?php echo $cat->get_validate(); ?>'  />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='creator_id' class='control-label '>creator_id:</label> 
        <div class='col'>
            <input type='number' class='form-control' name='creator_id' id='creator_id' title='creator_id' value='<?php echo $cat->get_creator_id(); ?>' />
        </div>
    </div> 
    


    <div class='form-group m-4' > 
        <div class='col col-md-offset-2' >
            <input type="hidden" name="id" id="id" value='<?php echo $cat->get_id() ?>' />
            <input type='submit' name="submit" id="submit" value='Update' class='btn btn-primary' ></input> 
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
            Delete
            </button>
        </div>
    </div> 
</form>
<!----------------------------------------------------------------------------------------------------------------------->
<!---------------------------------------FINAL DEL FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->











<?php include_once("./views/templates/document-end.php"); ?>