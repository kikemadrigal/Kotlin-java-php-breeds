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
						echo "<a class='btn-success' href='".PATHSERVER."Fish/showRandom'>Puntuar otro</a>";
						echo "<p>".$fish->get_name_es()."</p>";
						echo "<p><a href='".PATHSERVER."SpecieFish/show/".$fish->get_specie_id()."'>".$specieFish->get_name()."</a></p>";
						echo "<p>path_image: ".$fish->get_path_image()."</p>";
						echo "<p>date: ".$fish->get_date()."</p>";
						echo "<p>creator_id: ".$fish->get_creator_id()."</p>";
						echo "<p><a href='".PATHSERVER."Fish/showRanking'>Mostrar ranking bellezas</a>";

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