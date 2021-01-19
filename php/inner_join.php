<?php

require 'ManejadorBD.php';
$qry = $_POST['qry'];

$m = new ManejadorBD();
$result = $m->InnerJoin($qry);
echo json_encode($result,JSON_FORCE_OBJECT);

?>