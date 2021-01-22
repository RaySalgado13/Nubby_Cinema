<?php

class ManejadorBD {

	private $db;
	private $host;
	private $user;
	private $pass;
	private $result;
	private $id_table;

	function __construct() {
		$this->db = 'bgu9smpsgbze7uldszfh';
		$this->host = 'bgu9smpsgbze7uldszfh-mysql.services.clever-cloud.com';
		$this->user = 'u5hxsa95ooee2c9t';
		$this->pass = 'XKkP2VXnLok5u4Dh5ipd';

		$this->result = new \stdClass();
		$this->result->code = 200;
		$this->result->msg = 'Success';
		$this->result->output = array();
	}

	private function open() {
		$link = mysqli_connect($this->host, $this->user, $this->pass, $this->db) or die('Error connecting to DB');
		return $link;
	}

	private function close($link) {
		return mysqli_close($link);
	}

	public function showAll($table) {
		try {
			$link = $this->open();

			$qry = "SELECT * FROM ".$table;

			$r = mysqli_query($link, $qry);

			while( $result[] = mysqli_fetch_array( $r, MYSQLI_ASSOC ) );

			foreach ($result as $value) {
				if($value) {
					array_push($this->result->output, $value);
				}
			}

			$this->close($link);
		} catch (Exception $e) {
			$this->result->code = 500;
			$this->result->msg = 'Failed: '.$e;
		}

		return $this->result;
	}

	public function findByID($id,$table) {
		try {
			$link = $this->open();
			
			if($table == "usuarios"){
				$id_table = "usuario";
			}
			else if($table == "funciones"){
				$id_table = "funcion";
			} 
			else if($table == "boletos"){
				$id_table = "boleto";
			} 
			else if($table == "generos"){
				$id_table = "genero";
			} 
			else if($table == "peliculas"){
				$id_table = "pelicula";
			} 
			else if($table == "salas"){
				$id_table = "sala";
			} 
			else if($table == "sucursales"){
				$id_table = "sucursal";
			} 

			$qry = "SELECT * FROM ".$table." WHERE id_".$id_table." = ".$id;

			$r = mysqli_query($link, $qry);

			while( $result[] = mysqli_fetch_array( $r, MYSQLI_ASSOC ) );

			foreach ($result as $value) {
				if($value) {
					array_push($this->result->output, $value);
				}
			}

			$this->close($link);
		} catch (Exception $e) {
			$this->result->code = 500;
			$this->result->msg = 'Failed: '.$e;
		}

		return $this->result;
	}

	public function findUser($usuario,$clave) {
		try {
			$link = $this->open();
			
			$qry = "SELECT * FROM usuarios WHERE usuario = '".$usuario."' AND contrasenia = MD5('".$clave."')";

			$r = mysqli_query($link, $qry);
			
			while( $result[] = mysqli_fetch_array( $r, MYSQLI_ASSOC ) );

			foreach ($result as $value) {
				if($value) {
					array_push($this->result->output, $value);
				}
			}

			$this->close($link);
		} catch (Exception $e) {
			$this->result->code = 500;
			$this->result->msg = 'Failed: '.$e;
		}

		return $this->result;
	}
	
	public function findByQuery($qry) {
		try {
			$link = $this->open();
			//SELECT peliculas.nombre_pelicula, generos.genero FROM peliculas INNER JOIN generos ON peliculas.id_genero=generos.id_genero 
			//$qry = "SELECT ".$table1.".".$attr1.", ".$table2.".".$attr2." FROM ".$table1." INNER JOIN ".$table2." ON ".$table1."";
			//SELECT A.nombre_pelicula, B.genero FROM peliculas A INNER JOIN generos B ON A.id_genero = B.id_genero 
			

			$r = mysqli_query($link, $qry);
			
			while( $result[] = mysqli_fetch_array( $r, MYSQLI_ASSOC ) );

			foreach ($result as $value) {
				if($value) {
					array_push($this->result->output, $value);
				}
			}

			$this->close($link);
		} catch (Exception $e) {
			$this->result->code = 500;
			$this->result->msg = 'Failed: '.$e;
		}

		return $this->result;
	}

}

?>