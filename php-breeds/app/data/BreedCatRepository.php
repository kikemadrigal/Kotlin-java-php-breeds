<?php

class BreedCatRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$breedCat=new BreedCat($linea['id']);
		$breedCat->set_id_name($linea['id_name']);
		$breedCat->set_name($linea['name']);
		$breedCat->set_name_es($linea['name_es']);
		$breedCat->set_cfa_url($linea['cfa_url']);
		$breedCat->set_vetstreet_url($linea['vetstreet_url']);
		$breedCat->set_vcahospitals_url($linea['vcahospitals_url']);
		$breedCat->set_temperament($linea['temperament']);
		$breedCat->set_temperament_es($linea['temperament_es']);
		$breedCat->set_origin($linea['origin']);
		$breedCat->set_origin_es($linea['origin_es']);
		$breedCat->set_country_codes($linea['country_codes']);
		$breedCat->set_country_code($linea['country_code']);
		$breedCat->set_life_span($linea['life_span']);
		$breedCat->set_description($linea['description']);
		$breedCat->set_description_es($linea['description_es']);
		$breedCat->set_morphology($linea['morphology']);
		$breedCat->set_morphology_es($linea['morphology_es']);
		//interior
		$breedCat->set_indoor($linea['indoor']);
		//regazo
		$breedCat->set_lap($linea['lap']);
		//nombres alternativos
		$breedCat->set_alt_names($linea['alt_names']);
		$breedCat->set_adaptability($linea['adaptability']);
		$breedCat->set_affection_level($linea['affection_level']);
		$breedCat->set_child_friendly($linea['child_friendly']);
		$breedCat->set_cat_friendly($linea['cat_friendly']);
		$breedCat->set_dog_friendly($linea['dog_friendly']);
		$breedCat->set_energy_level($linea['energy_level']);
		 //aseo
		$breedCat->set_grooming($linea['grooming']);
		 //problemas de salud
		$breedCat->set_health_issues($linea['health_issues']);
		$breedCat->set_intelligence($linea['intelligence']);
		//nivel de muda
		$breedCat->set_shedding_level($linea['shedding_level']);
		 //necesidades sociales
		$breedCat->set_social_needs($linea['social_needs']);
		$breedCat->set_stranger_friendly($linea['stranger_friendly']);
		$breedCat->set_vocalisation($linea['vocalisation']);
		$breedCat->set_experimental($linea['experimental']);
		//sin pelo
		$breedCat->set_hairless($linea['hairless']);
		$breedCat->set_natural($linea['natural']);
		$breedCat->set_rare($linea['rare']);
		$breedCat->set_rex($linea['rex']);
		//cola suprimida
		$breedCat->set_suppressed_tail($linea['suppressed_tail']);
		//patas cortas
		$breedCat->set_short_legs($linea['short_legs']);
		$breedCat->set_wikipedia_url($linea['wikipedia_url']);
		//hipoalergénica
		$breedCat->set_hypoallergenic($linea['hypoallergenic']);
		//peso
		$breedCat->set_weight($linea['weight']);
		$breedCat->set_date($linea['date']);
		$breedCat->set_reference_image_id($linea['reference_image_id']);
		$breedCat->set_path_image($linea['path_image']);
		$breedCat->set_creator_id($linea['creator_id']);
		return $breedCat;
	}
	
	public static function getById($id){
		$breedCat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $breedCat;
	}

	public static function getByIdName($id_name){
		$breedCat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat WHERE id_name ='".$id_name."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $breedCat;
	}
	public static function getByName($name){
		$breedCats=array();
		$breedCat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat WHERE id_name LIKE '".$name."%'";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
			$breedCats[]=$breedCat;
		}
		$basededatos->desconectar();
		return $breedCats;
	}
	public static function getByName_es($name_es){
		$breedCats=array();
		$breedCat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat WHERE name_es LIKE '%".$name_es."%'";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
			$breedCats[]=$breedCat;
		}
		$basededatos->desconectar();
		return $breedCats;
	}
	public static function getAuthorById($id){
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT author FROM games WHERE id='$id' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			return $linea['author'];
		}
		$basededatos->desconectar();
	}




	/**
	 * Parametros:
	 * start registro de inicio
	 * end: maximos registros a buscar
	 */
	
	public static function getAll($init){
		$breedCats=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat ORDER BY id LIMIT ".$init.", 10 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
			$breedCats[]=$breedCat;
		}
		$basededatos->desconectar();
		return $breedCats;
	}
	

	public static function getAllByUser($idUser, $start, $end){
		$breedCats=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_cat WHERE creator_id='".$idUser."' limit ".$start .", ".$end."";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
			$breedCats[]=$breedCat;
		}
		$basededatos->desconectar();
		return $breedCats;
	}
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM breed_cat";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}


	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($breedCat){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsBreedCatTable()){
			echo "breedCat table not exists";
			die();
		}
		$sql="INSERT INTO breed_cat VALUES ( '', '"
			.$breedCat->get_id_name()."', '"
			.$breedCat->get_name()."', '"
			.$breedCat->get_name_es()."', '"
			.$breedCat->get_cfa_url()."', '"
			.$breedCat->get_vetstreet_url()."', '"
			.$breedCat->get_vcahospitals_url()."', '"
			.$breedCat->get_temperament()."', '"
			.$breedCat->get_temperament_es()."', '"
			.$breedCat->get_origin()."', '"
			.$breedCat->get_origin_es()."', '"
			.$breedCat->get_country_codes()."', '"
			.$breedCat->get_country_code()."', '"
			.$breedCat->get_description()."', '"
			.$breedCat->get_description_es()."', '"
			.$breedCat->get_morphology()."', '"
			.$breedCat->get_morphology_es()."', '"
			.$breedCat->get_life_span()."', '"
			.$breedCat->get_indoor()."', '"
			.$breedCat->get_lap()."', '"
			.$breedCat->get_alt_names()."', '"
			.$breedCat->get_adaptability()."', '"
			.$breedCat->get_affection_level()."', '"
			.$breedCat->get_child_friendly()."', '"
			.$breedCat->get_cat_friendly()."', '"
			.$breedCat->get_dog_friendly()."', '"
			.$breedCat->get_energy_level()."', '"
			.$breedCat->get_grooming()."', '"
			.$breedCat->get_health_issues()."', '"
			.$breedCat->get_intelligence()."', '"
			.$breedCat->get_shedding_level()."', '"
			.$breedCat->get_social_needs()."', '"
			.$breedCat->get_stranger_friendly()."', '"
			.$breedCat->get_vocalisation()."', '"
			.$breedCat->get_experimental()."', '"
			.$breedCat->get_hairless()."', '"
			.$breedCat->get_natural()."', '"
			.$breedCat->get_rare()."', '"
			.$breedCat->get_rex()."', '"
			.$breedCat->get_suppressed_tail()."', '"
			.$breedCat->get_short_legs()."', '"
			.$breedCat->get_wikipedia_url()."', '"
			.$breedCat->get_hypoallergenic()."', '"
			.$breedCat->get_weight()."', '"
			.$breedCat->get_date()."', '"
			.$breedCat->get_reference_image_id()."', '"
			.$breedCat->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($breedCat){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsBreedCatTable()){
            echo "BreedCat table not exists";
            die();
        }
		$sql="update breed_cat set id_name='"
			.$breedCat->get_id_name()."', name='"
			.$breedCat->get_name()."', name_es='"
			.$breedCat->get_name_es()."', cfa_url='"
			.$breedCat->get_cfa_url()."', vetstreet_url='"
			.$breedCat->get_vetstreet_url()."', vcahospitals_url='"
			.$breedCat->get_vcahospitals_url()."', temperament='"
			.$breedCat->get_temperament()."', temperament_es='"
			.$breedCat->get_temperament_es()."', origin='"
			.$breedCat->get_origin()."', origin_es='"
			.$breedCat->get_origin_es()."', country_codes='"
			.$breedCat->get_country_codes()."', country_code='"
			.$breedCat->get_country_code()."', description='"
			.$breedCat->get_description()."', description_es='"
			.$breedCat->get_description_es()."', morphology='"
			.$breedCat->get_morphology()."', morphology_es='"
			.$breedCat->get_morphology_es()."', life_span='"
			.$breedCat->get_life_span()."', indoor='"
			.$breedCat->get_indoor()."', lap='"
			.$breedCat->get_lap()."', alt_names='"
			.$breedCat->get_alt_names()."', adaptability='"
			.$breedCat->get_adaptability()."', affection_level='"
			.$breedCat->get_affection_level()."', child_friendly='"
			.$breedCat->get_child_friendly()."', cat_friendly='"
			.$breedCat->get_cat_friendly()."', dog_friendly='"
			.$breedCat->get_dog_friendly()."', energy_level='"
			.$breedCat->get_energy_level()."', grooming='"
			.$breedCat->get_grooming()."', health_issues='"
			.$breedCat->get_health_issues()."', intelligence='"
			.$breedCat->get_intelligence()."', shedding_level='"
			.$breedCat->get_shedding_level()."', social_needs='"
			.$breedCat->get_social_needs()."', stranger_friendly='"
			.$breedCat->get_stranger_friendly()."', vocalisation='"
			.$breedCat->get_vocalisation()."', experimental='"
			.$breedCat->get_experimental()."', hairless='"
			//.$breedCat->get_hairless()."', natural='"
			//.$breedCat->get_natural()."', rare='"
			.$breedCat->get_hairless()."', rare='"
			.$breedCat->get_rare()."', rex='"
			.$breedCat->get_rex()."', suppressed_tail='"
			.$breedCat->get_suppressed_tail()."', short_legs='"
			.$breedCat->get_short_legs()."', wikipedia_url='"
			.$breedCat->get_wikipedia_url()."', hypoallergenic='"
			.$breedCat->get_hypoallergenic()."', weight='"
			.$breedCat->get_weight()."', date='"
			.$breedCat->get_date()."', reference_image_id='"
			.$breedCat->get_reference_image_id()."', path_image='"
			.$breedCat->get_path_image()."', creator_id='"
			.$breedCat->get_creator_id()."' WHERE id='".$breedCat->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsBreedCatTable()){
            echo "BreedCat table not exists";
            die();
        }
        $sql="DELETE FROM breed_cat WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>