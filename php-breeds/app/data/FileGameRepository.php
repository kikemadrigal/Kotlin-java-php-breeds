<?php
class FileGameRepository {
	public static function getAllByGame($idGame){
		//echo "<h1>".$idGame."</h1>";
		$filesGames=array();
		//echo "<h1>".$idGame."</h1>";
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM filesGames WHERE game='".$idGame."' ORDER BY name";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$fileGame=new FileGame($linea['id']);
			$fileGame->setName($linea['name']);
			$fileGame->setPath($linea['path']);
			$fileGame->setGame($linea['game']);

			$filesGames[]=$fileGame;
		}
		$basededatos->desconectar();
		return $filesGames;
	}
	public static function getPath($idFile){
		$path="";
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT path FROM filesGames WHERE id='".$idFile."' LIMIT 1";
		$resultado=$basededatos->ejecutar_sql($consulta);
		while ($linea = mysqli_fetch_array($resultado)) 
		{
			$path=$linea['path'];
		}
		$basededatos->desconectar();
		return $path;
	}
	public static function getRanking($init){
		$fishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT * FROM fish ORDER BY total_points DESC LIMIT ".$init.", 10";
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
	public static function getMax3Beauties(){
		$fishs=array();
		$basededatos= new MysqliClient();
		$basededatos->conectar_mysql();
		$consulta  = "SELECT MAX(total_points) FROM fish ORDER BY total_points DESC LIMIT 3";
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
	public static function insert($game){
		$bd= new MysqliClient();
		$bd->conectar_mysql();
		echo $game->getName()."', '".$game->getPath()."', '".$game->getGame();
        $sql="INSERT INTO filesGames VALUES ( '', '".$game->getName()."', '".$game->getPath()."', '".$game->getGame()."') ";
        //$bd->ejecutar_sql(addslashes($sql));
        $bd->ejecutar_sql($sql);
		$bd->desconectar();
	}


	public static function updateBeauty($id_fish, $new_points){
		$fish=self::getById($id_fish);
		$total_points=$fish->get_total_points();
		$total_points++;
		$points=$new_points/$total_points;	
		$bd= new MysqliClient();
        $bd->conectar_mysql();
		$sql="update fish set points='"
		.$points
		."', total_points='"
		.$total_points
		."' WHERE id='".$id_fish."'";
		$bd->ejecutar_sql($sql);
        $bd->desconectar();
	}
	public static function delete($id){
        $bd= new MysqliClient();
        $bd->conectar_mysql();
        $sql="DELETE FROM filesGames WHERE id='".$id."' LIMIT 1";
        $bd->ejecutar_sql($sql);
        $bd->desconectar();
	}

}