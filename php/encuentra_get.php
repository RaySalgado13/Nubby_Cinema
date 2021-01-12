<?php

require 'ManejadorBD.php';
$id = $_GET['id'];
$table = $_GET['table'];

$m = new ManejadorBD();
$result = $m->findByID($id,$table);
echo json_encode($result,JSON_FORCE_OBJECT);

?>