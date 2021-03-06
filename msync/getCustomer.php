<?php

//This Script gets Info about One Customer

//Getting the requested id
$ID = $_GET['ID'];

//Importing database
require_once('db_connect.php');

//Creating sql query with where clause to get a specific customer
$sql = "SELECT * FROM Main WHERE ID=$ID;";

//getting result
$r = mysqli_query($connect,$sql);

//pushing result to an array
$result = array();
$row = mysqli_fetch_array($r);
array_push($result,array(
    "id"=>$row['ID'],
    "custid"=>$row['CustID'],
    "name"=>$row['FName'] ." ". $row['LName'],
    "desg"=>$row['Destination'],
    "amount"=>$row['UnitCharge']
));

//displaying in json format
echo json_encode(array('result'=>$result));

mysqli_close($connect);