<?php

class DogRepository{ 



	/**********************************************************************************************
	* 										SELECT
	**********************************************************************************************/
	private static function asignarElementos($linea){
		$dog=new Dog($linea['id']);
		$dog->set_name($linea['name']);
		$dog->set_name_es($linea['name_es']);
		$dog->set_breed_id($linea['breed_id']);
		$dog->set_family($linea['family']);
		$dog->set_description($linea['description']);
		$dog->set_description_es($linea['description_es']);
		$dog->set_year_of_birth($linea['year_of_birth']);
		$dog->set_sex($linea['sex']);
		$dog->set_address($linea['address']);
		$dog->set_vaccines($linea['vaccines']);
		$dog->set_points($linea['points']);
		$dog->set_total_points($linea['total_points']);
		$dog->set_path_image($linea['path_image']);
		$dog->set_validate($linea['validate']);
		$dog->set_date($linea['date']);
		$dog->set_creator_id($linea['creator_id']);
		return $dog;
	}
	
	
	
	public static function getById($id){
		$dog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $dog;
	}
		/**
	 * Esta función es utilizada en updateUser
	 */
	public static function getTitleById($id){
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT title FROM dog WHERE id='".$id."' ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			return $linea['title'];
		}
		$basededatos->desconectar();
	}

	public static function getRandom(){
		$dog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog ORDER BY RAND() LIMIT 1 ";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
		}
		$basededatos->desconectar();
		return $dog;
	}

	/**
	 * Parametros:
	 * start registro de inicio
	 * end: maximos registros a buscar
	 */
	
	public static function getAll($init){
		$dogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog ORDER BY id LIMIT ".$init.", 10";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}

	public static function getRanking($init){
		$dogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog ORDER BY total_points DESC LIMIT ".$init.", 10";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}
	public static function getMax3Beauties(){
		$dogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog ORDER BY total_points DESC LIMIT 3";
		$resultado=$basededatos->ejecutar_sql($consulta);
		if(is_null($resultado))echo "resultado es null";
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}
	public static function getCountRows(){
		$rowCount=0;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT count(*) FROM dog";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$rowCount =  $linea['count(*)']; 
		}
		$basededatos->desconectar();
		return $rowCount;
	}

	public static function getByName($name){
		$dogs=array();
		$dog=null;
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog WHERE name LIKE '".$name."%'";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}
	

	public static function getAllByUser($idUser, $init){
		$dogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog WHERE creator_id='".$idUser."' LIMIT ".$init.", 10";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}
	public static function getLastFive(){
		$dogs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM dog ORDER BY id DESC LIMIT 5";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$dog=self::asignarElementos($linea);
			$dogs[]=$dog;
		}
		$basededatos->desconectar();
		return $dogs;
	}


	/*
	INSERT INTO gamesUsers VALUES ( '', 'title', 'Cove', 'Instructions', 'Country()', 'Publisher', 'Developer', 'Year', 'Format', 'Genre', 'System', 'Programming', 'Sound', 'Control', '1', 'Languages', '1', '1', '1', '1', '1', '0' , 'Observations', '186');
	*/
	public static function insert($dog){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		if (!$bd->checkExitsDogTable()){
			echo "dog table not exists";
			die();
		}
		$sql="INSERT INTO dog VALUES ( '', '"
			.$dog->get_name()."', '"
			.$dog->get_name_es()."', '"
			.$dog->get_breed_id()."', '"
			.$dog->get_family()."', '"
			.$dog->get_description()."', '"
			.$dog->get_description_es()."', '"
			.$dog->get_year_of_birth()."', '"
			.$dog->get_sex()."', '"
			.$dog->get_address()."', '"
			.$dog->get_vaccines()."', '"
			.$dog->get_points()."', '"
			.$dog->get_total_points()."', '"
			.$dog->get_path_image()."', '"
			.$dog->get_validate()."', '"
			.$dog->get_date()."', '"
			.$dog->get_creator_id()."', '"
			."') ";		
		$success=$bd->ejecutar_sql($sql);
		$bd->desconectar();
		return $success;
	}


	public static function update($dog){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsDogTable()){
            echo "Dog table not exists";
            die();
        }
		$sql="update dog set name='"
			.$dog->get_name()
			."', name_es='"
			.$dog->get_name_es()
			."', breed_id='"
			.$dog->get_breed_id()
			."', family='"
			.$dog->get_family()
			."', description='"
			.$dog->get_description()
			."', description_es='"
			.$dog->get_description_es()
			."', year_of_birth='"
			.$dog->get_year_of_birth()
			."', sex='"
			.$dog->get_sex()
			."', address='"
			.$dog->get_address()
			."', vaccines='"
			.$dog->get_vaccines()
			."', points='"
			.$dog->get_points()
			."', total_points='"
			.$dog->get_total_points()
			."', path_image='"
			.$dog->get_path_image()
			."', validate='"
			.$dog->get_validate()
			."', date='"
			.$dog->get_date()
			."', creator_id='"
			.$dog->get_creator_id()			
			."' WHERE id='".$dog->get_id()."'";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }


	public static function updateBeauty($id_dog, $new_points){
		$dog=self::getById($id_dog);
		$total_points=$dog->get_total_points();
		$total_points++;
		$points=$new_points/$total_points;	
		$bd= new MysqliClient();
        $bd->conectar_mysql();
		$sql="update dog set points='"
		.$points
		."', total_points='"
		.$total_points
		."' WHERE id='".$id_dog."'";
		$bd->ejecutar_sql($sql);
        $bd->desconectar();
	}

	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        if (!$bd->checkExitsDogTable()){
            echo "Dog table not exists";
            die();
        }
        $sql="DELETE FROM dog WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
    }
}
?>