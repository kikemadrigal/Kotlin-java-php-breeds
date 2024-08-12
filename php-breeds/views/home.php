<?php include_once("./views/templates/document-start.php");
echo "<h2>Latest uploads cats</h2>";
foreach ($this->lastFiveCatsUploads as $posicion=>$cat){
	echo "<div class='row'>";
		echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
			echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$cat->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
		echo "</div>";
		echo "<div class='col-md-4 col-sm-12 '>";
			echo "<h4>Nombre: ".$cat->get_name_es()."</h4>";
			echo "<h4>id: ".UserRepository::getNameById($cat->get_creator_id())."</h4>";
		echo "</div>";
	echo "</div>";
}
echo "<h2>Latest uploads dogs</h2>";
foreach ($this->lastFiveDogsUploads as $posicion=>$dog){
	echo "<div class='row'>";
		echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
			echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$dog->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
		echo "</div>";
		echo "<div class='col-md-4 col-sm-12 '>";
			echo "<h4>Nombre: ".$dog->get_name_es()."</h4>";
			echo "<h4>id: ".UserRepository::getNameById($dog->get_creator_id())."</h4>";
		echo "</div>";
	echo "</div>";
}
echo "<h2>Latest uploads fish</h2>";
foreach ($this->lastFiveFishUploads as $posicion=>$fish){
	echo "<div class='row'>";
		echo "<div class='col-md-8 d-flex align-items-center justify-content-left '>";
			echo "<p class='mx-auto'><img src='".PATHSERVERSININDEX.$fish->get_path_image()."' class='img-fluid' style='max-height:500px' /></p>";
		echo "</div>";
		echo "<div class='col-md-4 col-sm-12 '>";
			echo "<h4>Nombre: ".$fish->get_name_es()."</h4>";
			echo "<h4>id: ".UserRepository::getNameById($fish->get_creator_id())."</h4>";
		echo "</div>";
	echo "</div>";
}


include_once("./views/templates/document-end.php");?>
		






















			



