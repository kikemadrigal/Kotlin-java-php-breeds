<?php

class FishRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$fish=new Fish($linea['id']);
		$fish->set_name($linea['name']);
		$fish->set_name_es($linea['name_es']);
		$fish->set_specie_id($linea['specie_id']);
		$fish->set_path_image($linea['path_image']);
		$fish->set_date($linea['date']);
		$fish->set_creator_id($linea['creator_id']);
		return $fish;
	}
	
	public static function getById($id){
		$fish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $fish;
	}
	
	public static function getByName($name){
		$fish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish WHERE name LIKE '%".$name."%' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $fish;
	}
	public static function getByName_es($name_es){
		$fishs=array();
		$fish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish WHERE name_es LIKE '%".$name_es."%' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
			$fishs[]=$fish;
		}
		$basededatos->desconectar();
		//echo "obtenidos: ".count($fishs);
		return $fishs;
	}
		/**
	 * Esta función es utilizada en updateUser
	 */
	public static function getTitleById($id){
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT title FROM fish WHERE id='".$id."' ";
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


	public static function getRandom(){
		$fish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish ORDER BY RAND() LIMIT 1 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $fish;
	}

	/**
	 * Parametros:
	 * start registro de inicio
	 * end: maximos registros a buscar
	 */
	
	public static function getAll($init){
		$fishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish ORDER BY id LIMIT ".$init.", 10 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
			$fishs[]=$fish;
		}
		$basededatos->desconectar();
		return $fishs;
	}
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM fish";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}
	

	public static function getAllByUser($idUser, $start, $end){
		$fishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish WHERE creator_id='".$idUser."' limit ".$start .", ".$end."";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fish=self::asignarElementos($linea);
			$fishs[]=$fish;
		}
		$basededatos->desconectar();
		return $fishs;
	}



	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($fish){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsFishTable()){
			echo "fish table not exists";
			die();
		}
		$sql="INSERT INTO fish VALUES ( '', '"
			.$fish->get_name()."', '"
			.$fish->get_name_es()."', '"
			.$fish->get_specie_id()."', '"
			.$fish->get_path_image()."', '"
			.$fish->get_date()."', '"
			.$fish->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($fish){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsFishTable()){
            echo "Fish table not exists";
            die();
        }
		$sql="update fish set name='"
			.$fish->get_name()
			."', name_es='"
			.$fish->get_name_es()
			."', breed_id='"
			.$fish->get_specie_id()
			."', path_image='"
			.$fish->get_path_image()
			."', date='"
			.$fish->get_date()
			."', creator_id='"
			.$fish->get_creator_id()			
			."' WHERE id='".$fish->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsFishTable()){
            echo "Fish table not exists";
            die();
        }
        $sql="DELETE FROM fish WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>