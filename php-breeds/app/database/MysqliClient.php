﻿<?php
class MysqliClient{
	private $servidor;
	private $usuario;
	private $password;
	private $base_de_datos;
	private $resultado;
	public $msqli;

	public function __construct(){
		$this->servidor=SERVER;
		$this->usuario=USER;
		$this->password=PASSWORD;
		$this->base_de_datos=DATABASE;


	}
	/* Realliza la conexión a la base de datos */
	public function conectar_mysql(){
        	$this->msqli = new mysqli($this->servidor, $this->usuario, $this->password,$this->base_de_datos);
        	$this->msqli->query("SET NAMES 'utf8'");
			//$this->mysqli_result=new mysqli_result();
			if($this->msqli->connect_errno){
				echo "<p>Error al conectar con el servidor.</p>";
				//die (“ERROR AL CONECTAR MYSQL”);
			}

	}

	public function getMysqliObject(){
		return $this->msqli;
	}

	public function getTables(){
		$tables=array();
		$resultado = $this->msqli->query("SHOW TABLES");
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$tables[]= $linea[0];
		}
		return $tables;
	}

	public function checkExitsBreedCatTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="breed_cat"){
				return true;
			}
		}
		return false;
	}
	public function checkExitsBreedDogTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="breed_dog"){
				return true;
			}
		}
		return false;
	}
	public function checkExitsCatTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="cat"){
				return true;
			}
		}
		return false;
	}
	public function checkExitsSpecieFishTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="specie_fish"){
				return true;
			}
		}
		return false;
	}
	public function checkExitsDogTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="dog"){
				return true;
			}
		}
		return false;
	}
	public function checkExitsFishTable(){
		$tables=$this->getTables();
		foreach($tables as $posicion=>$table){
			if ($table=="fish"){
				return true;
			}
		}
		return false;
	}



	/*metodo para ejecutar una secuencia sql*/
	public function ejecutar_sql($sql){
		//envía una única consulta a la base de datos actualmente activa en el servidor 
		$this->resultado=$this->msqli->query($sql);
		if (!$this->resultado) {
			echo "<p>Error al ejecutar la consulta</p>";
			$this->resultado=NULL;
		}
		return $this->resultado;
	}

	public function update_dog($sql){
		$statement=$this->msqli->prepare($sql);
		$sql = "INSERT INTO games (id,title,cover,publisher,developer,year,system,user)  VALUES (?,?,?,?,?,?,?,92)";
        $stmt= self::$db->prepare($sql);
        $stmt->execute([$game->GameID, $game->GameName, $game->GenMSXId,$game->CompanyID1,$game->CompanyID2,$game->Year,$game->Platform]);
        
           
	}
	public function insert($sql){
		//envía una única consulta a la base de datos actualmente activa en el servidor 
		//$sql=$this->msqli->real_escape_string($sql);
		$this->resultado=$this->msqli->query($sql);
		if (!$this->resultado) {
			echo "<p>Error al ejecutar la consulta</p>";
			$this->resultado=NULL;
		}
		return $this->resultado;
	}
	public function getInsertId(){
		return $this->msqli->insert_id;
		
	}
	public function deleteTableGames(){
		if($this->msqli->query("DROP TABLE games")){
			echo "<p>tabla borrada</p>";
		}else{
			echo "<p>no se pudo borrar</p>";
		}
	}



	public function getStringInsertTableGamesUsers(){
		$contador=0;
		$consulta="INSERT INTO 'gamesUsers' VALUES ";
		$resultado2 = $this->msqli->query("SELECT * FROM gamesUsers");
		$rows=$this->msqli->affected_rows;
		if($rows<=0) return "";
		while ($linea = mysqli_fetch_array($resultado2)) 
		{
			$contador++;
			$consulta .="<br>&nbsp;&nbsp;&nbsp;&nbsp;(";
			$consulta .=$linea['id'].",";
			$consulta .="'".$linea['title']."',";
			$consulta .="".$linea['cover'].",";
			$consulta .="'".$linea['instructions']."',";
			$consulta .="'".$linea['country']."',";
			$consulta .="'".$linea['publisher']."',";
			$consulta .="'".$linea['developer']."',";
			$consulta .="".$linea['year'].",";
			$consulta .="'".$linea['format']."',";
			$consulta .="'".$linea['genre']."',";
			$consulta .="'".$linea['system']."',";
			$consulta .="'".$linea['programming']."',";
			$consulta .="'".$linea['sound']."',";
			$consulta .="'".$linea['control']."',";
			$consulta .="".$linea['players'].",";
			$consulta .="'".$linea['languages']."',";
			$consulta .="".$linea['iGoIt'].",";
			$consulta .="".$linea['broken'].",";
			if($contador==$rows) $consulta .="'".$linea['observations']."');<br><br>";
			else $consulta .="'".$linea['observations']."'),";
		}        
		return $consulta;	
	}
	
		
	
	
	//Desconectar y liberar
	public function desconectar(){
		//$this->resultado->free();
		$this->msqli->close();
	}

}

?>