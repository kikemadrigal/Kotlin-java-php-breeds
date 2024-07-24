<?php

Class Dog {
	private $id;
	private $name;
	private $name_es;
	private $breed_id;
	private $family;
	private $description;
	private $description_es;
	private $year_of_birth;
	private $sex;
	private $address;
	private $vaccines;
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
    function set_breed_id($breed_id){
		$this->breed_id=$breed_id;
	}
    function set_family($family){
		$this->family=$family;
	}
	function set_description($description){
		$this->description=$description;
	}
	function set_description_es($description_es){
		$this->description_es=$description_es;
	}
	function set_year_of_birth($year_of_birth){
		$this->year_of_birth=$year_of_birth;
	}
	function set_sex($sex){
		$this->sex=$sex;
	}
	function set_address($address){
		$this->address=$address;
	}
	function set_vaccines($vaccines){
		$this->vaccines=$vaccines;
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
    function get_breed_id(){
		return $this->breed_id;
	}
    function get_family(){
		return $this->family;
	}
	function get_description(){
		return $this->description;
	}
	function get_description_es(){
		return $this->description_es;
	}
	function get_year_of_birth(){
		return $this->year_of_birth;
	}
	function get_sex(){
		return $this->sex;
	}
	function get_address(){
		return $this->address;
	}
	function get_vaccines(){
		return $this->vaccines;
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
		return"<br><img src=".PATHSERVERSININDEX.$this->path_image." width=40px>Dog id: ".$this->id.", name: ".$this->name.", breed id: ".$this->breed_id.", path: ".$this->path_image.", creator: ".$this->creator_id;	
	}
}

?>