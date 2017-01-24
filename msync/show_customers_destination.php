<?php

//This script get info about all customers by destination and dates

//Check Connectioon to DB with POST Request
if($_SERVER["REQUEST_METHOD"]=="POST")
{

    //Getting Connection file
    include 'db_connect.php';

    //Function to Create Customer Destination Data
    showByDestination();
}

//Function to select Customers by Destination
function showByDestination()
{
    global $connect;

    //Getting Inputs for Query based on lowest and highest Date and the preferred Destination
    $LowerDateStart = $_REQUEST["LowerDateStart"];
    $UpperDateEnd = $_REQUEST["UpperDateEnd"];
    $Destination = $_REQUEST["Destination"];

    $query = "SELECT ID, CustID, FName, LName, Destination, Nboxes, Items, MDate FROM Main WHERE (MDate 
              BETWEEN '$LowerDateStart' AND '$UpperDateEnd') AND Destination = '$Destination';";

    $request = mysqli_query($connect, $query);

   // $numberOfRows = mysqli_num_rows($result); //Get Number of rows in the Table
    $result = array(); //Array to hold the information from $number_of_rows

    //Checking if there are Rows in the table
    while($row = mysqli_fetch_array($request)){

    //Pushing name and id in the blank array created
    array_push($result,array(
        "id"=>$row['ID'],
        "name"=>$row['FName'] ." ". $row['LName'],
       // "tel"=>$row['PFone']
    ));
}
    //Specifying JSON format for data transfer
    header('Content-Type: application/json');
    echo json_encode(array("result" => $result));
    mysqli_close($connect);

}