<?php 
$specieFish=$this->specieFish;
include_once("./views/templates/document-start.php"); 
if(isset($_SESSION['idusuario']) && $_SESSION['nivelaccesousuario']==1)
  include_once("./views/templates/barra-admin.php"); 
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
                <a href="<?php echo PATHSERVER; ?>SpecieFish/delete/<?php echo $specieFish->get_id(); ?>" class="btn btn-primary">   SI   </a>
            </div>
        </div>
    </div>
</div>


<h3>Update Breed cat </h3>

<!----------------------------------------------------------------------------------------------------------------------->
<!------------------------------------------------ FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->
<!-- Patrones: para campos con números: pattern='[0-9]{1,10000}'-->
<form method=post action='<?php echo PATHSERVER."SpecieFish/update"?>' class='form-horizontal background-pink' enctype='multipart/form-data'>
    <div class='form-group m-4' >  
        <label for='name' class='control-label '>Name:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name' id='name' title='name' value='<?php echo $specieFish->get_name(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >
        <label for='name_es' class='control-label '>name_es:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='name_es' id='name_es' title='name_es' value='<?php echo $specieFish->get_name_es(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='description' class='control-label '>description: </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='description' id='description' title='description' rows=5 cols=60 title='description' required><?php echo $specieFish->get_description(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='url_wiki' class='control-label '>url_wiki: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='url_wiki' id='url_wiki' title='url_wiki' value='<?php echo $specieFish->get_url_wiki(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='url_image' class='control-label '>url_image </label> 
        <div class='col'>
            <input type='text' class='form-control' name='url_image' id='url_image' title='url_image' value='<?php echo $specieFish->get_url_image(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='morphology' class='control-label '>morphology </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='morphology' id='morphology' title='morphology' rows=5 cols=60 title='morphology' required><?php echo $specieFish->get_morphology(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='habitat' class='control-label '>habitat </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='habitat' id='habitat' title='habitat' rows=5 cols=60 title='habitat' required><?php echo $specieFish->get_habitat(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='feeding' class='control-label '>feeding </label> 
        <div class='col'>
            <textarea type='text' class='form-control' name='feeding' id='feeding' title='feeding' rows=5 cols=60 title='feeding' required><?php echo $specieFish->get_feeding(); ?></textarea>
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='phylum' class='control-label '>phylum:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='phylum' id='phylum' title='phylum' value='<?php echo $specieFish->get_phylum(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='class' class='control-label '>class:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='class' id='class' title='class' value='<?php echo $specieFish->get_class(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='orden' class='control-label '>orden:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='orden' id='orden' title='orden' value='<?php echo $specieFish->get_orden(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='family' class='control-label '>family:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='family' id='family' title='family' value='<?php echo $specieFish->get_family(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='genus' class='control-label '>genus:</label> 
        <div class='col'>
            <input type='text' class='form-control' name='genus' id='genus' title='genus' value='<?php echo $specieFish->get_genus(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='path_image' class='control-label '>path_image: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='path_image' id='path_image' title='path_image' value='<?php echo $specieFish->get_path_image(); ?>' required />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='date' class='control-label '>date: </label> 
        <div class='col'>
            <input type='text' class='form-control' name='date' id='date' title='date' value='<?php echo $specieFish->get_date(); ?>' />
        </div>
    </div> 
    <div class='form-group m-4' >  
        <label for='creator_id' class='control-label '>creator_id:</label> 
        <div class='col'>
            <input type='number' class='form-control' name='creator_id' id='creator_id' title='creator_id' value='<?php echo $specieFish->get_creator_id(); ?>' />
        </div>
    </div> 
    


    <div class='form-group m-4' > 
        <div class='col col-md-offset-2' >
            <input type="hidden" name="id" id="id" value='<?php echo $specieFish->get_id() ?>' />
            <input type='submit' name="submit" id="submit" value='Update' class='btn btn-primary' ></input> 
            <!--<input type='button' name="remove" id="remove" value='Remove' class='btn btn-danger' data-toggle="modal" data-target="#deleteModal" ></input> -->
            <a href="<?php echo PATHSERVER; ?>SpecieFish/delete/<?php echo $specieFish->get_id(); ?>" class="btn btn-danger">   Delete   </a>
        </div>
    </div> 
</form>
<!----------------------------------------------------------------------------------------------------------------------->
<!---------------------------------------FINAL DEL FORMULARIO ACTUALIZAR------------------------------------------------->
<!----------------------------------------------------------------------------------------------------------------------->











<?php include_once("./views/templates/document-end.php"); ?>