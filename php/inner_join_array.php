<?php

require 'ManejadorBD.php';
$qry = $_GET['qry'];

$m = new ManejadorBD();
$result = $m->findByQuery($qry);
echo json_encode($result,JSON_OBJECT_AS_ARRAY);

?>