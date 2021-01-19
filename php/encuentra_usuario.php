<?php

require 'ManejadorBD.php';
$usuario = $_POST['usuario'];
$clave = $_POST['clave'];

$m = new ManejadorBD();
$result = $m->findUser($usuario,$clave);
echo json_encode($result,JSON_FORCE_OBJECT);

?>