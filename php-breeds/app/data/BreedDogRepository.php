<?php

class BreedDogRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$breedDog=new BreedDog($linea['id']);
		$breedDog->set_breed_id($linea['breed_id']);
		$breedDog->set_name($linea['name']);
		$breedDog->set_name_es($linea['name_es']);
		$breedDog->set_description($linea['description']);
		$breedDog->set_description_es($linea['description_es']);
		$breedDog->set_wiki_url($linea['wiki_url']);
		$breedDog->set_bred_for($linea['bred_for']);
		$breedDog->set_bred_for_es($linea['bred_for_es']);
		$breedDog->set_breed_group($linea['breed_group']);
		$breedDog->set_breed_group_es($linea['breed_group_es']);
		$breedDog->set_life_span($linea['life_span']);
		$breedDog->set_temperament($linea['temperament']);
		$breedDog->set_temperament_es($linea['temperament_es']);
		$breedDog->set_origin($linea['origin']);
		$breedDog->set_origin_es($linea['origin_es']);
		$breedDog->set_morphology($linea['morphology']);
		$breedDog->set_morphology_es($linea['morphology_es']);
		$breedDog->set_weight($linea['weight']);
		$breedDog->set_height($linea['height']);
		$breedDog->set_date($linea['date']);
		$breedDog->set_reference_image_id($linea['reference_image_id']);
		$breedDog->set_path_image($linea['path_image']);
		$breedDog->set_creator_id($linea['creator_id']);
		return $breedDog;
	}
	
	
	
	public static function getById($id){
		$breedDog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_dog WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			
			$breedDog=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $breedDog;
	}
	public static function getByBreedId($breed_id){
		$breedDog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_dog WHERE breed_id='".$breed_id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			
			$breedDog=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $breedDog;
	}
		/**
	 * Esta función es utilizada en updateUser
	 */
	public static function getTitleById($id){
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT title FROM breed_dog WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			return $linea['title'];
		}
		$basededatos->desconectar();
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
		$breedDogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_dog ORDER BY id LIMIT ".$init.", 10 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedDog=self::asignarElementos($linea);
			$breedDogs[]=$breedDog;
		}
		$basededatos->desconectar();
		return $breedDogs;
	}
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM breed_dog";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}
	

	public static function getAllByUser($idUser, $start, $end){
		$breedDogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_dog WHERE creator_id='".$idUser."' limit ".$start .", ".$end."";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedDog=self::asignarElementos($linea);
			$breedDogs[]=$breedDog;
		}
		$basededatos->desconectar();
		return $breedDogs;
	}

	public static function getByName_es($name_es){
		$breedDogs=array();
		$breedDog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM breed_dog WHERE name_es LIKE '%".$name_es."%'";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedDog=self::asignarElementos($linea);
			$breedDogs[]=$breedDog;
		}
		$basededatos->desconectar();
		return $breedDogs;
	}



	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($breedDog){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsBreedDogTable()){
			echo "breedDog table not exists";
			die();
		}
		$sql="INSERT INTO breed_dog VALUES ( '', '"
			.$breedDog->get_breed_id()."', '"
			.$breedDog->get_name()."', '"
			.$breedDog->get_name_es()."', '"
			.$breedDog->get_description()."', '"
			.$breedDog->get_description_es()."', '"
			.$breedDog->get_wiki_url()."', '"
			.$breedDog->get_bred_for()."', '"
			.$breedDog->get_bred_for_es()."', '"
			.$breedDog->get_breed_group()."', '"
			.$breedDog->get_breed_group_es()."', '"
			.$breedDog->get_life_span()."', '"
			.$breedDog->get_temperament()."', '"
			.$breedDog->get_temperament_es()."', '"
			.$breedDog->get_origin()."', '"
			.$breedDog->get_origin_es()."', '"
			.$breedDog->get_morphology()."', '"
			.$breedDog->get_morphology_es()."', '"
			.$breedDog->get_weight()."', '"
			.$breedDog->get_height()."', '"
			.$breedDog->get_date()."', '"
			.$breedDog->get_reference_image_id()."', '"
			.$breedDog->get_path_image()."', '"
			.$breedDog->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($breedDog){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsBreedDogTable()){
            echo "BreedDog table not exists";
            die();
        }
		$sql="update breed_dog "
			."set breed_id='"
			.$breedDog->get_breed_id()
			."', name='"
			.$breedDog->get_name()
			."', name_es='"
			.$breedDog->get_name_es()
			."', description='"
			.$breedDog->get_description()
			."', description_es='"
			.$breedDog->get_description_es()
			."', wiki_url='"
			.$breedDog->get_wiki_url()
			."', bred_for='"
			.$breedDog->get_bred_for()
			."', bred_for_es='"
			.$breedDog->get_bred_for_es()
			."', breed_group='"
			.$breedDog->get_breed_group()
			."', breed_group_es='"
			.$breedDog->get_breed_group_es()
			."', life_span='"
			.$breedDog->get_life_span()
			."', temperament='"
			.$breedDog->get_temperament()
			."', temperament_es='"
			.$breedDog->get_temperament_es()
			."', origin='"
			.$breedDog->get_origin()
			."', origin_es='"
			.$breedDog->get_origin_es()
			."', morphology='"
			.$breedDog->get_morphology()
			."', morphology_es='"
			.$breedDog->get_morphology_es()
			."', weight='"
			.$breedDog->get_weight()
			."', height='"
			.$breedDog->get_height()
			."', date='"
			.$breedDog->get_date()
			."', reference_image_id='"
			.$breedDog->get_reference_image_id()
			."', path_image='"
			.$breedDog->get_path_image()
			."', creator_id='"
			.$breedDog->get_creator_id()			
			."' WHERE id='".$breedDog->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsBreedDogTable()){
            echo "BreedDog table not exists";
            die();
        }
        $sql="DELETE FROM breed_dog WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>