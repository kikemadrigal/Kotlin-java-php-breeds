<?php

class CatRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$cat=new Cat($linea['id']);
		$cat->set_name($linea['name']);
		$cat->set_name_es($linea['name_es']);
		$cat->set_breed_id($linea['breed_id']);
		$cat->set_family($linea['family']);
		$cat->set_description($linea['description']);
		$cat->set_description_es($linea['description_es']);
		$cat->set_year_of_birth($linea['year_of_birth']);
		$cat->set_sex($linea['sex']);
		$cat->set_address($linea['address']);
		$cat->set_vaccines($linea['vaccines']);
		$cat->set_path_image($linea['path_image']);
		$cat->set_date($linea['date']);
		$cat->set_creator_id($linea['creator_id']);
		return $cat;
	}
	
	
	
	public static function getById($id){
		$cat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM cat WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			
			$cat=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $cat;
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


	public static function getRandom(){
		$cat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM cat ORDER BY RAND() LIMIT 1 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$cat=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $cat;
	}

	/**
	 * Parametros:
	 * start registro de inicio
	 * end: maximos registros a buscar
	 */
	
	public static function getAll($init){
		$cats=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM cat ORDER BY id LIMIT ".$init.", 10 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$cat=self::asignarElementos($linea);
			$cats[]=$cat;
		}
		$basededatos->desconectar();
		return $cats;
	}
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM cat";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}
	

	public static function getAllByUser($idUser, $start, $end){
		$cats=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM cat WHERE creator_id='".$idUser."' limit ".$start .", ".$end."";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$cat=self::asignarElementos($linea);
			$cats[]=$cat;
		}
		$basededatos->desconectar();
		return $cats;
	}
	public static function getByName($name){
		$cats=array();
		$breedCat=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM cat WHERE name LIKE '".$name."%'";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$breedCat=self::asignarElementos($linea);
			$cats[]=$breedCat;
		}
		$basededatos->desconectar();
		return $cats;
	}



	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($cat){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsCatTable()){
			echo "cat table not exists";
			die();
		}
		$sql="INSERT INTO cat VALUES ( '', '"
			.$cat->get_name()."', '"
			.$cat->get_name_es()."', '"
			.$cat->get_breed_id()."', '"
			.$cat->get_family()."', '"
			.$cat->get_description()."', '"
			.$cat->get_description_es()."', '"
			.$cat->get_year_of_birth()."', '"
			.$cat->get_sex()."', '"
			.$cat->get_address()."', '"
			.$cat->get_vaccines()."', '"
			.$cat->get_path_image()."', '"
			.$cat->get_date()."', '"
			.$cat->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($cat){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        /*if (!$bd->checkExitsCatTable()){
            echo "Cat table not exists";
            die();
        }*/
		$sql="update cat set name='"
			.$cat->get_name()
			."', name_es='"
			.$cat->get_name_es()
			."', breed_id='"
			.$cat->get_breed_id()
			."', family='"
			.$cat->get_family()
			."', description='"
			.$cat->get_description()
			."', description_es='"
			.$cat->get_description_es()
			."', year_of_birth='"
			.$cat->get_year_of_birth()
			."', sex='"
			.$cat->get_sex()
			."', address='"
			.$cat->get_address()
			."', vaccines='"
			.$cat->get_vaccines()
			."', path_image='"
			.$cat->get_path_image()
			."', date='"
			.$cat->get_date()
			."', creator_id='"
			.$cat->get_creator_id()			
			."' WHERE id='".$cat->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsCatTable()){
            echo "Cat table not exists";
            die();
        }
        $sql="DELETE FROM cat WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>