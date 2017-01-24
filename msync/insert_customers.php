<?php

//Check Connectioon to DB with POST Request
if($_SERVER["REQUEST_METHOD"]=="POST")
{

    //Getting Connection file
    require 'db_connect.php';

    //Function to Create Customer Data
    createCustomerInfo();
}

//Posting Customer data to DB in a table called "Main"
function createCustomerInfo()
{
    global $connect;

    $CustID = $_POST["CustID"];
    $FName = $_POST["FName"];
    $LName = $_POST["LName"];
    $PFone = $_POST["PFone"];
    $City = $_POST["City"];
    $State = $_POST["State"];
    $Shipto = $_POST["Shipto"];
    $ReceFone = $_POST["ReceFone"];
    $Destination = $_POST["Destination"];
    $Nboxes = $_POST["Nboxes"];
    $Items = $_POST["Items"];
    $UnitCharge = $_POST["UnitCharge"];
    $Notes = $_POST["Notes"];


    $query = "INSERT INTO Main(CustID, FName, LName, Destination, Nboxes, Items, UnitCharge, MDate, PFone, City,
                                State, Shipto, ReceFone, Notes)
              VALUES ('$CustID', '$FName', '$LName', '$Destination', '$Nboxes', '$Items', '$UnitCharge', CURRENT_DATE,
                      '$PFone', '$City', '$State', '$Shipto', '$ReceFone', '$Notes');";

    if (mysqli_query($connect, $query)){

        echo 'Customer Added Successfully';
    }
    else{

        echo 'Could Not Add Customer';
    }

    mysqli_close($connect);

}




















    /** Other Placeholders for Later use in Main table
     *
    $PFone = $_POST["PFone"];
    $SFone = $_POST["SFone"];
    $City = $_POST["City"];
    $State = $_POST["State"];

    $Shipto = $_POST["Shipto"];
    $ReceFone = $_POST["ReceFone"];
    $UnitCharge = $_POST["UnitCharge"];
    $Notes = $_POST["Notes"];
     *
    */
