<?php

class ManejadorBD {

	private $db;
	private $host;
	private $user;
	private $pass;
	private $result;

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

			$qry = "SELECT * FROM ".$table."WHERE id=".$id;

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