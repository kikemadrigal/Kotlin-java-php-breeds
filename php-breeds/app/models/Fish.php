<?php

Class Fish {
	private $id;
	private $name;
	private $name_es;
	private $specie_id;
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
    function set_specie_id($specie_id){
		$this->specie_id=$specie_id;
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
    function get_specie_id(){
		return $this->specie_id;
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