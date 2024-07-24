<?php

class SpecieFishRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$specieFish=new SpecieFish($linea['id']);
		$specieFish->set_name($linea['name']);
		$specieFish->set_name_es($linea['name_es']);
		$specieFish->set_description($linea['description']);
		$specieFish->set_url_wiki($linea['url_wiki']);
		$specieFish->set_url_image($linea['url_image']);
		$specieFish->set_morphology($linea['morphology']);
		$specieFish->set_habitat($linea['habitat']);
		$specieFish->set_feeding($linea['feeding']);
		$specieFish->set_phylum($linea['phylum']);
		$specieFish->set_class($linea['class']);
		$specieFish->set_orden($linea['orden']);
		$specieFish->set_family($linea['family']);
		$specieFish->set_genus($linea['genus']);
		$specieFish->set_path_image($linea['path_image']);
		$specieFish->set_date($linea['date']);
		$specieFish->set_creator_id($linea['creator_id']);
		return $specieFish;
	}
	
	public static function getById($id){
		$specieFish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM specie_fish WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$specieFish=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $specieFish;
	}
	
	public static function getByName($name){
		$specieFishs=array();
		$specieFish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM specie_fish WHERE name LIKE '".$name."%' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$specieFish=self::asignarElementos($linea);
			$specieFishs[]=$specieFish;
		}
		$basededatos->desconectar();
		return $specieFishs;
	}
		/**
	 * Esta función es utilizada en updateUser
	 */
	public static function getTitleById($id){
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT title FROM specie_fish WHERE id='".$id."' ";
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
		$specieFish=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM specie_fish ORDER BY RAND() LIMIT 1 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$specieFish=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $specieFish;
	}

	/**
	 * Parametros:
	 * start registro de inicio
	 * end: maximos registros a buscar
	 */
	
	public static function getAll($init){
		$specieFishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM specie_fish ORDER BY id LIMIT ".$init.", 10 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$specieFish=self::asignarElementos($linea);
			$specieFishs[]=$specieFish;
		}
		$basededatos->desconectar();
		return $specieFishs;
	}
	
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM specie_fish";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}

	public static function getAllByUser($idUser, $start, $end){
		$specieFishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM specie_fish WHERE creator_id='".$idUser."' limit ".$start .", ".$end."";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$specieFish=self::asignarElementos($linea);
			$specieFishs[]=$specieFish;
		}
		$basededatos->desconectar();
		return $specieFishs;
	}



	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($specieFish){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsSpecieFishTable()){
			echo "specieFish table not exists";
			die();
		}
		$sql="INSERT INTO specie_fish VALUES ( '', '"
			.$specieFish->get_name()."', '"
			.$specieFish->get_name_es()."', '"
			.$specieFish->get_description()."', '"
			.$specieFish->get_url_wiki()."', '"
			.$specieFish->get_url_image()."', '"
			.$specieFish->get_morphology()."', '"
			.$specieFish->get_habitat()."', '"
			.$specieFish->get_feeding()."', '"
			.$specieFish->get_phylum()."', '"
			.$specieFish->get_class()."', '"
			.$specieFish->get_orden()."', '"
			.$specieFish->get_family()."', '"
			.$specieFish->get_genus()."', '"
			.$specieFish->get_path_image()."', '"
			.$specieFish->get_date()."', '"
			.$specieFish->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($specieFish){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsSpecieFishTable()){
            echo "SpecieFish table not exists";
            die();
        }
		$sql="update specie_fish set name='"
			.$specieFish->get_name()
			."', name_es='"
			.$specieFish->get_name_es()
			."', description='"
			.$specieFish->get_description()
			."', url_wiki='"
			.$specieFish->get_url_wiki()
			."', url_image='"
			.$specieFish->get_url_image()
			."', morphology='"
			.$specieFish->get_morphology()
			."', habitat='"
			.$specieFish->get_habitat()
			."', feeding='"
			.$specieFish->get_feeding()
			."', phylum='"
			.$specieFish->get_phylum()
			."', class='"
			.$specieFish->get_class()
			."', orden='"
			.$specieFish->get_orden()
			."', family='"
			.$specieFish->get_family()
			."', genus='"
			.$specieFish->get_genus()
			."', path_image='"
			.$specieFish->get_path_image()
			."', date='"
			.$specieFish->get_date()
			."', creator_id='"
			.$specieFish->get_creator_id()			
			."' WHERE id='".$specieFish->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsSpecieFishTable()){
            echo "SpecieFish table not exists";
            die();
        }
        $sql="DELETE FROM specie_fish WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>