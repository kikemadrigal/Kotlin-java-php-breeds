<?php 
$page=$this->page;
$rowCount=$this->rowCount;
$pageReal=$page-1;
$errors=0;
include_once("./views/templates/document-start.php"); 
/*if($this->fishs==NULL) {
	echo "fish es nulo";
	die();
}
else{*/
?>


<nav class="navbar">
    <ul class="pagination">
        <?php if($pageReal>0) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showRanking/".$page-2; ?>">Previous</a></li>
        <?php } ?>
        <li class="page-item disabled"><a class="page-link" href="#"><?php echo $pageReal;?></a></li>
        <?php if($pageReal+1<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showRanking/".$pageReal+1; ?>"><?php echo $pageReal+1;?></a></li>
        <?php } ?>
        <?php if($pageReal+2<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showRanking/".$pageReal+2; ?>"><?php echo $pageReal+2;?></a></li>
        <?php } ?>
        <?php if($pageReal+3<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showRanking/".$pageReal+3; ?>"><?php echo $pageReal+3;?></a></li>
        <?php } ?>
        <?php if($page<$rowCount/10) {?>
        <li class="page-item"><a class="page-link" href="<?php echo PATHSERVER."Fish/showRanking/".$page; ?>">Next</a></li>
        <?php } ?>
    </ul>

    <form class="d-flex align-items-center" method='post' action='<?php echo PATHSERVER; ?>Fish/search' >
        <input class="form-control" type="search" name="search" id="search" placeholder="Search fish name" aria-label="Search" >
        <button class="btn btn-outline-success" type="submit" name="submit">Search</button>
    </form>
</nav>


<?php

    if ($errors>0) echo "Errors: ".$errors;
    foreach ($this->fishs as $posicion=>$fish){
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
            <?php
            echo "<p>Puntos: ".$fish->get_total_points()."</p>";
                echo "<p>Puntuar: ";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/1'> 1 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/2'> 2 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/3'> 3 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/4'> 4 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/5'> 5 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/6'> 6 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/7'> 7 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/8'> 8 </a>";
                echo "<a href='".PATHSERVER."Fish/updateBeauty/".$fish->get_id()."/9'> 9 </a>";
            echo "</p>";
        ?>
        </div>
        <?php	
    }	
include_once("./views/templates/document-end.php");?>

		

