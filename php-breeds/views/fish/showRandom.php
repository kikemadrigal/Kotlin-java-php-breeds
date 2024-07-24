<?php
include_once("./views/templates/document-start.php"); 
?>
<div class="container">
  <div class="row">
		<?php
		$fish=$this->fish;
		$specieFish=$this->specieFish;
		if($fish==NULL) echo "empty fish";
			else{
				if ($fish->get_path_image()!=NULL){
					echo "<div class='col-md-8 d-flex align-items-center justify-content-left'>";
					$photo=str_replace(" ","%20",$fish->get_path_image());
					echo "<p><img src=".PATHSERVERSININDEX.$photo." class='img-fluid'></img></p>";
					echo "</div>";
					echo "<div class='col-md-4 col-sm-12'>";
						echo "<p>".$fish->get_name_es()."</p>";
						echo "<p><a href='".PATHSERVER."SpecieFish/show/".$fish->get_specie_id()."'>".$specieFish->get_name()."</a></p>";
						echo "<p>path_image: ".$fish->get_path_image()."</p>";
						echo "<p>date: ".$fish->get_date()."</p>";
						echo "<p>creator_id: ".$fish->get_creator_id()."</p>";
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