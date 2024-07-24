<?php

Class SpecieFish {
	private $id;
	private $name;
	private $name_es;
	private $description;
	private $url_wiki;
	private $url_image;
	private $morphology;
	private $habitat;
	private $feeding;
	private $phylum;
	private $class;
	private $orden;
	private $family;
	private $genus;
	private $path_image;
	private $date;
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
	function set_name($name){
		$this->name=$name;
	}
    function set_name_es($name_es){
		$this->name_es=$name_es;
	}
    function set_description($description){
		$this->description=$description;
	}
	function set_url_wiki($url_wiki){
		$this->url_wiki=$url_wiki;
	}
	function set_url_image($url_image){
		$this->url_image=$url_image;
	}
	function set_morphology($morphology){
		$this->morphology=$morphology;
	}
	function set_habitat($habitat){
		$this->habitat=$habitat;
	}
	function set_feeding($feeding){
		$this->feeding=$feeding;
	}
	function set_phylum($phylum){
		$this->phylum=$phylum;
	}
	function set_class($class){
		$this->class=$class;
	}
	function set_orden($orden){
		$this->orden=$orden;
	}
	function set_family($family){
		$this->family=$family;
	}
	function set_genus($genus){
		$this->genus=$genus;
	}
    function set_path_image($path_image){
		$this->path_image=$path_image;
	}
    function set_date($date){
		$this->date=$date;
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
	function get_name(){
		return $this->name;
	}
    function get_name_es(){
		return $this->name_es;
	}
    function get_description(){
		return $this->description;
	}
	function get_url_wiki(){
		return $this->url_wiki;
	}
	function get_url_image(){
		return $this->url_image;
	}
	function get_morphology(){
		return $this->morphology;
	}
	function get_habitat(){
		return $this->habitat;
	}
	function get_feeding(){
		return $this->feeding;
	}
	function get_phylum(){
		return $this->phylum;
	}
	function get_class(){
		return $this->class;
	}
	function get_orden(){
		return $this->orden;
	}
	function get_family(){
		return $this->family;
	}
	function get_genus(){
		return $this->genus;
	}
    function get_path_image(){
		return $this->path_image;
	}
    function get_date(){
		return $this->date;
	}
    function get_creator_id(){
		return $this->creator_id;
	}

    	
	/**
	 * TODTRING
	 */
	function to_String(){
		return"<br><img src=".PATHSERVER.$this->path_image." width=40px>Cat id: ".$this->id.", name: ".$this->name.", path: ".$this->path_image.", creator: ".$this->creator_id;	
	}
}

?>