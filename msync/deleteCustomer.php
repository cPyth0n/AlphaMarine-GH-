<?php

$ID = $_GET['ID'];

require_once ('db_connect.php');

$query = "DELETE FROM Main WHERE ID=$ID;";

if (mysqli_query($connect, $query)){

    echo 'Customer Deleted Successfully';
}
else{

    echo 'Could Not Delete Customer';
}

mysqli_close($connect);