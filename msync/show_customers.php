<?php

//Script to show all Customers Info

require_once('db_connect.php');

//Creating sql query
$query = "SELECT * FROM Main";

//getting result
$request = mysqli_query($connect,$query);

//creating a blank array
$result = array();

//looping through all the records fetched
while($row = mysqli_fetch_array($request)){

    //Pushing name and id in the blank array created
    array_push($result,array(
        "id"=>$row['ID'],
        "name"=>$row['FName'] ." ". $row['LName'],
       // "tel"=>$row['PFone']
    ));
}

//Displaying the array in json format
header('Content-Type: application/json');
echo json_encode(array('result'=>$result));

mysqli_close($connect);





































/**
//Check Connectioon to DB with POST Request
if($_SERVER["REQUEST_METHOD"]=="POST")
{

    //Getting Connection file
    include 'db_connect.php';

    //Function to Create Customer Data
    showCustomerInfo();
}

//Function for selecting All Customers from the table "Main"
function showCustomerInfo()
{
    global $connect;

    $query = "SELECT * FROM Main;";
    $result = mysqli_query($connect, $query);

    $number_of_rows = mysqli_num_rows($result); //Get Number of rows in the Table
    $temp_array = array(); //Array to hold the information from result

    //Checking if there are Rows in the table
    if($number_of_rows > 0)
    {
        //While there are Rows, Fill the Array with Selected Row
        while ($row = mysqli_fetch_assoc($result))
        {
            $temp_array[] = $row;
        }
    }
    //Specifying JSON format for data transfer
    header('Content-Type: application/json');
    echo json_encode(array("Customers" => $temp_array));
    mysqli_close($connect);


} */
