<?php
include_once("./views/templates/document-start.php"); 
?>
<div class="container">
  <div class="row">
    
    

<?php
$cat=$this->cat;
$breedCat=$this->breedCat;
if($cat==NULL) echo "empty cat";
	else{
		if ($cat->get_path_image()!=NULL){
			echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
				echo "<p><img src='../../".$cat->get_path_image()."' class='img-fluid'/></p>";
			echo "</div>";
			echo "<div class='col-md-4 col-sm-12'>";
				echo "<p>".$cat->get_name()."</p>";
				echo "<p>".$cat->get_name_es()."</p>";
				echo "<p>".$breedCat->get_name()."</p>";
			echo "</div>";
		}else{
			echo "Not data";
		}
	}	
?>
  </div>
</div>
<?php
include_once("./views/templates/document-end.php"); 
?>