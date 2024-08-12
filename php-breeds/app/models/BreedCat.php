<?php

Class BreedCat {
	private $id;
	private $id_name;
	private $name;
	private $name_es;
	private $cfa_url;
	private $vetstreet_url;
	private $vcahospitals_url;
	private $temperament;
	private $temperament_es;
	private $origin;
	private $origin_es;
	private $country_codes;
	private $country_code;
	private $description;
	private $description_es;
	private $morphology;
	private $morphology_es;
	private $life_span;
	//interior
	private $indoor;
	//regazo
	private $lap;
	//nombres alternativos
	private $alt_names;
  	private $adaptability;
  	private $affection_level;
  	private $child_friendly;
  	private $cat_friendly;
  	private $dog_friendly;
  	private $energy_level;
	//aseo
	private $grooming;
	//problemas de salud
	private $health_issues;
	private $intelligence;
	//nivel de muda
    private $shedding_level;
	//necesidades sociales
	private $social_needs;
	private $stranger_friendly;
	//vocalización
  	private $vocalisation;
  	private $experimental;
	//sin pelo
	private $hairless;
  	private $natural;
  	private $rare;
  	private $rex;
	//cola suprimida
	private $suppressed_tail;
	//piernas cortas
  	private $short_legs;
  	private $wikipedia_url;
	//hipoalergénica
	private $hypoallergenic;
	//peso
	private $weight;
	//Las razas pueden tener varias imágenes
  	private $date;
  	private $reference_image_id;
	private $path_image;
  	private $creator_id;




	
	/**
	 * CONSTRUCTOR
	 */
	function __construct($id){
		$this->id=$id;
	}
	

	/**
	 * SETTERS
	 */
	function set_id_name($id_name){
		$this->id_name=$id_name;
	}
	function set_name($name){
		$this->name=$name;
	}
	function set_name_es($name_es){
		$this->name_es=$name_es;
	}
	function set_cfa_url($cfa_url){
		$this->cfa_url=$cfa_url;
	}
	function set_vetstreet_url($vetstreet_url){
		$this->vetstreet_url=$vetstreet_url;
	}
	function set_vcahospitals_url($vcahospitals_url){
		$this->vcahospitals_url=$vcahospitals_url;
	}
	function set_temperament($temperament){
		$this->temperament=$temperament;
	}
	function set_temperament_es($temperament_es){
		$this->temperament_es=$temperament_es;
	}
	function set_origin($origin){
		$this->origin=$origin;
	}
	function set_origin_es($origin_es){
		$this->origin_es=$origin_es;
	}
	function set_country_codes($country_codes){
		$this->country_codes=$country_codes;
	}
	function set_country_code($country_code){
		$this->country_code=$country_code;
	}
	function set_description($description){
		$this->description=$description;
	}
	function set_description_es($description_es){
		$this->description_es=$description_es;
	}
	function set_morphology($morphology){
		$this->morphology=$morphology;
	}
	function set_morphology_es($morphology_es){
		$this->morphology_es=$morphology_es;
	}
	function set_life_span($life_span){
		$this->life_span=$life_span;
	}
	function set_indoor($indoor){
		$this->indoor=$indoor;
	}
	function set_lap($lap){
		$this->lap=$lap;
	}
	function set_alt_names($alt_names){
		$this->alt_names=$alt_names;
	}
	function set_adaptability($adaptability){
		$this->adaptability=$adaptability;
	}
	function set_affection_level($affection_level){
		$this->affection_level=$affection_level;
	}
	function set_child_friendly($child_friendly){
		$this->child_friendly=$child_friendly;
	}
	function set_cat_friendly($cat_friendly){
		$this->cat_friendly=$cat_friendly;
	}
	function set_dog_friendly($dog_friendly){
		$this->dog_friendly=$dog_friendly;
	}
	function set_energy_level($energy_level){
		$this->energy_level=$energy_level;
	}
	function set_grooming($grooming){
		$this->grooming=$grooming;
	}
	function set_health_issues($health_issues){
		$this->health_issues=$health_issues;
	}
	function set_intelligence($intelligence){
		$this->intelligence=$intelligence;
	}
	function set_shedding_level($shedding_level){
		$this->shedding_level=$shedding_level;
	}
	function set_social_needs($social_needs){
		$this->social_needs=$social_needs;
	}
	function set_stranger_friendly($stranger_friendly){
		$this->stranger_friendly=$stranger_friendly;
	}
	function set_vocalisation($vocalisation){
		$this->vocalisation=$vocalisation;
	}
	function set_experimental($experimental){
		$this->experimental=$experimental;
	}
	function set_hairless($hairless){
		$this->hairless=$hairless;
	}
	function set_natural($natural){
		$this->natural=$natural;
	}
	function set_rare($rare){
		$this->rare=$rare;
	}
	function set_rex($rex){
		$this->rex=$rex;
	}
	function set_suppressed_tail($suppressed_tail){
		$this->suppressed_tail=$suppressed_tail;
	}
	function set_short_legs($short_legs){
		$this->short_legs=$short_legs;
	}
	function set_wikipedia_url($wikipedia_url){
		$this->wikipedia_url=$wikipedia_url;
	}
	function set_hypoallergenic($hypoallergenic){
		$this->hypoallergenic=$hypoallergenic;
	}
	function set_weight($weight){
		$this->weight=$weight;
	}
	function set_date($date){
		$this->date=$date;
	}
	function set_reference_image_id($reference_image_id){
		$this->reference_image_id=$reference_image_id;
	}
	function set_path_image($path_image){
		$this->path_image=$path_image;
	}
	function set_creator_id($creator_id){
		$this->creator_id=$creator_id;
	}



	








	/**
	 * GETTERS
	 */
	function get_id(){
		return $this->id;
	}
	function get_id_name(){
		return $this->id_name;
	}
	function get_name(){
		return $this->name;
	}
	function get_name_es(){
		return $this->name_es;
	}
	function get_cfa_url(){
		return $this->cfa_url;
	}
	function get_vetstreet_url(){
		return $this->vetstreet_url;
	}
	function get_vcahospitals_url(){
		return $this->vcahospitals_url;
	}
	function get_temperament(){
		return $this->temperament;
	}
	function get_temperament_es(){
		return $this->temperament_es;
	}
	function get_origin(){
		return $this->origin;
	}
	function get_origin_es(){
		return $this->origin_es;
	}
	function get_country_codes(){
		return $this->country_codes;
	}
	function get_country_code(){
		return $this->country_code;
	}
	function get_description(){
		return $this->description;
	}
	function get_description_es(){
		return $this->description_es;
	}
	function get_morphology(){
		return $this->morphology;
	}
	function get_morphology_es(){
		return $this->morphology_es;
	}
	function get_life_span(){
		return $this->life_span;
	}
	function get_indoor(){
		return $this->indoor;
	}
	function get_lap(){
		return $this->lap;
	}
	function get_alt_names(){
		return $this->alt_names;
	}
	function get_adaptability(){
		return $this->adaptability;
	}
	function get_affection_level(){
		return $this->affection_level;
	}
	function get_child_friendly(){
		return $this->child_friendly;
	}
	function get_cat_friendly(){
		return $this->cat_friendly;
	}
	function get_dog_friendly(){
		return $this->dog_friendly;
	}
	function get_energy_level(){
		return $this->energy_level;
	}
	function get_grooming(){
		return $this->grooming;
	}
	function get_health_issues(){
		return $this->health_issues;
	}
	function get_intelligence(){
		return $this->intelligence;
	}
	function get_shedding_level(){
		return $this->shedding_level;
	}
	function get_social_needs(){
		return $this->social_needs;
	}
	function get_stranger_friendly(){
		return $this->stranger_friendly;
	}
	function get_vocalisation(){
		return $this->vocalisation;
	}
	function get_experimental(){
		return $this->experimental;
	}
	function get_hairless(){
		return $this->hairless;
	}
	function get_natural(){
		return $this->natural;
	}
	function get_rare(){
		return $this->rare;
	}
	function get_rex(){
		return $this->rex;
	}
	function get_suppressed_tail(){
		return $this->suppressed_tail;
	}
	function get_short_legs(){
		return $this->short_legs;
	}
	function get_wikipedia_url(){
		return $this->wikipedia_url;
	}
	function get_hypoallergenic(){
		return $this->hypoallergenic;
	}
	function get_weight(){
		return $this->weight;
	}
	function get_date(){
		return $this->date;
	}
	function get_reference_image_id(){
		return $this->reference_image_id;
	}
	function get_path_image(){
		return $this->path_image;
	}
	function get_creator_id(){
		return $this->creator_id;
	}


	
	
	
	/**
	 * TODTRING
	 */
	function to_string(){
		$path=$this->path_image;
		$order   = array("\\", "\\\\", "\\\\\\");
		$path=str_replace($order,"/",$path);
		return"<br><img src=".PATHSERVER.$path." width=40px>Cat id: ".$this->id.", name: ".$this->name.", path: ".$this->path_image.", creator: ".$this->creator_id;	
	}

	
	
}

?>