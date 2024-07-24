<?php
//https://api.thedogapi.com/v1/ 
//https://api.thedogapi.com/v1/breeds
Class BreedDog {
	private $id;
	private $breed_id;
	private $name;
	private $name_es;
	private $description;
	private $description_es;
	private $wiki_url;
	//criado para
	private $bred_for;
	private $bred_for_es;
	//grupo de raza
	private $breed_group;
	private $breed_group_es;
	//esperanza de vida
	private $life_span;
	private $temperament;
	private $temperament_es;
	private $origin;
	private $origin_es;
	private $morphology;
	private $morphology_es;
	private $weight;
	private $height;
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
	function set_breed_id($breed_id){
		$this->breed_id=$breed_id;
	}
	function set_name($name){
		$this->name=$name;
	}
	function set_name_es($name_es){
		$this->name_es=$name_es;
	}
	function set_description($description){
		$this->description=$description;
	}
	function set_description_es($description_es){
		$this->description_es=$description_es;
	}
	function set_wiki_url($wiki_url){
		$this->wiki_url=$wiki_url;
	}
	function set_bred_for($bred_for){
		$this->bred_for=$bred_for;
	}
	function set_bred_for_es($bred_for_es){
		$this->bred_for_es=$bred_for_es;
	}
	function set_breed_group($breed_group){
		$this->breed_group=$breed_group;
	}
	function set_breed_group_es($breed_group_es){
		$this->breed_group_es=$breed_group_es;
	}
	function set_life_span($life_span){
		$this->life_span=$life_span;
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
	function set_morphology($morphology){
		$this->morphology=$morphology;
	}
	function set_morphology_es($morphology_es){
		$this->morphology_es=$morphology_es;
	}
	function set_weight($weight){
		$this->weight=$weight;
	}
	function set_height($height){
		$this->height=$height;
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
	function get_breed_id(){
		return $this->breed_id;
	}
	function get_name(){
		return $this->name;
	}
	function get_name_es(){
		return $this->name_es;
	}
	function get_description(){
		return $this->description;
	}
	function get_description_es(){
		return $this->description_es;
	}
	function get_wiki_url(){
		return $this->wiki_url;
	}
	function get_bred_for(){
		return $this->bred_for;
	}
	function get_bred_for_es(){
		return $this->bred_for_es;
	}
	function get_breed_group(){
		return $this->breed_group;
	}
	function get_breed_group_es(){
		return $this->breed_group_es;
	}
	function get_life_span(){
		return $this->life_span;
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
	function get_morphology(){
		return $this->morphology;
	}
	function get_morphology_es(){
		return $this->morphology_es;
	}
	function get_weight(){
		return $this->weight;
	}
	function get_height(){
		return $this->height;
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
		return"<br>Dog id: ".$this->id.", name: ".$this->name.", date: ".$this->date.", creator: ".$this->creator_id;	
	}

	
	
}

?>