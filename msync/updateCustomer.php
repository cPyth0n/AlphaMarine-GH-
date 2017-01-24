<?php

if($_SERVER["REQUEST_METHOD"]=="POST")
{

    //Getting Connection file
    require 'db_connect.php';

    //Function to Update Customer Data
    updateCustomer();
}
//Getting Values to DB in a table called "Main"
function updateCustomer()
{
    global $connect;

    $CustID = $_POST["CustID"];
    $Shipto = $_POST["Shipto"];
    $ReceFone = $_POST["ReceFone"];
    $Destination = $_POST["Destination"];
    $Nboxes = $_POST["Nboxes"];
    $Items = $_POST["Items"];
    $UnitCharge = $_POST["UnitCharge"];
    $Notes = $_POST["Notes"];
    $MDate = $_POST["MDate"];
    $ID = $_POST["ID"];
    // $FName = $_POST["FName"];
    //  $LName = $_POST["LName"];
    //  $PFone = $_POST["PFone"];
    //  $City = $_POST["City"];
    //  $State = $_POST["State"];


    $query = "UPDATE Main SET CustID='$CustID', Destination='$Destination', Nboxes='$Nboxes', Items='$Items', 
              UnitCharge='$UnitCharge', MDate='$MDate', Shipto='$Shipto', ReceFone='$ReceFone', Notes='$Notes' 
              WHERE ID=$ID;";


    if (mysqli_query($connect, $query)){

        echo 'Customer Updated Successfully';
    }
    else{

        echo 'Could Not Update Customer';
    }

    mysqli_close($connect);

}