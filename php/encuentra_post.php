<?php

require 'ManejadorBD.php';
$id = $_POST['id'];
$table = $_POST['table'];

$m = new ManejadorBD();
$result = $m->findByID($id,$table);
echo json_encode($result,JSON_FORCE_OBJECT);
?>